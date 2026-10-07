import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pagella_buffer {
    static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Num materie: ");
        int n = Integer.parseInt(input.readLine());

        String[] nomi = new String[n];
        float[] voti = new float[n];

        for(int i=0; i<n; i++) {
            System.out.print("Nome: ");
            nomi[i] = input.readLine();
            System.out.print("Voto: ");
            voti[i] = Float.parseFloat(input.readLine());
        }

        int scelta = 0;
        do {
            System.out.print("""
                \n1) print
                2) media
                3) tabella
                4) exit
                """);
            System.out.print("? ");
            scelta = Integer.parseInt(input.readLine());

            if (scelta == 1) {
                for (int i = 0; i < n; i++)
                    System.out.println(nomi[i] + ": " + voti[i]);
            }

            if (scelta == 2) {
                float tot = 0;
                for (int i = 0; i < n; i++)
                    tot += voti[i];
                System.out.println("Media: " + tot / n);
            }

            if (scelta == 3) {
                System.out.println();
                System.out.printf("%-10s %-10s%n", "Materia", "Voto");
                for (int i = 0; i < n; i++)
                    System.out.printf("%-10s %-10s%n", nomi[i], voti[i]);
            }
        } while (scelta != 4);
    }
}
