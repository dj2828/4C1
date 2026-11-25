package auto;

public class Auto {
    String marca;
    String modello;
    int anno;
    int chilometri;

    public Auto(String marca, String modello, int anno, int chilometri) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.chilometri = chilometri;
    }

    public void mostraDati() {
        System.out.println(marca + " - " + modello + " - " + anno + " - " + chilometri);
    }

    public void aggiungiChilometri(int km) {
        chilometri += km;
    }
}
