package test.fyodorov.coneproject.register;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.register.ConeParams;
import by.fyodorov.coneproject.register.ConeRegister;
import by.fyodorov.coneproject.register.ParamsRegister;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConeRegisterTest {
    private final static double DELTA = 0.001;
    ConeRegister register;

    @BeforeClass
    public void setUp() throws Exception {
        register = ParamsRegister.getInstance();
    }

    @AfterClass
    public void tearDown() {
    }

    @Test
    public void testConeListenerPositive() throws ConeException {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        coneEntity.subscribe(register);
        coneEntity.setRadius(23);
        ConeParams params = register.getParams(coneEntity.getConeId());
        double expected = 2215.87;
        Assert.assertEquals(params.getVolume(), expected, DELTA, "Listener Test Failed");
    }

    @Test
    public void testConeListenerNegative() throws ConeException {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        coneEntity.subscribe(register);
        coneEntity.setRadius(23);
        coneEntity.unsubscribe(register);
        coneEntity.setRadius(56);
        ConeParams params = register.getParams(coneEntity.getConeId());
        double expected = 2215.87;
        Assert.assertEquals(params.getVolume(), expected, DELTA, "Listener Test Failed");
    }
}
