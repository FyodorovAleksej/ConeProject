package by.fyodorov.coneproject.compare;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class ConeComparator {
    private static final Logger LOGGER = LogManager.getLogger(ConeComparator.class);

    public Comparator<ConeEntity> comparatorByRadius() {
        return new Comparator<ConeEntity>() {
            @Override
            public int compare(ConeEntity o1, ConeEntity o2) {
                return Double.compare(o1.getRadius(), o2.getRadius());
            }
        };
    }

    public Comparator<ConeEntity> comparatorBySquare() {
        return new Comparator<ConeEntity>() {
            @Override
            public int compare(ConeEntity o1, ConeEntity o2) {
                ConeProcessing processing = new ConeProcessing();
                try {
                    return Double.compare(processing.calculateSquare(o1), processing.calculateSquare(o2));
                } catch (ConeException e) {
                    LOGGER.catching(e);
                }
                return 0;
            }
        };
    }

    public Comparator<ConeEntity> comparatorByVolume() {
        return new Comparator<ConeEntity>() {
            @Override
            public int compare(ConeEntity o1, ConeEntity o2) {
                ConeProcessing processing = new ConeProcessing();
                try {
                    return Double.compare(processing.calculateVolume(o1), processing.calculateVolume(o2));
                } catch (ConeException e) {
                    LOGGER.catching(e);
                }
                return 0;
            }
        };
    }

    public Comparator<ConeEntity> comparatorByPerimeter() {
        return new Comparator<ConeEntity>() {
            @Override
            public int compare(ConeEntity o1, ConeEntity o2) {
                ConeProcessing processing = new ConeProcessing();
                try {
                    return Double.compare(processing.calculatePerimeter(o1), processing.calculatePerimeter(o2));
                } catch (ConeException e) {
                    LOGGER.catching(e);
                }
                return 0;
            }
        };
    }
}
