import java.util.Scanner;

public class Bancomat {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int soldi = 500;
        int scelta;
        int operazioni_effettuate = 0;
        int tot_depo = 0, tot_prel = 0;
        do {
            System.out.print("""
                ======== BANCOMAT ========
                    1. Visualizza saldo
                    2. Preleva denaro
                    3. Deposita denaro
                    4. Esci
                """);
            scelta = input.nextInt();
            if (scelta == 1) {
                System.out.println("Saldo: " + soldi);
            } else if (scelta == 2) {
                boolean ok = false;
                int preleva = 0;
                while (!ok) {
                    try {
                        System.out.print("Importo: ");
                        preleva = input.nextInt();
                        ok = true;
                    } catch (Exception e) {
                        System.out.println("Errore");
                        input.nextLine();
                    }
                }
                if (preleva <= 0 || preleva > soldi) System.out.println("ERRORE: errore");
                else {
                    soldi -= preleva;
                    tot_prel += preleva;
                    operazioni_effettuate++;
                    System.out.println("Prelevato: " + preleva + "\nSaldo attuale: " + soldi);
                }
            } else if (scelta == 3) {
                boolean ok = false;
                int deposito = 0;
                while (!ok) {
                    try {
                        System.out.print("Importo: ");
                        deposito = input.nextInt();
                        ok = true;
                    } catch (Exception e) {
                        System.out.println("Errore");
                        input.nextLine();
                    }
                }
                if (deposito <= 0) System.out.println("ERRORE: errore");
                else {
                    soldi += deposito;
                    tot_depo += deposito;
                    operazioni_effettuate++;
                    System.out.println("Depositato: " + deposito + "\nSaldo attuale: " + soldi);
                }
            }
        } while (scelta != 4);
        System.out.println("Saldo totale: " + soldi);
        System.out.println("Deposito totale: " + tot_depo);
        System.out.println("Prelievo totale: " + tot_prel);
        System.out.println("N operazioni: " + operazioni_effettuate);

        input.close();
    }
}