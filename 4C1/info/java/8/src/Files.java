import java.io.*;

public class Files {
    static void main(String[] args) throws IOException {
        PrintWriter file = new PrintWriter(new FileWriter("a.txt", true));

        file.println(5);

        file.close(); // SALVA

        BufferedReader fileLetto = new BufferedReader(new FileReader("a.txt"));

        System.out.println(fileLetto.readLine());
    }
}