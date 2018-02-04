package by.fyodorov.coneproject.register;

/**
 * listener, that will handle events from ConeEntity
 */
public interface ConeListener {

    /**
     * event handle
     * @param event object of event from ConeEntity
     */
    void update(ConeEvent event);
}
