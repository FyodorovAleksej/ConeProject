package by.fyodorov.coneproject.entity;

import by.fyodorov.coneproject.action.ConeCreatorId;
import by.fyodorov.coneproject.register.ConeEvent;
import by.fyodorov.coneproject.register.ConeRegister;

/**
 * class of Cone Entity. Storage top point, base center point, base radius
 */
public class ConeEntity {
    private ConeEventManager eventManager;

    private long coneId;

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
        coneId = ConeCreatorId.getId();
    }


    public PointEntity getTop() {
        return top;
    }

    public PointEntity getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public long getConeId() {
        return coneId;
    }



    public void setTop(PointEntity top) {
        this.top = top;
        eventManager.sendAll(new ConeEvent(this));
    }

    public void setCenter(PointEntity center) {
        this.center = center;
        eventManager.sendAll(new ConeEvent(this));
    }

    public void setRadius(double radius) {
        this.radius = radius;
        eventManager.sendAll(new ConeEvent(this));
    }


    /**
     * subscribe listener
     * @param listener listener for subscribe
     */
    public void subscribe(ConeRegister listener) {
        eventManager.subscribe(listener, this);
    }

    /**
     * unsubscribe listener
     * @param listener listener for unsubscribe
     */
    public void unsubscribe(ConeRegister listener) {
        eventManager.unsubscribe(listener, this);
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
