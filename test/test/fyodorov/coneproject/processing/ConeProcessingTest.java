package test.fyodorov.coneproject.processing;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.processing.ConeProcessing;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConeProcessingTest {

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetVolumeBasePositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.getSquare(coneEntity);
        double expected = 75.39816;
        double delta = 0.001;
        Assert.assertEquals(actual, expected, delta, "Base Square Test Failed");
    }

    @Test
    public void testGetVolumeIsoPositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(4,4,1), 3, new PointEntity(4,4,5));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.getSquare(coneEntity);
        double expected = 75.39816;
        double delta = 0.001;
        Assert.assertEquals(actual, expected, delta, "Iso Square Test Failed");
    }


    @Test
    public void testCoordinateDivisionPositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(0,0,-2), 3, new PointEntity(0,0,2));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.coordinateDivision(coneEntity);
        double expected = 8;
        Assert.assertEquals(actual, expected, "Coordinate Division Test Failed");
    }

    @Test
    public void testCoordinateDivisionNegative() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(0,0,-2), 3, new PointEntity(0,2,2));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.coordinateDivision(coneEntity);
        double expected = 0;
        Assert.assertEquals(actual, expected, "Coordinate Division Test Failed");
    }

    @Test
    public void testCoordinateDivisionCordNegative() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(6,6,0), 5, new PointEntity(6,6,20));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.coordinateDivision(coneEntity);
        double expected = 0;
        Assert.assertEquals(actual, expected, "Coordinate Division Test Failed");
    }


    @Test
    public void testCoordinateStatePositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(2,5,0), 5, new PointEntity(2,5,4));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertTrue(processing.coordinateState(coneEntity), "Coordinate State Failed");
    }

    @Test
    public void testCoordinateStateIsoNegative() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,2,0), 5, new PointEntity(2,3,4));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertFalse(processing.coordinateState(coneEntity), "Coordinate State Failed");
    }


    @Test
    public void testIsConePositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,2,0), 5, new PointEntity(2,3,4));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertTrue(processing.isCone(coneEntity), "Is Cone Failed");
    }

    @Test
    public void testIsConeRadNegative() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,2,0), -4, new PointEntity(2,3,4));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertFalse(processing.isCone(coneEntity), "Is Cone Failed");
    }

    @Test
    public void testIsConePointNegative() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(2,2,0), 4, new PointEntity(2,2,0));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertFalse(processing.isCone(coneEntity), "Is Cone Failed");
    }


    @Test
    public void testGetSquare() throws Exception {

    }

}