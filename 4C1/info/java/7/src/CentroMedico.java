import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class CentroMedico {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int askInt(String text) {
        while (true) {
            try {
                System.out.print(text);
                return Integer.parseInt(input.readLine());
            } catch (Exception e) {
                System.out.println("Deve essere int");
            }
        }
    }
    static void main(String[] args) throws IOException {
        Random random = new Random();

        int num_prenotazioni = askInt("N prenotazioni: ");

        int posizione_attuale = 0;
        String[] nomi = new String[num_prenotazioni];
        int[] ora = new int[num_prenotazioni];
        int[] stanza = new int[num_prenotazioni];

        int scelta;
        do {
            System.out.println("""
                \n1. Inserire una nuova prenotazione
                2. Visualizzare tutte le prenotazioni
                3. Cercare una prenotazione
                4. Modificare l’ora di una visita
                5. Visualizzare le visite previste prima delle ore 13
                6. Individuare la prima e l’ultima visita della giornata
                7. Visualizzare quante prenotazioni sono assegnate a ciascun ambulatorio
                8. Cancellare una prenotazione
                9. Uscire
                """);

            scelta = askInt("? ");

            if (scelta == 1) {
                if (posizione_attuale == num_prenotazioni) {
                    System.out.println("Prenotazioni full");
                    continue;
                }
                System.out.print("Nome: ");
                nomi[posizione_attuale] = input.readLine();

                boolean ok = false;
                int orario;
                do {
                    orario = askInt("Ora(8-18): ");
                    if (orario >= 8 && orario <= 18) {
                        ok = true;
                    } else {
                        System.out.println("Intervallo infranto");
                    }
                } while (!ok);
                ora[posizione_attuale] = orario;

                stanza[posizione_attuale] = random.nextInt(3) + 1;

                posizione_attuale++;
            } else if (scelta == 2) {
                for (int i = 0; i < posizione_attuale; i++) {
                    System.out.println("\nNome: " + nomi[i]);
                    System.out.println("Ora: " + ora[i]);
                    System.out.println("Ambulatorio: " + stanza[i]);
                }
            } else if (scelta == 3) {
                System.out.print("Query: ");
                String query = input.readLine();
                for (int i = 0; i < posizione_attuale; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        System.out.println("\nNome: " + nomi[i]);
                        System.out.println("Ora: " + ora[i]);
                        System.out.println("Ambulatorio: " + stanza[i]);
                    }
                }
            } else if (scelta == 4) {
                System.out.print("Query: ");
                String query = input.readLine();
                int numero_visita = -1;
                for (int i = 0; i < posizione_attuale; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        numero_visita = i;
                    }
                }
                if (numero_visita == -1) {
                    System.out.println("Null");
                    continue;
                }

                boolean ok = false;
                int orario;
                do {
                    orario = askInt("Ora(8-18): ");
                    if (orario >= 8 && orario <= 18) {
                        ok = true;
                    } else {
                        System.out.println("Intervallo infranto");
                    }
                } while (!ok);
                ora[numero_visita] = orario;
            } else if (scelta == 5) {
                ArrayList<Integer> mattina = new ArrayList<>();
                for (int i = 0; i < posizione_attuale; i++) {
                    if (ora[i] < 13) {
                        mattina.add(i);
                    }
                }
                for (int i: mattina) {
                    System.out.println("\nNome: " + nomi[i]);
                    System.out.println("Ora: " + ora[i]);
                    System.out.println("Ambulatorio: " + stanza[i]);
                }
            } else if (scelta == 6) {
                int min = ora[0];
                int minI = 0;
                int max = ora[0];
                int maxI = 0;
                for (int i = 0; i < posizione_attuale; i++) {
                    if (ora[i] < min) {
                        min = ora[i];
                        minI = i;
                    } else if (ora[i] > max) {
                        max = ora[i];
                        maxI = i;
                    }
                }
                System.out.println("\nMin: ");
                System.out.println("\tNome: " + nomi[minI]);
                System.out.println("\tOra: " + ora[minI]);
                System.out.println("\tAmbulatorio: " + stanza[minI]);
                System.out.println("\nMax: ");
                System.out.println("\tNome: " + nomi[maxI]);
                System.out.println("\tOra: " + ora[maxI]);
                System.out.println("\tAmbulatorio: " + stanza[maxI]);
            } else if (scelta == 7) {
                int uno = 0, due = 0, tre = 0;
                for (int i = 0; i < posizione_attuale; i++) {
                    if (stanza[i] == 1) {
                        uno++;
                    } else if (stanza[i] == 2) {
                        due++;
                    } else {
                        tre++;
                    }
                }
                System.out.println("\nUno: " + uno);
                System.out.println("Due: " + due);
                System.out.println("Tre: " + tre);
            } else if (scelta == 8) {
                System.out.print("Query: ");
                String query = input.readLine();
                int numero_visita = -1;
                for (int i = 0; i < posizione_attuale; i++) {
                    if (nomi[i].equalsIgnoreCase(query)) {
                        numero_visita = i;
                    }
                }
                if (numero_visita == -1) {
                    System.out.println("Null");
                    continue;
                }

                for (int i = numero_visita; i < posizione_attuale; i++) {
                    if (i == posizione_attuale - 1) {
                        break;
                    }
                    nomi[i] = nomi[i+1];
                    ora[i] = ora[i+1];
                    stanza[i] = stanza[i+1];
                }
                posizione_attuale--;
            }
        } while (scelta != 9);
    }
}
