package by.fyodorov.coneproject.specification.square;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.specification.ConeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeSquareConcreteSpecification implements ConeSpecification {
    private static final Logger LOGGER = LogManager.getLogger(ConeSquareConcreteSpecification.class);
    private double concreteSquare;

    public ConeSquareConcreteSpecification(double concreteSquare) {
        this.concreteSquare = concreteSquare;
    }

    @Override
    public boolean specified(ConeEntity entity) {
        ConeProcessing processing = new ConeProcessing();
        try {
            return processing.calculateVolume(entity) == concreteSquare;
        } catch (ConeException e) {
            LOGGER.catching(e);
        }
        return false;
    }
}
