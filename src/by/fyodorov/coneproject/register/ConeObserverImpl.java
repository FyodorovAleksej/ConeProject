package by.fyodorov.coneproject.register;

public class ConeObserverImpl implements ConeListener {

    @Override
    public void update(ConeEvent event) {
        ConeRegister register = ParameterTupleRegister.getInstance();
        register.update(event.getSource());
    }
}
