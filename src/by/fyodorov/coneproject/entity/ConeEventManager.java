package by.fyodorov.coneproject.entity;

import by.fyodorov.coneproject.observe.ConeListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConeEventManager {
    private List<ConeListener> listeners;

    public ConeEventManager() {
        listeners = new ArrayList<ConeListener>();
    }

    public void subscribe(ConeListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unsubscribe(ConeListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public void sendAll() {
        for (ConeListener listener : listeners) {
            listener.update();
        }
    }
}
