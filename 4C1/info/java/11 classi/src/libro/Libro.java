package libro;

public class Libro {
    String titolo;
    String autore;
    int annoPubblicazione;

    Libro(String titolo, String autore, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
    }

    public void mostraDati() {
        System.out.println(this.titolo + " - " + this.autore + " - " + this.annoPubblicazione);
    }
}
