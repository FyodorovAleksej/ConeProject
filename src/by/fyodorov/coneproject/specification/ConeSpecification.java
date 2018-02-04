package by.fyodorov.coneproject.specification;

import by.fyodorov.coneproject.entity.ConeEntity;

/**
 * specification interface for searching in ConeEntity storage
 */
@FunctionalInterface
public interface ConeSpecification {

    /**
     * method for filter ConeEntity object
     * @param entity ConeEntity object for filtering
     * @return is ConeEntity object accepted?
     */
    boolean specified(ConeEntity entity);
}
