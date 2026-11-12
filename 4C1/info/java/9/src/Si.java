import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Si {
    static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("studenti.txt"));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(file.readLine());

        int[] voti = new int[n];
        String[] nomi = new String[n];

        for (int i = 0; i < n; i++) {
            String riga = file.readLine();
            nomi[i] = riga.split(";")[0];
            voti[i] = Integer.parseInt(riga.split(";")[1]);
        }

        int somma = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(nomi[i] + ": " + voti[i]);

            somma += voti[i];
        }
        System.out.println("Media: " + (float)somma/n);

        int max = voti[0];
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (voti[i] > max) {
                max = voti[i];
                maxi = i;
            }
        }
        System.out.println("Max: " + nomi[maxi] + "-" + max);

        int suff = 0;
        for (int i: voti) {
            if (i >= 6) suff++;
        }
        System.out.println("Suff: " + suff);

        System.out.print("Query: ");
        String query = input.readLine();
    }
}
