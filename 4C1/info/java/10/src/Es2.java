import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Es2 {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int[][] mat = new int[5][5];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = 1+random.nextInt(8);
            }
        }

        for (int[] i: mat){
            for (int j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        int max_colonna = 0;
        for (int j = 0; j < mat.length; j++) {
            int somma_colonna = 0;
            for (int i = 0; i < mat[0].length; i++) {
                somma_colonna += mat[i][j];
            }
            System.out.println("Somma colonna " + j + ": " + somma_colonna);
            if (somma_colonna > max_colonna) max_colonna = somma_colonna;
        }
        System.out.println("Max colonna: " + max_colonna);

        System.out.print("Query riga? ");
        int query_riga = Integer.parseInt(input.readLine());
        if (query_riga >= mat.length) System.out.println("NO");
        else {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[query_riga][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Query colonna? ");
        int query_colonna = Integer.parseInt(input.readLine());
        if (query_colonna >= mat[0].length) System.out.println("NO");
        else {
            for (int i = 0; i < mat[0].length; i++) {
                System.out.print(mat[i][query_colonna] + " ");
            }
            System.out.println();
        }
    }
}
