import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Aeroporto {
    static Random random = new Random();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static String[] aeroporti = {"Milano Malpensa (MXP)", "Milano Linate (LIN)", "Bergamo (BGY)", "Torino (TRN)", "Roma Fiumicino (FCO)", "New York (JFK)", "Berlino (SXF)", "Stoccolma (BMA)"};
    static String[] stato = {"I", "I", "I", "I", "I", "USA", "G", "Sv"};

    public static String convertiMinutiInOra(int minutiTotali) {
        int ore = minutiTotali / 60;
        int minuti = minutiTotali % 60;
        return String.format("%02d:%02d", ore, minuti);
    }

    static Volo[] initVoli() {
        Volo[] voli = new Volo[8];

        for (int i = 0; i < 8; i++) {
            int random_partenza = random.nextInt(aeroporti.length);
            int random_arrivo;
            do {
                random_arrivo = random.nextInt(aeroporti.length);
            } while (random_partenza == random_arrivo ||
                    (random_partenza == 0 && random_arrivo == 1) || // malpensa linate
                    (random_partenza == 0 && random_arrivo == 2) || // malpensa bergamo
                    (random_partenza == 1 && random_arrivo == 0) || // linate malpensa
                    (random_partenza == 1 && random_arrivo == 2) || // linate bergamo
                    (random_partenza == 2 && random_arrivo == 0) || // bergamo malpensa
                    (random_partenza == 2 && random_arrivo == 1)    // bergamo linate
            );

            int random_ora_partenza_minuti = random.nextInt(24*60);
            int random_ora_arrivo_minuti;
            if (stato[random_partenza] == stato[random_arrivo]) {
                random_ora_arrivo_minuti = random_ora_partenza_minuti + 30 + random.nextInt(2*60);
            } else {
                random_ora_arrivo_minuti = random_ora_partenza_minuti + 2 * 60 + random.nextInt(2 * 60);
            }

            voli[i] = new Volo( aeroporti[random_partenza],
                                aeroporti[random_arrivo],
                                random_ora_partenza_minuti,
                                random_ora_arrivo_minuti,
                                150 + random.nextInt(151),
                                random.nextInt(10));
        }

        return voli;
    }

    static int askInt(String text) {
        while (true) {
            System.out.print(text);
            try {
                return Integer.parseInt(input.readLine());
            } catch (Exception e) {
                System.out.println("Inserisci un int");
            }
        }
    }

    static void stampaTabella(List<Volo> voli) {
        String separatore = "+--------------------------------+--------------------------------+----------+----------+----------+-------+-------------+------------+-----------+";

        System.out.println(separatore);
        System.out.printf("| %-30s | %-30s | %-8s | %-8s | %-8s | %-5s | %-8s | %-10s | %-9s |%n",
                "Origine", "Destinazione", "Partenza", "Arrivo", "Durata", "Gate", "Posti Disp.", "Posti Tot.", "Prezzo");
        System.out.println(separatore);

        for (Volo v : voli) {
            String partenza = String.format("%02d:%02d", (v.orarioPartenzaMinuti / 60) % 24, v.orarioPartenzaMinuti % 60);
            String arrivo   = String.format("%02d:%02d", (v.orarioArrivoMinuti / 60) % 24, v.orarioArrivoMinuti % 60);
            String durata   = String.format("%02d:%02d", (v.durataMinuti / 60) % 24, v.durataMinuti % 60);
            float prezzoTroncato = (int)(v.prezzo * 100) / 100.0f;

            System.out.printf("| %-30s | %-30s | %-8s | %-8s | %-8s | %-5d | %-11d | %-10d | %-7.2f € |%n",
                    v.origine, v.destinazione, partenza, arrivo, durata, v.gate, v.postiTotali - v.postiOccupati, v.postiTotali, prezzoTroncato);
        }

        System.out.println(separatore);
    }

    public static void main(String[] args) throws IOException {
        Volo[] voli = initVoli();

//        for (Volo i: voli) {
//            System.out.println(i.origine + ", " + i.destinazione + ", " +
//                    convertiMinutiInOra(i.orarioPartenzaMinuti) + ", " + convertiMinutiInOra(i.orarioArrivoMinuti) + ", " +
//                    i.postiTotali + ", " + i.postiOccupati + ", " + convertiMinutiInOra(i.durataMinuti) + ", " + i.gate + ", " + i.prezzo);
//        }

        System.out.println("Aeroporto");
        while (true) {
            System.out.print("""
                    \n1) Cerca voli
                    2) Tutti i voli
                    """);
            int scelta = askInt("? ");

            if (scelta == 1) {
                ArrayList<Volo> voliOk = new ArrayList<Volo>();
                for (int i = 0; i < voli.length; i++) {
                    System.out.println(i + ") " + aeroporti[i]);
                }
                int query = askInt("Da? ");

                for (Volo volo: voli) {
                    if (aeroporti[query] == volo.origine) {
                        voliOk.add(volo);
                    }
                }

                if (voliOk.isEmpty()) {
                    System.out.println("Nessun volo trovato");
                } else {
                    stampaTabella(voliOk);
                }
            } else if (scelta == 2) {
                stampaTabella(List.of(voli));
            }

        }
    }
}