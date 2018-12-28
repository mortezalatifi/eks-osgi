package de.thkoeln.eksa.osgi.entitaetsklassen;

import java.util.ArrayList;

public class Kunde {

    private String name; // Name des Kunden
    private int kundennummer; // eindeutige Kundennummer
    private ArrayList<Integer> konten; // Liste der Kontonummern aller Konten des Kunden

    //Konstruktor
    public Kunde(){

    }

    public Kunde(String name, int kundennummer) {
        this.name = name;
        this.kundennummer = kundennummer;
        this.konten = new ArrayList<Integer>();
    }

    //fuegt neue Kontonummer zur Liste konten hinzu
    public void addKonto (int kontonr) {
        konten.add(kontonr);
    }

    // Getter und Setter:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    public ArrayList<Integer> getKonten() {
        return konten;
    }

}
