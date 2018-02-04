package by.fyodorov.coneproject.specification.volume;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.specification.ConeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeVolumeConcreteSpecification implements ConeSpecification {
    private static final Logger LOGGER = LogManager.getLogger(ConeVolumeConcreteSpecification.class);
    private double concreteVolume;

    public ConeVolumeConcreteSpecification(double concreteVolume) {
        this.concreteVolume = concreteVolume;
    }

    @Override
    public boolean specified(ConeEntity entity) {
        ConeProcessing processing = new ConeProcessing();
        try {
            return processing.calculateVolume(entity) == concreteVolume;
        } catch (ConeException e) {
            LOGGER.catching(e);
        }
        return false;
    }
}
