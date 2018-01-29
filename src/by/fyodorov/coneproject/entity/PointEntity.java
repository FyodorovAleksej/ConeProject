package by.fyodorov.coneproject.entity;

/**
 * class of Point. Storage x, y, z coordinates
 */
public class PointEntity {
    private double x;
    private double y;
    private double z;

    /**
     * creating point with coordinates (x, y, z)
     * @param x x coordinate
     * @param y y coordinate
     * @param z z coordinate
     */
    public PointEntity(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }


    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PointEntity point = (PointEntity) obj;
        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)x;
        result = prime * result + (int)y;
        result = prime * result + (int)z;
        return result;
    }
}
