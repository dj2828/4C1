import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class NegozioOnline {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int askInt(String text) {
        while (true) {
            try {
                System.out.print(text);
                int skibidi = Integer.parseInt(input.readLine());
                if (skibidi < 0) {
                    continue;
                }
                return skibidi;
            } catch (Exception e) {
                System.out.println("Errore, deve essere int");
            }
        }
    }

    static void main(String[] args) throws Exception {
        Random random = new Random();

        int n_ordini = askInt("Numero ordini: ");
        String[] nomi = new String[n_ordini];
        float[] costo = new float[n_ordini];
        int[] sconto = new int[n_ordini];

        for (int i = 0; i < n_ordini; i++) {
            System.out.print("Nome cliente: ");
            nomi[i] = input.readLine();
            costo[i] = askInt("Importo ordine: ");

            switch (random.nextInt(3)) {
                case 0:
                    break;
                case 1:
                    sconto[i] = 3;
                    break;
                case 2:
                    sconto[i] = 5;
                    break;
            }
        }

        int scelta;
        do {
            System.out.print("""
                    \n1) Visualizzare tutti gli ordini
                    2) Cercare un ordine
                    3) Modificare l’importo di un ordineù
                    4) Modificare il nome del cliente
                    5) Cancellare un ordine
                    6) Calcolare l’incasso totale
                    7) Visualizzare l’ordine con l’importo finale maggiore
                    8) Contare quanti ordini hanno ottenuto lo sconto
                    9) Exit
                    """);
            scelta = askInt("? ");

            if (scelta == 1) {
                for (int i = 0; i < n_ordini; i++) {
                    System.out.println(i + 1 + ":");
                    System.out.println("\t" + nomi[i]);
                    System.out.println("\t" + costo[i]);
                    System.out.println("\t" + sconto[i]);
                }
            } else if (scelta == 2) {
                System.out.print("Query: ");
                String query = input.readLine();

                boolean found = false;
                int pos = 0;
                for (int i = 0; i < n_ordini; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        found = true;
                        pos = i;
                    }
                }
                if (found) {
                    System.out.println(nomi[pos]);
                    System.out.println(costo[pos]);
                    System.out.println(sconto[pos]);
                } else {
                    System.out.println("Null");
                }
            } else if (scelta == 3) {
                System.out.print("Query: ");
                String query = input.readLine();

                boolean found = false;
                int pos = 0;
                for (int i = 0; i < n_ordini; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        found = true;
                        pos = i;
                    }
                }
                if (found) {
                    costo[pos] = askInt("New ("+costo[pos]+"): ");
                } else {
                    System.out.println("Null");
                }
            } else if (scelta == 4) {
                System.out.print("Query: ");
                String query = input.readLine();

                boolean found = false;
                int pos = 0;
                for (int i = 0; i < n_ordini; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        found = true;
                        pos = i;
                    }
                }
                if (found) {
                    System.out.print("New: ");
                    nomi[pos] = input.readLine();
                } else {
                    System.out.println("Null");
                }
            } else if (scelta == 5) {
                System.out.print("Query: ");
                String query = input.readLine();

                boolean found = false;
                int pos = 0;
                for (int i=0; i<n_ordini; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        found = true;
                        pos = i;
                    }
                }
                if (found) {
                    for (int i=pos; i<n_ordini; i++) {
                        if (i == n_ordini-1) { break; }
                        nomi[i] = nomi[i+1];
                        costo[i] = costo[i+1];
                        sconto[i] = sconto[i+1];
                    }
                    n_ordini--;
                } else {
                    System.out.println("Null");
                }
            } else if (scelta == 6) {
                for (int i=0; i<n_ordini; i++) {
                    costo[i] = costo[i]-(costo[i]*sconto[i]/100);
                    System.out.println(costo[i] + ", "  + sconto[i]);
                }
            } else if (scelta == 7) {
                float max = costo[0];
                int pos = 0;
                for (int i = 0; i < n_ordini; i++) {
                    if (costo[i] > max) {
                        max = costo[i];
                        pos = i;
                    }
                }
                System.out.println("Max: " + nomi[pos]);
            } else if (scelta == 8) {
                int n_sconti = 0;
                for (int i = 0; i < n_ordini; i++) {
                    if (sconto[i] != 0) n_sconti++;
                }
                System.out.println(n_sconti);
            }
        } while (scelta != 9);
    }
}