import java.util.Scanner;

public class Errors2 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numero = 0;
        boolean dato_valido = false;

        // il ciclo continua finchè dato_valido è false
        while (!dato_valido) {
            try {
                System.out.println("Inserisci un numero intero: ");
                numero = input.nextInt();
                // se arriva aquesta istruzione significa che il dato è stato letto correttamente
                dato_valido = true;
            } catch (Exception e) {
                // Exception è un tipo generale di eccezzione
                // permette di intercettare diversi tipi di errore
                System.out.println("Errore: devi inserire un numero intero");
                // elimina il dato errato per permettere unu nuovo inserimento
                input.nextLine();
            }
        }
        System.out.println();
        System.out.println("Numero inserito correttamente: " + numero);
        input.close();
    }
}