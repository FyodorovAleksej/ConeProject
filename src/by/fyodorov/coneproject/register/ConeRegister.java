package by.fyodorov.coneproject.register;

import by.fyodorov.coneproject.entity.ConeEntity;

public interface ConeRegister {
    void add(ConeEntity cone);
    void remove(ConeEntity cone);
    void update(ConeEvent event);
}
