package Lessons14;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Project java_core_android
 *
 * @Author Alexander Grigorev
 * Created 18.02.2021
 * v1.0
 */

// Trace > Debug > Info > Warn > Error > Fatal

public class LoggingApp {

    public static final Logger LOGGER = LogManager.getLogger(LoggingApp.class);
//    public static final Logger LOGGER = LogManager.getLogger("Root");// выводит <Root level="fatal">

    public static void main(String[] args) {
        String s1 = "First placeholder";
        int i2 = 12;
        LOGGER.trace("Trace log");
        LOGGER.debug("Debug log");
        LOGGER.info("Info log {} {}", i2, s1);
        LOGGER.warn("Warn log");
        LOGGER.error("Error log");
        LOGGER.fatal("Fatal log");
        tryError();
    }

    public static void tryError() {
        try {
            throw new RuntimeException("Some exception");
        } catch (RuntimeException e) {
//            LOGGER.error(e);
//            LOGGER.throwing(e);
            LOGGER.throwing(Level.ERROR, e);
        }
    }
}
