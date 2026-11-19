import java.io.*;
import java.util.Random;

public class Parcheggio {
    static final String RED = "\033[0;31m";
    static final String GREEN = "\033[0;32m";
    static final String RESET = "\033[0m";

    static void print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int posto = mat[i][j];
                if (posto == 0) System.out.print(GREEN);
                else System.out.print(RED);
                System.out.print(posto + " ");
            }
            System.out.println();
        }
        System.out.print(RESET);
    }

    static void main(String[] args) throws IOException {
        Random random = new Random();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int[][] mat = new int[4][6];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = random.nextInt(2);
            }
        }

        int scelta;
        do {
            System.out.print("""
                1. Visualizza il parcheggio
                2. Conta tutti i posti liberi
                3. Conta tutti i posti occupati
                4. Occupa un posto
                5. Libera un posto
                6. Verifica se il parcheggio è completamente pieno
                7. Verifica se il parcheggio è completamente vuoto
                8. Esci
                ?\s""");
            while (true) {
                try {
                    scelta = Integer.parseInt(input.readLine());
                    break;
                } catch (Exception e) {
                    System.out.print("Inserisci un numero\n? ");
                }
            }

            if (scelta == 1) {
                print(mat);
                System.out.println();
            } else if (scelta == 2) {
                int liberi = 0;
                for (int[] i: mat){
                    for (int j: i){
                        if (j == 0) liberi++;
                    }
                }
                System.out.println("Posti liberi: " + liberi + "\n");
            } else if (scelta == 3) {
                int occupati = 0;
                for (int[] i: mat){
                    for (int j: i){
                        if (j == 1) occupati++;
                    }
                }
                System.out.println("Posti occupati: " + occupati + "\n");
            } else if (scelta == 4) {
                print(mat);
                System.out.println("Quale:");
                System.out.print(" riga? ");
                int r = Integer.parseInt(input.readLine());
                System.out.print(" colonna? ");
                int c = Integer.parseInt(input.readLine());
                if (mat[r][c] == 1) {
                    System.out.println("Posto gia occupato");
                    continue;
                }
                mat[r][c] = 1;
            } else if (scelta == 5) {
                print(mat);
                System.out.println("Quale:");
                System.out.print(" riga? ");
                int r = Integer.parseInt(input.readLine());
                if (r < 0 || r > mat.length-1) continue;
                System.out.print(" colonna? ");
                int c = Integer.parseInt(input.readLine());
                if (c < 0 || c > mat[0].length-1) continue;
                if (mat[r][c] == 0) {
                    System.out.println("Posto gia libero");
                    continue;
                }
                mat[r][c] = 0;
            } else if (scelta == 6) {
                int occupati = 0;
                for (int[] i: mat) {
                    for (int j: i) {
                        if (j == 1) occupati++;
                    }
                }
                int tot_parcheggi = mat.length*mat[0].length;
                if (occupati == tot_parcheggi) {
                    System.out.println("Parcheggio full");
                }
            } else if (scelta == 7) {
                int liberi = 0;
                for (int[] i: mat) {
                    for (int j: i) {
                        if (j == 0) liberi++;
                    }
                }

                int tot_parcheggi = mat.length*mat[0].length;
                if (liberi == tot_parcheggi) {
                    System.out.println("Parcheggio libero");
                }
            }
        } while (scelta != 8);

        PrintWriter file = new PrintWriter(new FileWriter("parcheggio.txt"));
        for (int[] i: mat) {
            for (int j: i)
                file.print(j + " ");
            file.println();
        }
        file.close();
    }
}
