import java.util.Random;
import java.util.Scanner;

class Es1 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        float peso;
        boolean ok = false;
        // inserimento peso
        while(true){
            try {
                System.out.print("Inserire il peso: ");
                peso = input.nextFloat();
                break;
            } catch (Exception e) {
                System.out.println("Inserire un float");
                input.nextLine();
            }
        }
        // pulisce la riga dopo il float
        input.nextLine();

        int tipo_spedizione;
        // inserimento tipo spedizione
        while(true) {
            try {
                System.out.print("""
                    \n1) Standard
                    2) Express
                    """);
                System.out.print("? ");
                tipo_spedizione = input.nextInt();
                // se il numero inserito non è presente
                if (tipo_spedizione != 1 && tipo_spedizione != 2) {
                    System.out.println("Inserire 1/2");
                    input.nextLine();
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Inserire un int");
                input.nextLine();
            }
        }

        // assegnazione costi secondo il peso
        float costo;
        if (peso <= 2) {
            costo = 5;
        } else if (peso > 2 && peso <= 5) {
            costo = 8;
        } else {
            costo = 12;
        }

        float costo_base = costo;

        // aggiunge 4€ se spedizione express (2)
        if (tipo_spedizione == 2) costo += 4;

        float sconto = 0;
        switch (random.nextInt(3) + 1) {
            case 1:
                // nessuno sconto
                break;
            case 2:
                // sconto del 10%
                sconto = 0.10F;
                break;
            case 3:
                // sconto del 20%
                sconto = 0.20F;
                break;
        }

        // applicamento sconto
        costo -= sconto * costo;

        // stampa
        System.out.printf("%s %s %n", "Costo base", costo_base + "€");
        System.out.printf("%s %s %n", "Sconto", sconto*100 + "%");
        if (tipo_spedizione == 2)
            System.out.printf("%s %s %n", "Supplemento Express", "4€");
        System.out.printf("%s %s %n", "Costo tot", costo + "€");

        input.close();
    }
}