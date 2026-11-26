package prodotto;

public class Prodotto {
    String nome;
    float prezzo;
    int quantita;

    public Prodotto(String nome, float prezzo, int quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public void mostraDati() {
        System.out.println(nome + ", " + prezzo + "€, " + quantita);
    }

    public float calcolaValoreTot() {
        return prezzo*quantita;
    }

    public void aggiungiQuantita(int q) {
        quantita += q;
    }

    public boolean vendi(int q) {
        if (quantita - q < 0) return false;
        quantita -= q;
        return true;
    }

    public void applicaSconto(int percentuale) {
        prezzo -= (float) percentuale / 100 * prezzo;
    }
}
