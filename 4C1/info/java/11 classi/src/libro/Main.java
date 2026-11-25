package libro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void main(String[] args) throws IOException {
        Libro libro = new Libro("jjk", "Gege Akutami", 2019);

        libro.mostraDati();

        BufferedReader input = new BufferedReader( new InputStreamReader(System.in));

        System.out.print("Titolo: ");
        String titolo = input.readLine();
        System.out.print("Autore: ");
        String autore = input.readLine();
        System.out.print("Anno: ");
        int annoPubblicazione = Integer.parseInt(input.readLine());

        Libro libro2 = new Libro(titolo, autore, annoPubblicazione);
        libro2.mostraDati();
    }
}