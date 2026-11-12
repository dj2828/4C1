import java.io.*;

public class SalvaVoti {
    static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter file = new PrintWriter(new FileWriter("studenti.txt"));

        System.out.println("N studenti? ");
        int n = Integer.parseInt(input.readLine());
        file.println(n);

        int[] voti = new int[n];
        String[] nomi = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nome: ");
            nomi[i] = input.readLine();
            System.out.print("Voto: ");
            voti[i] = Integer.parseInt(input.readLine());

            file.println(nomi[i] + ";" + voti[i]);
        }
        file.close();
    }
}
