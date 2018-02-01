package by.fyodorov.coneproject.repository;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.specification.ConeSpecification;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;

public class ConeEntityStorageImpl implements ConeStorable {
    private static volatile ConeEntityStorageImpl instance;

    private LinkedList<ConeEntity> coneEntities;

    private ConeEntityStorageImpl() {
        coneEntities = new LinkedList<ConeEntity>();
    }

    public static ConeEntityStorageImpl getInstance() {
        if (instance == null) {
            synchronized (ConeEntityStorageImpl.class) {
                if (instance == null) {
                    instance = new ConeEntityStorageImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean add(ConeEntity entity) {
        boolean contain = coneEntities.contains(entity);
        coneEntities.add(entity);
        return contain;
    }

    @Override
    public boolean addAll(LinkedList<ConeEntity> list) {
        boolean contain = false;
        for (ConeEntity entity : list) {
            if (coneEntities.contains(entity)) {
                contain = true;
                break;
            }
        }
        coneEntities.addAll(list);
        return contain;
    }

    @Override
    public boolean remove(ConeEntity entity) {
        boolean contain = coneEntities.contains(entity);
        coneEntities.remove(entity);
        return contain;
    }

    @Override
    public LinkedList<ConeEntity> findByPredicate(Predicate<ConeEntity> predicate) {
        LinkedList<ConeEntity> resultList = new LinkedList<ConeEntity>();
        for (ConeEntity entity : coneEntities) {
            if (predicate.test(entity)) {
                resultList.add(entity);
            }
        }
        return resultList;
    }

    @Override
    public LinkedList<ConeEntity> findBySpecification(ConeSpecification specification) {
        return findByPredicate(specification::specified);
    }

    @Override
    public void sort(Comparator<ConeEntity> comparator) {
        coneEntities.sort(comparator);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        for (ConeEntity entity : coneEntities) {
            builder.append(entity.toString()).append(" ;\n");
        }
        builder.append("}");
        return builder.toString();
    }
}
