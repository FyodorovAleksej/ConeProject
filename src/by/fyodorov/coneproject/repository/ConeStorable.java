package by.fyodorov.coneproject.repository;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.specification.ConeSpecification;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;

public interface ConeStorable {
    boolean add(ConeEntity entity);
    boolean addAll(LinkedList<ConeEntity> list);
    boolean remove(ConeEntity entity);
    void clear();
    LinkedList<ConeEntity> findByPredicate(Predicate<ConeEntity> predicate);
    LinkedList<ConeEntity> findBySpecification(ConeSpecification specification);
    void sort(Comparator<ConeEntity> comparator);
}
