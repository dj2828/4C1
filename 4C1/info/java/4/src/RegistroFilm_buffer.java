import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegistroFilm_buffer {
    static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Quanti film? ");
        int SIZE = Integer.parseInt(input.readLine());
        String[] titolo = new String[SIZE];
        String[] regista = new String[SIZE];
        String[] genere = new String[SIZE];
        float[] voto = new float[SIZE];

        for(int i=0; i<SIZE; i++) {
            System.out.print("Titolo: ");
            titolo[i] = input.readLine();
            System.out.print("Regista: ");
            regista[i] = input.readLine();
            System.out.print("Genere: ");
            genere[i] = input.readLine();
            System.out.print("Voto (1-10): ");
            voto[i] = Float.parseFloat(input.readLine());
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
            scelta = Integer.parseInt(input.readLine());

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
                System.out.print("Cerca: ");
                String query = input.readLine();

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
