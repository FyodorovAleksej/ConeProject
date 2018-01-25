package by.fyodorov.coneproject.entity;

import by.fyodorov.coneproject.register.ConeEvent;
import by.fyodorov.coneproject.register.ConeRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConeEventManager {
    private static final Logger LOGGER = LogManager.getLogger(ConeEventManager.class);

    private List<ConeRegister> listeners;

    public ConeEventManager() {
        listeners = new ArrayList<ConeRegister>();
    }

    public void subscribe(ConeRegister listener, ConeEntity entity) {
        if (!listeners.contains(listener)) {
            LOGGER.info("subscribe cone \"" + entity + "\"");
            listeners.add(listener);
            listener.add(entity);
        }
    }

    public void unsubscribe(ConeRegister listener, ConeEntity entity) {
        if (listeners.contains(listener)) {
            LOGGER.info("unsubscribe cone \"" + entity + "\"");
            listeners.remove(listener);
            listener.remove(entity);
        }
    }

    public void sendAll(ConeEvent event) {
        for (ConeRegister listener : listeners) {
            LOGGER.info("update \"" + event.getSource() + "\" signal");
            listener.update(event);
        }
    }
}
