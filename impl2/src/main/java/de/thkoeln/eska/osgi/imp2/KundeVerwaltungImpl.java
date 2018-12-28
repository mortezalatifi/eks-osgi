package de.thkoeln.eska.osgi.imp2;

import de.thkoeln.eksa.osgi.database.Database;
import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;
import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;

import de.thkoeln.eksa.osgi.imp1.NummernSpeicherImpl;
import de.thkoeln.eksa.osgi.sonstigedienste.NummernSpeicher;
import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import java.util.ArrayList;
import java.util.Map;

public class KundeVerwaltungImpl implements KundeKontoVerwaltung {

    private Map<Integer, Konto> konten = Database.getKonten();
    private Map<Integer, Kunde> kunden = Database.getKunden();

    private NummernSpeicher ns = Activator.getNummernSpeicherService();

    public int neuerKunde(String s) {
        System.out.println("Es wird einneues Kunde gelegt!");
        int neueKundeNr = ns.getNeueKundenNr();
        System.out.println("Kundennummer: " + neueKundeNr);
        Kunde neuerKunde = new Kunde(s, neueKundeNr);
        kunden.put(neueKundeNr, neuerKunde);
        return neueKundeNr;
    }

    public Kunde getKunde(int i) {
        return kunden.get(i);
    }

    public ArrayList<Konto> alleKonten(Kunde kunde) {
        ArrayList<Konto> list= new ArrayList<Konto>();
        for (int i = 0; i < kunde.getKonten().size(); i++) {
            list.add(konten.get(kunde.getKonten().get(i)));
        }
        return list;
    }

    public void besitztKonto(Kunde kunde, int i) {
        kunde.addKonto(i);
    }

    public int neuesKonto() {
        int neueKontoNr = ns.getNeueKontoNr();
        Konto neuesKonto = new Konto(neueKontoNr);
        konten.put(neueKontoNr, neuesKonto);
        return neueKontoNr;
    }

}
