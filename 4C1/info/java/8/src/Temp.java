import java.io.*;

public class Temp {
    static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("N? ");
        int n = Integer.parseInt(input.readLine());

        String[] where = new String[n];
        int[] temp = new int[n];

        int somma = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Where? ");
            where[i] = input.readLine();
            System.out.print(i + ": ");
            temp[i] = Integer.parseInt(input.readLine());
            somma += temp[i];
        }

        System.out.println("Media: " + (float)somma/n);

        PrintWriter file = new PrintWriter(new FileWriter("temp.txt"));

        file.println(n);
        for (int i = 0; i < n; i++) {
            file.println(where[i] + ";" + temp[i]);
        }

        file.close();

        BufferedReader fileR = new BufferedReader(new FileReader("temp.txt"));

        System.out.println("N: " + fileR.readLine());

        int[] newTemp = new int[n];
        String[] newWhere = new String[n];

        somma = 0;
        for (int i = 0; i < n; i++) {
            String line = fileR.readLine();
            newWhere[i] = line.split(";")[0];
            newTemp[i] = Integer.parseInt(line.split(";")[1]);
            somma += newTemp[i];
        }
        System.out.println("Media: " + (float)somma/n);

        int max = newTemp[0];
        int min = newTemp[0];
        for (int i: temp) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        for (int i = 0; i < n; i++) {
            System.out.println(newWhere[i] + ": " + newTemp[i]);
        }
    }
}
