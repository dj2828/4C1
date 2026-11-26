package film;

public class Film {
    String titolo;
    String genere;
    int durata;

    public Film(String titolo, String genere, int durata) {
        this.titolo = titolo;
        this.genere = genere;
        this.durata = durata;
    }

    public void mostraDati() {
        System.out.println("Titolo: " + titolo);
        System.out.println(" Genere: " + genere);
        System.out.println(" Durata (min): " + durata);
    }

    public void mostraDurataOre() {
        System.out.println("Ore: " + (float)durata/60);
    }

    public boolean isFilmLungo() {
        return durata > 120;
    }
}
