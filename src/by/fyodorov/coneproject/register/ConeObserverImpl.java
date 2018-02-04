package by.fyodorov.coneproject.register;

/**
 * class of Observer
 */
public class ConeObserverImpl implements ConeListener {

    /**
     * handler for ConeEvent
     * @param event object of event from ConeEntity
     */
    @Override
    public void update(ConeEvent event) {
        ConeRegister register = ParameterTupleRegister.getInstance();
        register.update(event.getSource());
    }
}
