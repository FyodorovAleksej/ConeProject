package by.fyodorov.coneproject.repository;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.specification.ConeSpecification;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * interface of storage for ConeEntity
 */
public interface ConeStorable {

    /**
     * adding new ConeEntity to storage
     * @param entity new object of ConeEntity to store
     * @return is this object already exist in storage?
     */
    boolean add(ConeEntity entity);

    /**
     * adding all ConeEntities objects from List to storage
     * @param list List of ConeEntity objects to store
     * @return is any object in list already exist in storage?
     */
    boolean addAll(LinkedList<ConeEntity> list);

    /**
     * remove ConeEntity object from storage
     * @param entity ConeEntity object for removing
     * @return was this object existed  in storage before removing?
     */
    boolean remove(ConeEntity entity);

    /**
     * clear storage. Deleting all ConeEntity objects from storage
     */
    void clear();

    /**
     * finding ConeEntity objects in storage by lambda function
     * @param predicate lambda function for filter storage
     * @return List of all ConeEntities objects from storage, that was tested successfully by predicate
     */
    LinkedList<ConeEntity> findByPredicate(Predicate<ConeEntity> predicate);

    /**
     * finding ConeEntities objects from storage by some specification
     * @param specification object, that implement specification
     * @return List of all ConeEntities objects from storage, that was tested successfully by specification
     */
    LinkedList<ConeEntity> findBySpecification(ConeSpecification specification);

    /**
     * sorting storage by some Comparator
     * @param comparator object, that implement Comparator for compare ConeEntities objects in storage
     */
    void sort(Comparator<ConeEntity> comparator);
}
