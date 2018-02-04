package test.fyodorov.coneproject.register;

import by.fyodorov.coneproject.action.ConeCreator;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.register.*;
import by.fyodorov.coneproject.repository.ConeEntityStorageImpl;
import by.fyodorov.coneproject.repository.ConeStorable;
import by.fyodorov.coneproject.specification.ConeBoundsSetting;
import by.fyodorov.coneproject.specification.radius.ConeRadiusBetweenSpecifiction;
import by.fyodorov.coneproject.specification.volume.ConeVolumeBetweenSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class ConeRegisterTest {
    private final static double DELTA = 0.001;
    private ConeRegister register;

    @BeforeClass
    public void setUp() throws Exception {
        register = ParameterTupleRegister.getInstance();
    }

    @AfterClass
    public void tearDown() {
    }

    @AfterMethod
    public void tearMethodDown() {
        ConeEntityStorageImpl.getInstance().clear();
    }

    @Test
    public void testConeListenerPositive() throws ConeException {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        coneEntity.subscribe(new ConeObserverImpl());
        coneEntity.setRadius(23);
        ConeParameterTuple params = register.findParams(coneEntity.getConeId());
        double expected = 2215.87;
        Assert.assertEquals(params.getVolume(), expected, DELTA, "Listener Test Failed");
    }

    @Test
    public void testConeListenerNegative() throws ConeException {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        ConeListener observer = new ConeObserverImpl();
        coneEntity.subscribe(observer);
        coneEntity.setRadius(23);
        coneEntity.unsubscribe(observer);
        coneEntity.setRadius(56);
        ConeParameterTuple params = register.findParams(coneEntity.getConeId());
        double expected = 2215.87;
        Assert.assertEquals(params.getVolume(), expected, DELTA, "Listener Test Failed");
    }


    @Test
    public void testConeRepositoryRadiusFilter() throws Exception {
        ConeStorable storage = ConeEntityStorageImpl.getInstance();
        ConeCreator creator = new ConeCreator();
        LinkedList<ConeEntity> list = creator.createAll("input/input.txt");
        storage.addAll(list);
        LinkedList<ConeEntity> filtred = storage.findBySpecification(new ConeRadiusBetweenSpecifiction(1,15, ConeBoundsSetting.NONE));
        Assert.assertEquals(filtred.size(), 1);
    }

    @Test
    public void testConeRepositoryVolumeFilter() throws Exception {
        ConeStorable storage = ConeEntityStorageImpl.getInstance();
        ConeCreator creator = new ConeCreator();
        LinkedList<ConeEntity> list = creator.createAll("input/input.txt");
        storage.addAll(list);
        LinkedList<ConeEntity> filtred = storage.findBySpecification(new ConeVolumeBetweenSpecification(0,20, ConeBoundsSetting.NONE));
        Assert.assertEquals(filtred.size(), 2);
    }
}
