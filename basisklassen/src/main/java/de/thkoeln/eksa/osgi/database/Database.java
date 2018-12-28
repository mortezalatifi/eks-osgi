package de.thkoeln.eksa.osgi.database;

import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;
import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Map<Integer, Konto> konten = new HashMap();
    private static Map<Integer, Kunde> kunden = new HashMap();

    public static Map<Integer, Konto> getKonten() {
        return konten;
    }

    public static Map<Integer, Kunde> getKunden() {
        return kunden;
    }
}
