package de.thkoeln.eksa.osgi.app;

import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;
import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;
import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.ArrayList;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        ServiceReference[] var2 = context.getServiceReferences(KundeKontoVerwaltung.class.getName(), "(Language2=*)");
        KundeKontoVerwaltung kundeKontoVerwaltungsService = (KundeKontoVerwaltung) context.getService(var2[0]);

        int kunde1 = kundeKontoVerwaltungsService.neuerKunde("Tim");
        System.out.println("Kunde Tim hat Kundennummer: " + kunde1);

        int kunde2 = kundeKontoVerwaltungsService.neuerKunde("Stephan");
        System.out.println("Kunde Stephan hat Kundennummer: " + kunde2);

        int konto1 = kundeKontoVerwaltungsService.neuesKonto();
        System.out.println("Kontonummer von Konto 1: " + konto1);

        int konto2 = kundeKontoVerwaltungsService.neuesKonto();
        System.out.println("Kontonummer von Konto 2: " + konto2);

        int konto3 = kundeKontoVerwaltungsService.neuesKonto();
        System.out.println("Kontonummer von Konto 3: " + konto3);

        Kunde kundenObjekt1 = kundeKontoVerwaltungsService.getKunde(kunde1);
        Kunde kundenObjekt2 = kundeKontoVerwaltungsService.getKunde(kunde2);

        kundeKontoVerwaltungsService.besitztKonto(kundenObjekt1, konto1);
        kundeKontoVerwaltungsService.besitztKonto(kundenObjekt1, konto2);
        kundeKontoVerwaltungsService.besitztKonto(kundenObjekt2, konto3);

        ArrayList<Konto> timskonten =
                kundeKontoVerwaltungsService.alleKonten(kundenObjekt1);
        System.out.println("Alle gefundenen Konten von Tim:");
        for (Konto k : timskonten) {
            System.out.print(k.getKontonr());
            System.out.println();
        }
        ArrayList<Konto> stephanskonten =
                kundeKontoVerwaltungsService.alleKonten(kundenObjekt2);
        System.out.println("Alle gefundenen Konten von Stephan:");
        for (Konto k : stephanskonten) {
            System.out.print(k.getKontonr());
            System.out.println();
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye from Service anwendung!");
    }

}
