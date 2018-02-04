package by.fyodorov.coneproject.compare;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

/**
 * comparator for sorting ConesEntity
 */
public class ConeComparator {
    private static final Logger LOGGER = LogManager.getLogger(ConeComparator.class);

    /**
     * getting comparator by radius of ConeEntity
     * @return result of comparing radius of ConeEntities
     */
    public Comparator<ConeEntity> comparatorByRadius() {
        return new Comparator<ConeEntity>() {
            @Override
            public int compare(ConeEntity o1, ConeEntity o2) {
                return Double.compare(o1.getRadius(), o2.getRadius());
            }
        };
    }

    /**
     * getting comparator by square of ConeEntities
     * @return result of comparing square of ConeEntities
     */
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

    /**
     * getting comparator by volume of ConeEntity
     * @return result of comparing volume of ConeEntities
     */
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

    /**
     * getting comparator by perimeter of ConeEntity
     * @return result of comparing perimeter of ConeEntities
     */
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
