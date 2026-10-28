import java.util.Random;

class Volo {
    public String origine;
    public String destinazione;
    public int orarioPartenzaMinuti;
    public int orarioArrivoMinuti;
    public int postiTotali;
    public int postiOccupati;
    public int durataMinuti;
    public int gate;
    public float prezzo;

    static Random random = new Random();

    static int consumoOrario = 2500;

    public Volo(String origine, String destinazione,
                int orarioPartenzaMinuti, int orarioArrivoMinuti, int postiTotali, int gate) {

        if (postiTotali <= 0) {
            throw new IllegalArgumentException("I posti totali devono essere maggiori di zero.");
        }

        this.origine = origine;
        this.destinazione = destinazione;
        this.orarioPartenzaMinuti = orarioPartenzaMinuti;
        this.orarioArrivoMinuti = orarioArrivoMinuti;
        this.postiTotali = postiTotali;
        this.gate = gate;

        this.postiOccupati = random.nextInt(postiTotali);
        this.durataMinuti = Math.abs(orarioPartenzaMinuti - orarioArrivoMinuti);
        this.prezzo = (int)(((float) (consumoOrario * durataMinuti) / 60 / postiTotali)*100) / 100.0f; // 1.35832 --> 1.35
    }
}