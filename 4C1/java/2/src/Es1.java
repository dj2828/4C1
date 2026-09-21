import java.util.Scanner;

public class Es1 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci un numero: ");
        int n1 = input.nextInt();

        if (n1%2==0) System.out.println("Il numero è pari");
        else System.out.println("Il numero è dispari");

        input.close();
    }
}