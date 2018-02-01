package by.fyodorov.coneproject.register;

import by.fyodorov.coneproject.entity.ConeEntity;

import java.util.LinkedList;

/**
 * interface of Listener (Register)
 */
public interface ConeRegister {

    /**
     * for getting params from register
     * @param id id in register
     * @return params of this cone
     */
    ConeParams findParams(long id);

    /**
     * adding new cone in register
     * @param cone cone for adding
     */
    void add(ConeEntity cone);

    /**
     * removing cone from register
     * @param cone cone for removing
     */
    void remove(ConeEntity cone);

    /**
     * updating info in register
     * @param event event of Cone
     */
    void update(ConeEvent event);

    LinkedList<ConeParams> findAll();
}
