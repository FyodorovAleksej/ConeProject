package by.fyodorov.coneproject.specification.coneSquare;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.specification.ConeBoundsSettings;
import by.fyodorov.coneproject.specification.ConeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeSquareBetweenSpecification implements ConeSpecification {
    private static final Logger LOGGER = LogManager.getLogger(ConeSquareBetweenSpecification.class);
    private double min;
    private double max;
    private ConeBoundsSettings settings;


    public ConeSquareBetweenSpecification(double min, double max, ConeBoundsSettings settings) {
        this.min = min;
        this.max = max;
        this.settings = settings;
    }

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
