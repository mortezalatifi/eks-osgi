package de.thkoeln.eksa.osgi.imp1;

import de.thkoeln.eksa.osgi.sonstigedienste.NummernSpeicher;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class Activator implements BundleActivator {

    private ServiceRegistration nummernSpeicherService;

    public void start(BundleContext context) throws Exception {
        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("Language", "Deutsch");
        this.nummernSpeicherService = context.registerService(NummernSpeicher.class.getName(), new NummernSpeicherImpl(), props);
    }

    public void stop(BundleContext context) throws Exception {
        this.nummernSpeicherService.unregister();
        System.out.println("Goodbye from NummernSpeicher!");
    }

}
