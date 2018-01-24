package test.fyodorov.coneproject.observe;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.observe.ConeListener;
import by.fyodorov.coneproject.observe.PerimeterListener;
import by.fyodorov.coneproject.observe.SquareListener;
import by.fyodorov.coneproject.observe.VolumeListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConeListenerTest {
    private ConeListener listener1;
    private ConeListener listener2;
    private ConeListener listener3;

    @BeforeClass
    public void setUp() throws Exception {
        listener1 = PerimeterListener.getInstance();
        listener2 = SquareListener.getInstance();
        listener3 = VolumeListener.getInstance();
    }

    @AfterClass
    public void tearDown() {
    }

    @Test
    public void coneListenerTest() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        coneEntity.subscribe(listener1);
        coneEntity.subscribe(listener2);
        coneEntity.subscribe(listener3);
        coneEntity.setRadius(23);
        coneEntity.setRadius(21);
    }
}
