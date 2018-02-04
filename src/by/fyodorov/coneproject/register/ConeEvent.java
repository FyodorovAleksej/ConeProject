package by.fyodorov.coneproject.register;

import by.fyodorov.coneproject.entity.ConeEntity;
import java.util.EventObject;

/**
 * class of event for sending to Observer
 */
public class ConeEvent extends EventObject {

    /**
     * event of Cone
     * @param source source of event (ConeEntity)
     */
    public ConeEvent(ConeEntity source) {
        super(source);
    }

    /**
     * getting source of event
     * @return source of event (ConeEntity)
     */
    @Override
    public ConeEntity getSource() {
        return (ConeEntity) super.getSource();
    }
}
