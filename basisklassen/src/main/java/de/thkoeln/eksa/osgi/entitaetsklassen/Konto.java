package de.thkoeln.eksa.osgi.entitaetsklassen;

public class Konto {

    private int kontonr;

    public Konto(int kontonr) {
        this.kontonr = kontonr;
    }

    public int getKontonr() {
        return kontonr;
    }

    public void setKontonr(int kontonr) {
        this.kontonr = kontonr;
    }
}
