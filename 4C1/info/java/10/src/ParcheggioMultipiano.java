import java.io.*;
import java.util.Random;

public class ParcheggioMultipiano {
    static final String RED = "\033[0;31m";
    static final String GREEN = "\033[0;32m";
    static final String RESET = "\033[0m";

    static void print(int[][] mat) {
        for (int[] i: mat) {
            for (int j: i) {
                if (j == 0) System.out.print(GREEN + j + " ");
                else System.out.print(RED + j + " ");
            }
            System.out.println(RESET);
        }
    }

    static void main(String[] args) throws IOException {
        Random random = new Random();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[][] mat = new int[5][6];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = random.nextInt(2);
            }
        }

        int scelta;
        do {
            System.out.print("""
                \n1. visualizzare il parcheggio completo;
                2. visualizzare il numero di posti liberi di ogni piano;
                3. visualizzare il numero di posti occupati di ogni piano;
                4. individuare il piano con più posti occupati;
                5. individuare il piano con più posti liberi;
                6. occupare un posto scelto dall’utente;
                7. liberare un posto scelto dall’utente;
                8. chiedere all’utente un piano, cercare il primo posto libero e occuparlo automaticamente;
                9. verificare se un piano scelto dall’utente è completamente pieno;
                10. visualizzare il numero totale di posti ancora disponibili;
                11. uscire.
                ?\s""");
            scelta = Integer.parseInt(input.readLine());

            if (scelta == 1) {
                print(mat);
            } else if (scelta == 2) {
                for (int i=0; i<mat.length; i++) {
                    int liberi = 0;
                    for (int j: mat[i]) if (j == 0) liberi++;
                    System.out.println("Piano " + i + " liberi " + liberi + " posti");
                }
            } else if (scelta == 3) {
                for (int i=0; i<mat.length; i++) {
                    int occupati = 0;
                    for (int j: mat[i]) if (j == 1) occupati++;
                    System.out.println("Piano " + i + " occupati " + occupati + " posti");
                }
            } else if (scelta == 4) {
                int max = 0, maxi = 0;
                for (int i=0; i<mat.length; i++) {
                    int occupati = 0;
                    for (int j: mat[i]) if (j == 1) occupati++;
                    if (i == 0) {
                        max = occupati;
                    } else {
                        if (occupati > max) {
                            max = occupati;
                            maxi = i;
                        }
                    }
                }
                System.out.println("Piano con piu posti occupati: " + maxi);
            } else if (scelta == 5) {
                int max = 0, maxi = 0;
                for (int i=0; i<mat.length; i++) {
                    int liberi = 0;
                    for (int j: mat[i]) if (j == 1) liberi++;
                    if (i == 0) {
                        max = liberi;
                    } else {
                        if (liberi > max) {
                            max = liberi;
                            maxi = i;
                        }
                    }
                }
                System.out.println("Piano con piu posti liberi: " + maxi);
            } else if (scelta == 6) {
                print(mat);
                System.out.println("Dove?");
                System.out.print(" Piano: ");
                int piano = Integer.parseInt(input.readLine());
                if (piano < 0 || piano > mat.length-1) continue;
                System.out.print(" Posto: ");
                int posto = Integer.parseInt(input.readLine());
                if (posto < 0 || posto > mat[0].length-1) continue;
                if (mat[piano][posto] == 1) {
                    System.out.println("Posto gia occupato");
                    continue;
                }
                mat[piano][posto] = 1;
            } else if (scelta == 7) {
                print(mat);
                System.out.println("Dove?");
                System.out.print(" Piano: ");
                int piano = Integer.parseInt(input.readLine());
                if (piano < 0 || piano > mat.length-1) continue;
                System.out.print(" Posto: ");
                int posto = Integer.parseInt(input.readLine());
                if (posto < 0 || posto > mat[0].length-1) continue;
                if (mat[piano][posto] == 0) {
                    System.out.println("Posto gia libero");
                    continue;
                }
                mat[piano][posto] = 0;
            } else if (scelta == 8) {
                System.out.print("Piano? ");
                int query = Integer.parseInt(input.readLine());

                int primo_libero = -1, primo_occupato = -1;
                for(int i = 0; i < mat[query].length; i++) {
                    if (primo_libero == -1 && mat[query][i] == 0) {
                        primo_libero = mat[query][i];
                    }
                    if (primo_occupato == -1 && mat[query][i] == 1) {
                        primo_occupato = mat[query][i];
                    }
                }
                System.out.println("Primo libero: " + primo_libero);
                System.out.println("Primo occupato: " + primo_occupato);
            } else if (scelta == 9) {
                System.out.print("Piano? ");
                int query = Integer.parseInt(input.readLine());

                int occupati = 0;
                for (int i: mat[query])
                    if (i == 1) occupati++;
                if (occupati == mat[query].length)
                    System.out.println("Tutti i posti sono occupati");
                else
                    System.out.println("Ci sono posti liberi");
            } else if (scelta == 10) {
                int disp = 0;
                for (int[] i: mat) {
                    for (int j: i)
                        if (j == 0) disp++;
                }
                System.out.println("Posti disponibili: " + disp);
            }

        } while(scelta != 11);

        PrintWriter file = new PrintWriter(new FileWriter("parcheggio2.txt"));
        for (int[] i: mat) {
            for (int j: i)
                file.print(j + " ");
            file.println();
        }
        file.close();
    }
}
