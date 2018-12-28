package de.thkoeln.eska.osgi.imp2;

import de.thkoeln.eksa.osgi.sonstigedienste.NummernSpeicher;
import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class Activator implements BundleActivator{

    private ServiceRegistration arrayService;

    private static NummernSpeicher NummernSpeicherService = null;

    public static NummernSpeicher getNummernSpeicherService() {
        return NummernSpeicherService;
    }

    public void start(BundleContext context) throws Exception {
        System.out.println("NummerSpeicher starts!");

        ServiceReference[] var2 = context.getServiceReferences(NummernSpeicher.class.getName(), "(Language=*)");
        NummernSpeicherService = (NummernSpeicher) context.getService(var2[0]);

        Hashtable<String, String> props2 = new Hashtable<String, String>();
        props2.put("Language2", "Deutsch2");
        this.arrayService = context.registerService(KundeKontoVerwaltung.class.getName(), new KundeVerwaltungImpl(), props2);
    }

    public void stop(BundleContext context) throws Exception {
        this.arrayService.unregister();
        System.out.println("Goodbye from KundeKontoVerwaltung!");
    }

}
