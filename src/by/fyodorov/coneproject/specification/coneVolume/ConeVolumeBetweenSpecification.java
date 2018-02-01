package by.fyodorov.coneproject.specification.coneVolume;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.specification.ConeBoundsSettings;
import by.fyodorov.coneproject.specification.ConeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeVolumeBetweenSpecification implements ConeSpecification {
    private static final Logger LOGGER = LogManager.getLogger(ConeVolumeBetweenSpecification.class);
    private double min;
    private double max;
    private ConeBoundsSettings settings;


    public ConeVolumeBetweenSpecification(double min, double max, ConeBoundsSettings settings) {
        this.min = min;
        this.max = max;
        this.settings = settings;
    }

    @Override
    public boolean specified(ConeEntity entity) {
        ConeProcessing processing = new ConeProcessing();
        try {
            return ((settings.isMinInfinity() || processing.calculateVolume(entity) >= min) && (settings.isMaxInfinity() || processing.calculateVolume(entity) <= max));
        } catch (ConeException e) {
            LOGGER.catching(e);
        }
        return false;
    }
}
