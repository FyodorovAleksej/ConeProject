package by.fyodorov.coneproject.specification.radius;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.specification.ConeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * class of specification by concrete radius (x == value)
 */
public class ConeRadiusConcreteSpecification implements ConeSpecification {
    private static final Logger LOGGER = LogManager.getLogger(ConeRadiusConcreteSpecification.class);
    private double concreteRadius;

    public ConeRadiusConcreteSpecification(double concreteRadius) {
        this.concreteRadius = concreteRadius;
    }

    @Override
    public boolean specified(ConeEntity entity) {
        ConeProcessing processing = new ConeProcessing();
        try {
            return processing.calculateVolume(entity) == concreteRadius;
        } catch (ConeException e) {
            LOGGER.catching(e);
        }
        return false;
    }
}
