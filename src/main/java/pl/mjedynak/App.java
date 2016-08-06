package pl.mjedynak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mjedynak.service.*;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class.getName());

    public static void main(String[] args) {
        invoke(new DefaultService());
        logger.debug("----------------------\n");
        invoke(new LazyInitService());
        logger.debug("----------------------\n");
        invoke(LazyInitWithProxyServiceFactory.createService());
        logger.debug("----------------------\n");
        invoke(LazyInitWithProxyThreadSafeServiceFactory.createService());
    }

    private static void invoke(Service service) {
        logger.debug("Invoking method");
        logger.debug("Current time:" + service.getTime().toString());
    }
}
