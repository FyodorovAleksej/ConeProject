package test.fyodorov.coneproject.register;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.register.ConeRegister;
import by.fyodorov.coneproject.register.ParamsRegister;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConeListenerTest {
    ConeRegister params;

    @BeforeClass
    public void setUp() throws Exception {
        params = ParamsRegister.getInstance();
    }

    @AfterClass
    public void tearDown() {
    }

    @Test
    public void coneListenerTest() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        coneEntity.subscribe(params);
        coneEntity.setRadius(23);
        coneEntity.setRadius(21);
    }
}
