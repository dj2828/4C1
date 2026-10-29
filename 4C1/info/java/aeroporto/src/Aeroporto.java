import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        // Separatore esatto ricalcolato su tutte le colonne
        String separatore = "+---+--------------------------------+--------------------------------+----------+----------+----------+-------+---------------+---------------+------------+------------+";

        System.out.println(separatore);

        // Intestazione completa di tutte le 11 colonne
        System.out.printf("| %-1s | %-30s | %-30s | %-8s | %-8s | %-8s | %-5s | %-13s | %-13s | %-10s | %-10s |%n",
                "#", "Origine", "Destinazione", "Partenza", "Arrivo", "Durata", "Gate", "Disp/Tot Eco", "Disp/Tot Bis", "Prezzo Eco", "Prezzo Bis");

        System.out.println(separatore);

        int i = 0;
        for (Volo v : voli) {
            String partenza = String.format("%02d:%02d", (v.orarioPartenzaMinuti / 60) % 24, v.orarioPartenzaMinuti % 60);
            String arrivo   = String.format("%02d:%02d", (v.orarioArrivoMinuti / 60) % 24, v.orarioArrivoMinuti % 60);
            String durata   = String.format("%02d:%02d", (v.durataMinuti / 60) % 24, v.durataMinuti % 60);

            // Posti disponibili per classe
            int dispEconomy  = v.postiTotaliEconomy - v.postiTotaliEconomyOccupati;
            int dispBusiness = v.postiTotaliBusiness - v.postiTotaliBusinessOccupati;

            String ecoStr = String.format("%d/%d", dispEconomy, v.postiTotaliEconomy);
            String bizStr = String.format("%d/%d", dispBusiness, v.postiTotaliBusiness);

            // Prezzi formattati come stringa con simbolo dell'euro per evitare problemi di allineamento
            String prezzoEcoStr = String.format("%.2f €", v.prezzoEconomy);
            String prezzoBizStr = String.format("%.2f €", v.prezzoBusiness);

            System.out.printf("| %-1d | %-30s | %-30s | %-8s | %-8s | %-8s | %-5d | %-13s | %-13s | %-10s | %-10s |%n",
                    i, v.origine, v.destinazione, partenza, arrivo, durata, v.gate, ecoStr, bizStr, prezzoEcoStr, prezzoBizStr);
            i++;
        }

        System.out.println(separatore);
    }

    public static void main(String[] args) {
        Volo[] voli = initVoli();

        System.out.println("Aeroporto");
        while (true) {
            System.out.print("""
                    \n1) Cerca voli
                    2) Tutti i voli
                    3) Compra volo
                    """);
            int scelta = askInt("? ");

            if (scelta == 1) {
                ArrayList<Volo> voliOk = new ArrayList<>();
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
            } else if (scelta == 3) {
                stampaTabella(List.of(voli));

                int _scelta = askInt("Volo? ");

                Volo voloScelto = voli[_scelta];

                while (true) {
                    // deve essercene almeno un posto libero
                    if (voloScelto.isEconomyDisp()) {
                        System.out.println("1) Economy - " + voloScelto.getPostiEconomyDisp() + " posti disponibili - " + voloScelto.prezzoEconomy + "€");
                    } else {
                        System.out.println("-) Economy - 0 posti disponibili");
                    }
                    if (voloScelto.isBusinessDisp()) {
                        System.out.println("2) Business - " + voloScelto.getPostiBusinessDisp() + " posti disponibili - " + voloScelto.prezzoBusiness + "€");
                    } else {
                        System.out.println("-) Business - 0 posti disponibili");
                    }

                    _scelta = askInt("? ");

                    if (_scelta == 1) {
                        if (voloScelto.isEconomyDisp()) {
                            voloScelto.postiTotaliEconomyOccupati++;
                            System.out.println("Transizione completata: " + voloScelto.prezzoEconomy + "€");
                            break;
                        } else {
                            System.out.println("Economy non disponibile");
                        }
                    } else if (_scelta == 2) {
                        if (voloScelto.isBusinessDisp()) {
                            voloScelto.postiTotaliBusinessOccupati++;
                            System.out.println("Transizione completata: " + voloScelto.prezzoBusiness + "€");
                            break;
                        } else {
                            System.out.println("Business non disponibile");
                        }
                    }
                }
            }


        }
    }
}