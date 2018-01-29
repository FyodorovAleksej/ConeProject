package by.fyodorov.coneproject.register;

import by.fyodorov.coneproject.entity.ConeEntity;
import java.util.EventObject;

public class ConeEvent extends EventObject {

    /**
     * event of Cone
     * @param source source of event (ConeEntity)
     */
    public ConeEvent(ConeEntity source) {
        super(source);
    }

    @Override
    public ConeEntity getSource() {
        return (ConeEntity) super.getSource();
    }
}
