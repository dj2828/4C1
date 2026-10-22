import java.util.Scanner;

public class Es3 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // numero corse
        System.out.print("Quante corse? ");
        int n = input.nextInt();
        input.nextLine();

        // init arrays
        String[] destinazioni = new String[n];
        int[] passeggeri = new int[n];
        float[] prezzo = new float[n];

        // riempimento arrays
        for (int i=0; i<n; i++) {
            System.out.println(i + ":");
            System.out.print("\tDestinazione: ");
            destinazioni[i] = input.nextLine();
            System.out.print("\tN passeggeri: ");
            passeggeri[i] = input.nextInt();
            System.out.print("\tPrezzo biglietto: ");
            prezzo[i] = input.nextFloat();
            input.nextLine();
        }

        while (true) {
            System.out.print("""
                \n1) Print
                2) Cerca
                3) Edit destinazione
                4) Edit passeggeri
                5) Edit prezzo
                6) Cancella corsa
                7) Incasso
                8) Max prezzo
                9) Exit
                """);
            System.out.print("? ");
            int scelta;
            try {
                scelta = input.nextInt();
            } catch (Exception e) {
                System.out.println("Inserisci un int");
                continue;
            } finally {
                input.nextLine();
            }

            if (scelta == 1) {
                for (int i = 0; i < n; i++) {
                    System.out.println(destinazioni[i] + " | " + passeggeri[i] + " passeggeri | " + prezzo[i] + "€");
                }
            } else if (scelta == 2) {
                System.out.print("Query: ");
                String query = input.nextLine();

                int trovato = -1;
                for (int i = 0; i < n; i++) {
                    if (destinazioni[i].equalsIgnoreCase(query)) {
                        trovato = i;
                    }
                }

                if (trovato == -1) {
                    System.out.println("Non trovato");
                    continue;
                }

                System.out.println(destinazioni[trovato] + " | " + passeggeri[trovato] + " passeggeri | " + prezzo[trovato] + "€");
            } else if (scelta == 3) {
                // print corse
                for (int i = 0; i < n; i++) {
                    System.out.println(i + ": " + destinazioni[i] + " | " + passeggeri[i] + " passeggeri | " + prezzo[i] + "€");
                }
                int s = input.nextInt();
                input.nextLine();

                // inserimento nuova destinazione
                System.out.print("New destinazione: ");
                destinazioni[s] = input.nextLine();
            } else if (scelta == 4) {
                // print corse
                for (int i = 0; i < n; i++) {
                    System.out.println(i + ": " + destinazioni[i] + " | " + passeggeri[i] + " passeggeri | " + prezzo[i] + "€");
                }
                int s = input.nextInt();
                input.nextLine();

                // inserimento nuovi passeggeri
                System.out.print("New passeggeri: ");
                passeggeri[s] = input.nextInt();
                input.nextLine();
            } else if (scelta == 5) {
                // print corse
                for (int i = 0; i < n; i++) {
                    System.out.println(i + ": " + destinazioni[i] + " | " + passeggeri[i] + " passeggeri | " + prezzo[i] + "€");
                }
                int s = input.nextInt();
                input.nextLine();

                // inserimento prezzo nuovo
                System.out.print("New prezzo: ");
                prezzo[s] = input.nextFloat();
                input.nextLine();
            } else if (scelta == 6) {
                // print corse
                for (int i = 0; i < n; i++) {
                    System.out.println(i + ": " + destinazioni[i] + " | " + passeggeri[i] + " passeggeri | " + prezzo[i] + "€");
                }
                int s = input.nextInt();
                input.nextLine();

                // sposta quello dopo in quello prima partendo da quello da cancellare
                for (int i = s; i < n - 1; i++) {
                    destinazioni[i] = destinazioni[i+1];
                    passeggeri[i] = passeggeri[i+1];
                    prezzo[i] = prezzo[i+1];
                }
                // decrementa n
                n--;
            } else if (scelta == 7) {
                float somma = 0;
                for (int i = 0; i < n; i++) {
                    somma += prezzo[i] * passeggeri[i];
                }
                System.out.println("Incasso tot: " + somma);
            } else if (scelta == 8) {
                float max = prezzo[0] * passeggeri[0];
                int imax = 0;
                for (int i = 0; i < n; i++) {
                    if (prezzo[i]*passeggeri[i] > max) {
                        max = prezzo[i] * passeggeri[i];
                        imax = i;
                    }
                }
                System.out.println("Incasso max: " + destinazioni[imax] + " | " + passeggeri[imax] + " passeggeri | " + prezzo[imax] + "€");
            } else if (scelta == 9) {
                break;
            }
        }

        input.close();
    }
}
