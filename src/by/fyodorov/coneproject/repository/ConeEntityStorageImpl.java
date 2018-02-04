package by.fyodorov.coneproject.repository;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.specification.ConeSpecification;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.Predicate;

/**
 * class for storing all ConeEntities Objects. Singleton
 */
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

    /**
     * adding new ConeEntity object to storage
     * @param entity ConeEntity object to adding
     * @return is this object already exist in storage?
     */
    @Override
    public boolean add(ConeEntity entity) {
        boolean contain = coneEntities.contains(entity);
        coneEntities.add(entity);
        return contain;
    }

    /**
     * adding new ConeEntities objects from list to storage
     * @param list List of ConeEntities for adding in storage
     * @return is any ConeEntity object in list already exist in storage?
     */
    @Override
    public boolean addAll(LinkedList<ConeEntity> list) {
        boolean contain = false;
        ListIterator<ConeEntity> iterator =  list.listIterator(0);
        while(!contain && iterator.hasNext()) {
            contain = coneEntities.contains(iterator.next());
        }
        coneEntities.addAll(list);
        return contain;
    }

    /**
     * removing ConeEntity object from storage
     * @param entity ConeEntity object for removing from storage
     * @return was this entity existed in storage?
     */
    @Override
    public boolean remove(ConeEntity entity) {
        boolean contain = coneEntities.contains(entity);
        coneEntities.remove(entity);
        return contain;
    }

    /**
     * clear storage. Delete all ConeEntities from storage
     */
    @Override
    public void clear() {
        coneEntities.clear();
    }

    /**
     * finding ConeEntities objects in storage by lambda function
     * @param predicate lambda function for filter storage
     * @return List of all ConeEntities objects from storage, that was tested successfully by predicate
     */
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

    /**
     * finding ConeEntities objects from storage by some specification
     * @param specification object, that implement specification
     * @return List of all ConeEntities objects from storage, that was tested successfully by specification
     */
    @Override
    public LinkedList<ConeEntity> findBySpecification(ConeSpecification specification) {
        return findByPredicate(specification::specified);
    }

    /**
     * sorting storage by some Comparator
     * @param comparator object, that implement Comparator for compare ConeEntities objects in storage
     */
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
