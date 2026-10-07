import java.util.Scanner;

public class RegistroFilm {
    static String askString(String text) {
        Scanner input = new Scanner(System.in);
        System.out.print(text);
        while (true) {
            try {
                return input.nextLine();
            } catch (Exception e) {
                System.out.println("ERRORE: " + e);
            }
        }
    }
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Quanti film? ");
        int SIZE = input.nextInt();
        String[] titolo = new String[SIZE];
        String[] regista = new String[SIZE];
        String[] genere = new String[SIZE];
        float[] voto = new float[SIZE];

        for(int i=0; i<SIZE; i++) {
            input.nextLine();
            titolo[i] = askString("Titolo: ");
            regista[i] = askString("Regista: ");
            genere[i] = askString("Genere: ");
            System.out.print("Voto (1-10): ");
            voto[i] = askFloat("Voto (1-10): ");
        }

        int scelta = 0;
        do {
            System.out.print("""
                \n1) print
                2) cerca
                3) media
                4) tabella
                5) exit
                """);
            System.out.print("? ");
            scelta = input.nextInt();

            if (scelta == 1) {
                for (int i = 0; i < SIZE; i++) {
                    System.out.println(i + ":");
                    System.out.println("\tTitolo: " + titolo[i]);
                    System.out.println("\tRegista: " + regista[i]);
                    System.out.println("\tGenere: " + genere[i]);
                    System.out.println("\tVoto: " + voto[i]);
                }
            }

            if (scelta == 2) {
                input.nextLine();
                System.out.print("Cerca: ");
                String query = input.nextLine();

                int i_found = 0;
                for (int i = 1; i <= SIZE; i++) {
                    if (titolo[i - 1].equalsIgnoreCase(query)) {
                        i_found = i;
                        break;
                    }
                }
                if (i_found == 0) {
                    System.out.println("Non trovato");
                } else {
                    System.out.println("Trovato:");
                    System.out.println("\tTitolo: " + titolo[i_found - 1]);
                    System.out.println("\tRegista: " + regista[i_found - 1]);
                    System.out.println("\tGenere: " + genere[i_found - 1]);
                    System.out.println("\tVoto: " + voto[i_found - 1]);
                }
            }

            if (scelta == 3) {
                float tot = 0;
                for (int i = 0; i < SIZE; i++)
                    tot += voto[i];
                float media = tot / SIZE;
                System.out.println("Media: " + media);
            }

            if (scelta == 4) {
                System.out.println();
                System.out.printf("%-10s %-10s %-10s %-10s%n", "Titolo", "Regista", "Genere", "Voto");
                for (int i = 0; i < SIZE; i++)
                    System.out.printf("%-10s %-10s %-10s %-10s%n", titolo[i], regista[i], genere[i], voto[i]);
            }
        } while (scelta != 5);
    }
}
