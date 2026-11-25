package auto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void main(String[] args) throws IOException {
        Auto auto1 = new Auto("Subaru", "baracca", 2000, 200000000);
        Auto auto2 = new Auto("Tesla", "Roadster", 2027, 2);

        auto1.mostraDati();
        auto2.mostraDati();

        auto1.aggiungiChilometri(10);

        auto1.mostraDati();

        BufferedReader input = new BufferedReader( new InputStreamReader(System.in));

        System.out.print("Marca: ");
        String marca = input.readLine();
        System.out.print("Modello: ");
        String modello = input.readLine();
        System.out.print("Anno: ");
        int anno = Integer.parseInt(input.readLine());
        System.out.print("Km: ");
        int km = Integer.parseInt(input.readLine());

        Auto auto3 = new Auto(marca, modello, anno, km);
        auto3.mostraDati();
    }
}