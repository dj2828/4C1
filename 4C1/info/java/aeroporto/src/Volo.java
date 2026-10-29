import java.util.Random;

class Volo {
    public String origine;
    public String destinazione;
    public int orarioPartenzaMinuti;
    public int orarioArrivoMinuti;

    public int postiTotali;
    public int postiTotaliEconomy;
    public int postiTotaliEconomyOccupati;
    public int postiTotaliBusiness;
    public int postiTotaliBusinessOccupati;

    public int durataMinuti;
    public int gate;

    public float prezzoEconomy;
    public float prezzoBusiness;

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

        this.durataMinuti = Math.abs(orarioPartenzaMinuti - orarioArrivoMinuti);

        float prezzoBase = (int)(((float) (consumoOrario * durataMinuti) / 60 / postiTotali)*100) / 100.0f; // 1.35832 --> 1.35
        this.prezzoEconomy = prezzoBase;
        this.prezzoBusiness = (float) (prezzoBase * (1 + (0.10 + random.nextDouble(0.30))));
        this.prezzoBusiness = (int)(this.prezzoBusiness * 100) / 100.0f;

        this.postiTotaliEconomy = (int) (postiTotali * (.50 + random.nextDouble(0.30)));
        this.postiTotaliEconomyOccupati = random.nextInt(postiTotaliEconomy);
        this.postiTotaliBusiness = postiTotali - postiTotaliEconomy;
        this.postiTotaliBusinessOccupati = random.nextInt(postiTotaliBusiness);
    }

    public int getPostiEconomyDisp() {
        return this.postiTotaliEconomy - this.postiTotaliEconomyOccupati;
    }
    public boolean isEconomyDisp() {
        return this.getPostiEconomyDisp() >= 1;
    }
    public int getPostiBusinessDisp() {
        return this.postiTotaliBusiness - this.postiTotaliBusinessOccupati;
    }
    public boolean isBusinessDisp() {
        return this.getPostiBusinessDisp() >= 1;
    }
}