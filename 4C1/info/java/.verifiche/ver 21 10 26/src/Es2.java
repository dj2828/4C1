import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Es2 {
    static void main(String[] args) throws IOException {
        String[] nomi = {"Marco", "Anna", "Luca", "Sara", "Paolo"};
        int[] punti = {72, 91, 65, 88, 79};

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("""
                \n1) Visualizzare i partecipanti
                2) Somma dei punti
                3) Media punteggi
                4) +80 punti
                5) Max punteggio
                6) Maggiore della media
                7) Exit
                """);
            int scelta;
            try {
                // input scelta
                System.out.print("? ");
                scelta = Integer.parseInt(input.readLine());
            } catch (Exception e) {
                System.out.println("Inserire un int");
                continue;
            }

            if (scelta == 1) {
                // print dei partecipanti
                for (int i = 0; i < nomi.length; i++) {
                    System.out.println(nomi[i] + ": " + punti[i] + " punti");
                }
            } else if (scelta == 2) {
                // somma
                int somma = 0;
                for (int i: punti) {
                    somma += i;
                }
                System.out.println("Somma punti: " + somma);
            } else if (scelta == 3) {
                // somma
                int somma = 0;
                for (int i: punti) {
                    somma += i;
                }
                // media
                float media = (float) (somma / punti.length);
                System.out.println("Media: " + media);
            } else if (scelta == 4) {
                int piu_di_80 = 0;
                for(int i: punti) {
                    if (i >= 80) {
                        piu_di_80++;
                    }
                }
                System.out.println("Partecipanti con almeno 80 punti: " + piu_di_80);
            } else if (scelta == 5) {
                int max = punti[0];
                int imax = 0;
                for (int i = 0; i < nomi.length; i++) {
                    if (punti[i] > max) {
                        max = punti[i];
                        imax = i;
                    }
                }
                System.out.println("Max: " + nomi[imax] + " " + punti[imax]);
            } else if (scelta == 6) {
                // somma
                int somma = 0;
                for (int i: punti) {
                    somma += i;
                }
                // media
                float media = (float) (somma / punti.length);
                System.out.println("Media: " + media);

                for (int i = 0; i < nomi.length; i++) {
                    if (punti[i] > media) {
                        System.out.println(nomi[i] + ": " + punti[i]);
                    }
                }
            } else if (scelta == 7) {
                break;
            }
        }
    }
}
