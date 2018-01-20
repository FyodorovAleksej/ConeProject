package by.fyodorov.coneproject.processing;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * class with logic operations of Cone
 */
public class ConeProcessing {
    private static final Logger log = LogManager.getLogger(ConeProcessing.class);

    /**
     * getting volume of cone
     * @param cone cone for getting volume
     * @return volume of this cone
     */
    public double getVolume(ConeEntity cone) {
        log.info("getting volume \"" + cone + "\"");
        return (getVectorLength(cone.getCenter(), cone.getTop()) * Math.PI * Math.pow(cone.getRadius(), 2) / 3);
    }

    /**
     * getting all surface area
     * @param cone cone for getting area
     * @return all area of cone
     */
    public double getSquare(ConeEntity cone) {
        log.info("getting square \"" + cone + "\"");
        return ((Math.hypot(getVectorLength(cone.getCenter(), cone.getTop()), cone.getRadius()) + cone.getRadius()) * Math.PI * cone.getRadius());
    }

    /**
     * is the cone base is in the coordinates plane?
     * @param cone cone for checking
     * @return is the cone base is in the coordinates plane?
     */
    public boolean coordinateState(ConeEntity cone) {
        log.info("getting coordinate state \"" + cone + "\"");
        double x1 = cone.getCenter().getX();
        double y1 = cone.getCenter().getY();
        double z1 = cone.getCenter().getZ();

        double x2 = cone.getTop().getX();
        double y2 = cone.getTop().getY();
        double z2 = cone.getTop().getZ();

        return ((x1 == x2 && y1 == y2 && z1 != z2 && z1 == 0) ||
                (x1 == x2 && y1 != y2 && z1 == z2 && y1 == 0) ||
                (x1 != x2 && y1 == y2 && z1 == z2 && x1 == 0));
    }

    /**
     * division coefficient of volume by coordinate plane
     * @param cone cone for getting coefficient
     * @return division coefficient
     */
    public double coordinateDivision(ConeEntity cone) {
        log.info("getting coordinate division \"" + cone + "\"");
        if (!coordinateState(cone)) {
            double x1 = cone.getCenter().getX();
            double y1 = cone.getCenter().getY();
            double z1 = cone.getCenter().getZ();

            double x2 = cone.getTop().getX();
            double y2 = cone.getTop().getY();
            double z2 = cone.getTop().getZ();

            if (x1 == x2 && y1 == y2 && z1 != z2) {
                if (z1 >= 0 ^ z2 >= 0) {
                    return Math.pow(getVectorLength(cone.getCenter(), cone.getTop()) /
                            getVectorLength(cone.getTop(), new PointEntity(x1, y1, 0)), 3);
                }
            } else if (x1 == x2 && y1 != y2 && z1 == z2) {
                if (y1 >= 0 ^ y2 >= 0) {
                    return Math.pow(getVectorLength(cone.getCenter(), cone.getTop()) /
                            getVectorLength(cone.getTop(), new PointEntity(x1, 0, z1)), 3);
                }
            } else if (x1 != x2 && y1 == y2 && z1 == z2) {
                if (x1 >= 0 ^ x2 >= 0) {
                    return Math.pow(getVectorLength(cone.getCenter(), cone.getTop()) /
                            getVectorLength(cone.getTop(), new PointEntity(0, y1, z1)), 3);
                }
            }
        }
        return 0;
    }

    /**
     * checking figure to Cone
     * @param cone cone for checking
     * @return is figure was cone?
     */
    public boolean isCone(ConeEntity cone) {
        log.info("isCone? \"" + cone + "\"");
        return (cone.getRadius() > 0 && !cone.getCenter().equals(cone.getTop()));
    }

    /**
     * getting vector length between 2 points
     * @param point1 first point
     * @param point2 second point
     * @return length of vector
     */
    private double getVectorLength(PointEntity point1, PointEntity point2) {
        double deltaX = point1.getX() - point2.getX();
        double deltaY = point1.getY() - point2.getY();
        double deltaZ = point1.getZ() - point2.getZ();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2) + Math.pow(deltaZ, 2));
    }
}
