package de.thkoeln.eksa.osgi.imp1;

import de.thkoeln.eksa.osgi.database.Database;
import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;
import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;
import de.thkoeln.eksa.osgi.sonstigedienste.NummernSpeicher;

import java.util.ArrayList;
import java.util.Map;

public class NummernSpeicherImpl implements NummernSpeicher {

    private Map<Integer, Konto> konten = Database.getKonten();
    private Map<Integer, Kunde> kunden = Database.getKunden();

    public int getNeueKontoNr() {
        int kontoNr = konten.size()+1;
        konten.put(kontoNr, null);
        return kontoNr;
    }

    public int getNeueKundenNr() {
        int kundeNr = kunden.size()+1;
        kunden.put(kundeNr, null);
        return kundeNr;
    }
}
