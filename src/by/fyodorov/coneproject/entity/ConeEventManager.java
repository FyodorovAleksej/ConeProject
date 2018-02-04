package by.fyodorov.coneproject.entity;

import by.fyodorov.coneproject.register.ConeEvent;
import by.fyodorov.coneproject.register.ConeListener;
import by.fyodorov.coneproject.register.ParameterTupleRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * class for working with List of Observers
 */
public class ConeEventManager {
    private static final Logger LOGGER = LogManager.getLogger(ConeEventManager.class);

    private List<ConeListener> listenerList;

    public ConeEventManager() {
        listenerList = new ArrayList<ConeListener>();
    }

    /**
     * adding observer to observe list
     * @param listener new listener for adding to list
     * @param entity ConeEntity for operating in register
     */
    public void subscribe(ConeListener listener, ConeEntity entity) {
        if (!listenerList.contains(listener)) {
            LOGGER.info("subscribe cone \"" + entity + "\"");
            listenerList.add(listener);
            ParameterTupleRegister.getInstance().add(entity);
        }
    }

    /**
     * remove observer from observe list
     * @param listener listener for removing
     * @param entity ConeEntity for operating in register
     */
    public void unsubscribe(ConeListener listener, ConeEntity entity) {
        if (listenerList.contains(listener)) {
            LOGGER.info("unsubscribe cone \"" + entity + "\"");
            listenerList.remove(listener);
        }
    }

    /**
     * send event to all observers
     * @param event event for sending
     */
    public void sendAll(ConeEvent event) {
        for (ConeListener listener : listenerList) {
            LOGGER.info("update \"" + event.getSource() + "\" signal");
            listener.update(event);
        }
    }
}
