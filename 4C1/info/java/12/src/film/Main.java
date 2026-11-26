package film;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Titolo: ");
        String titolo = input.readLine();
        System.out.print("Genere: ");
        String genere = input.readLine();
        System.out.print("Durata: ");
        int durata = Integer.parseInt(input.readLine());

        Film film = new Film(titolo, genere, durata);

        while (true) {
            System.out.print("""
                    \n1) mostra dati
                    2) durata in ore
                    3) piu lungo di 120min
                    4) exit
                    ?\s""");
            int scelta = Integer.parseInt(input.readLine());

            if (scelta == 1)
                film.mostraDati();
            else if (scelta == 2)
                film.mostraDurataOre();
            else if (scelta == 3)
                System.out.println("Dura piu di 120: " + (film.isFilmLungo() ? "si" : "no"));
            else if (scelta == 4)
                break;
        }
    }
}
