package by.fyodorov.coneproject.entity;

import by.fyodorov.coneproject.observe.ConeListener;

/**
 * class of Cone Entity. Storage top point, base center point, base radius
 */
public class ConeEntity {
    private ConeEventManager eventManager;

    private PointEntity top;
    private PointEntity center;
    private double radius;

    /**
     * create Cone with this base, radius and top
     * @param center - center of base
     * @param radius - radius of base
     * @param top - top point of cone
     */
    public ConeEntity(PointEntity center, double radius, PointEntity top) {
        this.center = center;
        this.radius = radius;
        this.top = top;

        eventManager = new ConeEventManager();
    }

    /**
     * getting top point
     * @return top point
     */
    public PointEntity getTop() {
        return top;
    }

    /**
     * getting base center point
     * @return center point of base
     */
    public PointEntity getCenter() {
        return center;
    }

    /**
     * getting radius of base
     * @return radius of base
     */
    public double getRadius() {
        return radius;
    }



    public void setTop(PointEntity top) {
        this.top = top;
        eventManager.sendAll();
    }

    public void setCenter(PointEntity center) {
        this.center = center;
        eventManager.sendAll();
    }

    public void setRadius(double radius) {
        this.radius = radius;
        eventManager.sendAll();
    }


    public void subscribe(ConeListener listener) {
        eventManager.subscribe(listener);
    }

    public void unsubscribe(ConeListener listener) {
        eventManager.unsubscribe(listener);
    }

    @Override
    public String toString() {
        return center.toString() + "; " + radius + "; " + top;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ConeEntity cone = (ConeEntity) obj;
        return center.equals(cone.center) && radius == cone.radius && top.equals(cone.top);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + center.hashCode();
        result = prime * result + top.hashCode();
        result = prime * result + (int)radius;
        return result;
    }
}
