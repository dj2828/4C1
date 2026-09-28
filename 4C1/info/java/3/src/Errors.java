import java.util.Scanner;
import java.util.InputMismatchException;

public class Errors {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Inserisci un numero intero:");
            int numero = input.nextInt();
            System.out.println("Hai inserito il numero " + numero);
        } catch (Exception e) {
            System.out.println("Errore: devi inserire un numero intero");
        }

        System.out.println("Fine del proggramma");
        input.close();
    }
}