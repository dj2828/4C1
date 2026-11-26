package prodotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Prodotto[] prodotti = {
                new Prodotto("Carota", 10000, 2),
                new Prodotto("Patata", 0.02f, 1067)
            };

        while (true) {
            System.out.print("""
                \n1) view data
                2) aggiungi qa
                3) aggiungi sconto
                4) compra
                5) esci
                ?\s""");
            int scelta = Integer.parseInt(input.readLine());

            if (scelta == 1)
                for (Prodotto prodotto: prodotti)
                    prodotto.mostraDati();
            else if (scelta == 2) {
                System.out.print("1/2? ");
                int cosa = Integer.parseInt(input.readLine())-1;
                System.out.print("Quantità? ");
                prodotti[cosa].aggiungiQuantita(Integer.parseInt(input.readLine()));
            } else if (scelta == 3) {
                System.out.print("1/2? ");
                int cosa = Integer.parseInt(input.readLine())-1;
                System.out.print("Sconto? ");
                prodotti[cosa].applicaSconto(Integer.parseInt(input.readLine()));
            } else if (scelta == 4) {
                System.out.print("1/2? ");
                int cosa = Integer.parseInt(input.readLine())-1;
                System.out.print("Quantità? ");
                if (prodotti[cosa].vendi(Integer.parseInt(input.readLine())))
                    System.out.println("Ok");
                else
                    System.out.println("ERRORE, quantità insufficiente");
            } else if (scelta == 5)
                break;
        }
    }
}
