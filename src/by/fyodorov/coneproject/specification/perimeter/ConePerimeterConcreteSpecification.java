package by.fyodorov.coneproject.specification.perimeter;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.specification.ConeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConePerimeterConcreteSpecification implements ConeSpecification {
    private static final Logger LOGGER = LogManager.getLogger(ConePerimeterConcreteSpecification.class);
    private double concretePerimeter;

    public ConePerimeterConcreteSpecification(double concretePerimeter) {
        this.concretePerimeter = concretePerimeter;
    }

    @Override
    public boolean specified(ConeEntity entity) {
        ConeProcessing processing = new ConeProcessing();
        try {
            return processing.calculateVolume(entity) == concretePerimeter;
        } catch (ConeException e) {
            LOGGER.catching(e);
        }
        return false;
    }
}
