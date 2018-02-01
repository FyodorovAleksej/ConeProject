package by.fyodorov.coneproject.specification.coneRadius;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.specification.ConeBoundsSettings;
import by.fyodorov.coneproject.specification.ConeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConeRadiusBetweenSpecifiction implements ConeSpecification {
    private static final Logger LOGGER = LogManager.getLogger(ConeRadiusBetweenSpecifiction.class);
    private double min;
    private double max;
    private ConeBoundsSettings settings;


    public ConeRadiusBetweenSpecifiction(double min, double max, ConeBoundsSettings settings) {
        this.min = min;
        this.max = max;
        this.settings = settings;
    }

    @Override
    public boolean specified(ConeEntity entity) {
        return ((settings.isMinInfinity() || entity.getRadius() >= min) && (settings.isMaxInfinity() || entity.getRadius() <= max));
    }
}
