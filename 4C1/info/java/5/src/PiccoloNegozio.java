import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PiccoloNegozio {
    static int askInt(String text) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print(text);
                return Integer.parseInt(input.readLine());
            } catch (Exception e) {
                System.out.println("Errore: deve essere int");
            }
        }
    }
    static String askString(String text) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print(text);
                return input.readLine();
            } catch (Exception e) {
                System.out.println("Errore: deve essere string");
            }
        }
    }
    static void main(String[] args) {
        int n = askInt("N prodotti: ");

        String[] nomi = new String[n];
        int[] quantita = new int[n];

        for (int i=0; i<n; i++) {
            boolean rifa;
            System.out.println(i+1 + ": ");
            nomi[i] = askString("\tNome: ");
            do {
                quantita[i] = askInt("\tQuantità: ");
                if (quantita[i] < 0) {
                    System.out.println("Impossibile impostare quantita negative");
                    rifa = true;
                } else {
                    rifa = false;
                }
            } while (rifa);
        }

        int scelta;
        do {
            System.out.print("""
            \n1. Visualizzare tutti i prodotti e le relative quantità.
            2. Cercare un prodotto per nome.
            3. Aggiungere una determinata quantità alle scorte di un prodotto.
            4. Sottrarre una quantità in seguito a una vendita.
            5. Visualizzare tutti i prodotti con meno di 5 pezzi disponibili.
            6. Visualizzare il prodotto con la quantità maggiore.
            7. Calcolare il numero totale di pezzi presenti nel negozio.
            8. Modifica prodotto.
            9. Chiudere il programma.
            """);
            scelta = askInt("? ");

            if (scelta == 1) {
                for (int i=0; i<n; i++) {
                    System.out.println(i+1 + ": " + nomi[i] + " " + quantita[i]);
                }
            } else if (scelta == 2) {
                String query = askString("Query: ");
                boolean trovato = false;
                for (int i=0; i<n; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        System.out.println("Trovato: " + nomi[i] + " " + quantita[i]);
                        trovato = true;
                    }
                }
                if (!trovato) {
                    System.out.println("Non trovato");
                }
            } else if (scelta == 3) {
                String query = askString("Nome prodotto: ");
                boolean found = false;
                int posto = 0;
                for (int i=0; i<n; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        found = true;
                        posto = i;
                    }
                }
                if (!found) {
                    System.out.println("Query errata");
                } else {
                    int quantita_da_aggiungere = askInt("Quantità da aggiungere: ");
                    quantita[posto] += quantita_da_aggiungere;
                }
            } else if (scelta == 4) {
                String query = askString("Nome prodotto: ");
                boolean found = false;
                int posto = 0;
                for (int i=0; i<n; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        found = true;
                        posto = i;
                    }
                }

                if (!found) {
                    System.out.println("Query errata");
                } else {
                    int quantita_da_togliere = askInt("Quantità da acquistare: ");
                    if (quantita_da_togliere > quantita[posto]) {
                        System.out.println("Non ci sono abbastanza prodotti");
                    } else {
                        quantita[posto] -= quantita_da_togliere;
                    }
                }
            } else if (scelta == 5) {
                for (int i=0; i<n; i++) {
                    if (quantita[i] <= 5) {
                        System.out.println("Prodotto " + nomi[i] + " con " + quantita[i] + " scorte");
                    }
                }
            } else if (scelta == 6) {
                int max = quantita[0];
                int imax = 0;
                for (int i=1; i<n; i++) {
                    if (max < quantita[i]) {
                        max = quantita[i];
                        imax = i;
                    }
                }
                System.out.println("Max quantity: " + nomi[imax] + " " + quantita[imax]);
            } else if (scelta == 7) {
                int tot = 0;
                for (int i=0; i<n; i++) {
                    tot += quantita[i];
                }
                System.out.println("Tot: " + tot);
            } else if (scelta == 8) {
                String query = askString("Nome prodotto: ");
                boolean found = false;
                int posto = 0;
                for (int i=0; i<n; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        found = true;
                        posto = i;
                    }
                }
                if (!found) {
                    System.out.println("Query errata");
                } else {
                    nomi[posto] = askString("Nuovo nome: ");
                    boolean rifa;
                    do {
                        quantita[posto] = askInt("Quantità: ");
                        if (quantita[posto] < 0) {
                            System.out.println("Impossibile impostare quantita negative");
                            rifa = true;
                        } else {
                            rifa = false;
                        }
                    } while (rifa);
                }
            }
        } while (scelta != 9);
    }
}