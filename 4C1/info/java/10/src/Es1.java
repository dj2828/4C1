import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Es1 {
    static void main(String[] args) throws IOException {
        Random random = new Random();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int[][] mat = new int[3][3];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = random.nextInt(9);
            }
        }

        int somma = 0;
        for (int[] i: mat) {
            for (int j: i){
                System.out.print(j + " ");
                somma += j;
            }
            System.out.println();
        }
        System.out.println("Somma: " + somma);
        System.out.println("Media: " + (float)somma / (mat.length*mat[0].length));

        int max = mat[0][0];
        int min = mat[0][0];
        int cinque = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] > max) max = mat[i][j];
                else if (mat[i][j] < min) min = mat[i][j];

                if (mat[i][j] > 5) cinque++;
            }
        }
        System.out.println("Max: " + max + " Min: " + min);
        System.out.println("Cinque: " + cinque);

        System.out.print("Query? ");
        int query = Integer.parseInt(input.readLine());
        int conta = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (query == mat[i][j]) conta++;
            }
        }
        System.out.println("Trovato: " + conta);
    }
}
