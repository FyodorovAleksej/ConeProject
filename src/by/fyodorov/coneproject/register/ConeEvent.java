package by.fyodorov.coneproject.register;

import by.fyodorov.coneproject.entity.ConeEntity;

import java.util.EventObject;

public class ConeEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ConeEvent(ConeEntity source) {
        super(source);
    }

    @Override
    public ConeEntity getSource() {
        return (ConeEntity) super.getSource();
    }
}
