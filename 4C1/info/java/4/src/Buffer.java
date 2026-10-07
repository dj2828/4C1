import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Buffer {
    public static void main(String[] args) throws Exception{
        // creazione del buffer
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // lettura di una stringa
        System.out.print("nome: ");
        String nome = input.readLine();
        System.out.println(nome);

        // lettura di un numero
        System.out.print("num: ");
        int num = Integer.parseInt(input.readLine());
        System.out.println(num);

        // bouble
        System.out.print("double: ");
        double idk = Double.parseDouble(input.readLine());
        System.out.println(idk);
    }
}