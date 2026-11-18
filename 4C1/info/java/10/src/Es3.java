import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Random;

public class Es3 {
    static void main(String[] args) {
        Random random = new Random();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        final String VERDE = "\u001B[32m";
        final String GIALLO = "\u001B[33m";
        final String RESET = "\033[0m";

        int[][] mat = new int[5][5];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = random.nextInt(9);
            }
        }

        for (int[] i: mat){
            for (int j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        int somma_princ = 0;
        System.out.print("Diagonale principale: ");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(VERDE + mat[i][i] + " ");
            somma_princ += mat[i][i];
        }
        System.out.println(RESET + "| Somma: " + somma_princ);

        int somma_sec = 0;
        System.out.print("Diagonale secondaria: ");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(GIALLO + mat[i][mat.length - 1 - i] + " ");
            somma_sec += mat[i][mat.length - 1 - i];
        }
        System.out.println(RESET + "| Somma: " + somma_sec);

        if (somma_princ > somma_sec) System.out.println("Principale maggiore");
        else if (somma_princ < somma_sec) System.out.println("Secondaria maggiore");
        else System.out.println("Uguali");

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == j || j == mat.length - 1 - i) System.out.print(mat[i][j] + " ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if ((i == 0 || i == mat.length-1) || (j == 0 || j == mat[0].length-1))
                    System.out.print(mat[i][j] + " ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i < j)
                    System.out.print(mat[i][j] + " ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i > j)
                    System.out.print(mat[i][j] + " ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
