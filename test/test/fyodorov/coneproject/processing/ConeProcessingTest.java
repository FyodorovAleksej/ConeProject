package test.fyodorov.coneproject.processing;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.processing.ConeProcessing;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConeProcessingTest {
    private final static double DELTA = 0.001;

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testGetSquareBasePositive() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        ConeProcessing processing = new ConeProcessing();
        double expected = 75.39816;
        double actual = processing.getSquare(coneEntity);
        Assert.assertEquals(actual, expected, DELTA, "Base Square Test Failed");
    }

    @Test
    public void testGetSquareIsoPositive() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(4, 4, 1), 3, new PointEntity(4, 4, 5));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.getSquare(coneEntity);
        double expected = 75.39816;
        Assert.assertEquals(actual, expected, DELTA, "Iso Square Test Failed");
    }

    @Test
    public void testGetSquareNegative() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(4,4,1), 20, new PointEntity(4,4,1));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.getSquare(coneEntity);
        double expected = 0;
        Assert.assertEquals(actual, expected, "Square Negative Test Failed");
    }




    @Test
    public void testGetVolumePositive() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(2,4,1), 4, new PointEntity(4,4,1));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.getVolume(coneEntity);
        double expected = 33.5103;
        Assert.assertEquals(actual, expected, DELTA, "Volume Positive Test Failed");
    }

    @Test
    public void testGetVolumeIsoPositive() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(2, 6, 1), 3, new PointEntity(4, 4, 3));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.getVolume(coneEntity);
        double expected = 32.6483;
        Assert.assertEquals(actual, expected, DELTA, "Volume Iso Positive Test Failed");
    }

    @Test
    public void testGetVolumeNegative() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(4,4,1), 20, new PointEntity(4,4,1));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.getVolume(coneEntity);
        double expected = 0;
        Assert.assertEquals(actual, expected, "Volume Negative Test Failed");
    }



        @Test
    public void testCoordinateDivisionPositive() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(0,0,-2), 3, new PointEntity(0,0,2));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.coordinateDivision(coneEntity);
        double expected = 8;
        Assert.assertEquals(actual, expected, "Coordinate Division Test Failed");
    }

    @Test
    public void testCoordinateDivisionNegative() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(0,0,-2), 3, new PointEntity(0,2,2));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.coordinateDivision(coneEntity);
        double expected = 0;
        Assert.assertEquals(actual, expected, "Coordinate Division Test Failed");
    }

    @Test
    public void testCoordinateDivisionCordNegative() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(6,6,0), 5, new PointEntity(6,6,20));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.coordinateDivision(coneEntity);
        double expected = 0;
        Assert.assertEquals(actual, expected, "Coordinate Division Test Failed");
    }




    @Test
    public void testCoordinateStatePositive() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(2,5,0), 5, new PointEntity(2,5,4));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertTrue(processing.coordinateState(coneEntity), "Coordinate State Failed");
    }

    @Test
    public void testCoordinateStateNegative() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,2,0), 5, new PointEntity(2,3,4));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertFalse(processing.coordinateState(coneEntity), "Coordinate State Failed");
    }



    @Test
    public void testIsConePositive() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,2,0), 5, new PointEntity(2,3,4));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertTrue(processing.isCone(coneEntity), "Is Cone Failed");
    }

    @Test
    public void testIsConeRadiusNegative() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,2,0), -4, new PointEntity(2,3,4));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertFalse(processing.isCone(coneEntity), "Is Cone Failed");
    }

    @Test
    public void testIsConePointNegative() {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(2,2,0), 4, new PointEntity(2,2,0));
        ConeProcessing processing = new ConeProcessing();
        Assert.assertFalse(processing.isCone(coneEntity), "Is Cone Failed");
    }

}