import java.util.List;

public class Prenotazione {
    int indice_volo;
    float prezzo;
    String classe;

    public Prenotazione(int indice_volo, float  prezzo, String classe) {
        this.indice_volo = indice_volo;
        this.prezzo = prezzo;
        this.classe = classe;
    }

    static void stampaTabella(List<Prenotazione> prenotazioni, Volo[] voli) {
        String separatore = "+---+--------------------------------+--------------------------------+---------------+-------+----------+----------+----------+----------+";

        System.out.println(separatore);

        System.out.printf("| %-1s | %-30s | %-30s | %-13s | %-5s | %-8s | %-8s | %-8s | %-8s |%n",
                "#", "Origine", "Destinazione", "Prezzo pagato", "Gate", "Partenza", "Arrivo", "Durata", "Classe");

        System.out.println(separatore);

        int i = 0;
        for (Prenotazione p : prenotazioni) {
            Volo v = voli[p.indice_volo];

            String partenza = String.format("%02d:%02d", (v.orarioPartenzaMinuti / 60) % 24, v.orarioPartenzaMinuti % 60);
            String arrivo   = String.format("%02d:%02d", (v.orarioArrivoMinuti / 60) % 24, v.orarioArrivoMinuti % 60);
            String durata   = String.format("%02d:%02d", (v.durataMinuti / 60) % 24, v.durataMinuti % 60);

            String prezzoStr = String.format("%.2f €", p.prezzo);

            System.out.printf("| %-1d | %-30s | %-30s | %-13s | %-5d | %-8s | %-8s | %-8s | %-8s |%n",
                    i, v.origine, v.destinazione, prezzoStr, v.gate, partenza, arrivo, durata, p.classe);
            i++;
        }

        System.out.println(separatore);
    }
}