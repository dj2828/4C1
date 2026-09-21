import java.util.Scanner;

public class Es2 {
    static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            System.out.println(i);
        }

        int i=1;
        while (i<=5) {
            System.out.println(i);
            i++;
        }

        Scanner input = new Scanner(System.in);
        int scelta;
        do {
            System.out.println("""
                0) Esci
                1) Saluta
                2) Mostra un messaggio
                3) Visualizza un numero
            """);
            scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Ciao");
                    break;
                case 2:
                    System.out.println("Sto imparando Java");
                    break;
                case 3:
                    System.out.println("4");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);

        input.close();
    }
}
