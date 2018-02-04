package by.fyodorov.coneproject.specification.square;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.specification.ConeBoundsSetting;
import by.fyodorov.coneproject.specification.ConeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * class of specification by square between bounds (min <= x <= max)
 */
public class ConeSquareBetweenSpecification implements ConeSpecification {
    private static final Logger LOGGER = LogManager.getLogger(ConeSquareBetweenSpecification.class);
    private double min;
    private double max;
    private ConeBoundsSetting settings;


    public ConeSquareBetweenSpecification(double min, double max, ConeBoundsSetting settings) {
        this.min = min;
        this.max = max;
        this.settings = settings;
    }

    /**
     * @param entity ConeEntity object for filtering
     * @return is ConeEntity square in bounds (min <= x <= max)
     */
    @Override
    public boolean specified(ConeEntity entity) {
        ConeProcessing processing = new ConeProcessing();
        try {
            return ((settings.isMinInfinity() || processing.calculateSquare(entity) >= min) && (settings.isMaxInfinity() || processing.calculateSquare(entity) <= max));
        } catch (ConeException e) {
            LOGGER.catching(e);
        }
        return false;
    }
}
