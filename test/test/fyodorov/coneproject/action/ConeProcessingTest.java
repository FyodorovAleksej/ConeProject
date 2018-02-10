package test.fyodorov.coneproject.action;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConeProcessingTest {
    private final static double DELTA = 0.001;

    @Test
    public void testGetSquareBasePositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        ConeProcessing processing = new ConeProcessing();
        double expected = 75.39816;
        double actual = processing.calculateSquare(coneEntity);
        Assert.assertEquals(actual, expected, DELTA, "Base Square Test Failed");
    }

    @Test
    public void testGetSquareIsoPositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(4, 4, 1), 3, new PointEntity(4, 4, 5));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateSquare(coneEntity);
        double expected = 75.39816;
        Assert.assertEquals(actual, expected, DELTA, "Iso Square Test Failed");
    }

    @Test
    public void testGetSquareNegative() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(4,4,1), 20, new PointEntity(4,4,1));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateSquare(coneEntity);
        double expected = 0;
        Assert.assertEquals(actual, expected, "Square Negative Test Failed");
    }




    @Test
    public void testGetVolumePositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(2,4,1), 4, new PointEntity(4,4,1));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateVolume(coneEntity);
        double expected = 33.5103;
        Assert.assertEquals(actual, expected, DELTA, "Volume Positive Test Failed");
    }

    @Test
    public void testGetVolumeIsoPositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(2, 6, 1), 3, new PointEntity(4, 4, 3));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateVolume(coneEntity);
        double expected = 32.6483;
        Assert.assertEquals(actual, expected, DELTA, "Volume Iso Positive Test Failed");
    }

    @Test
    public void testGetVolumeNegative() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(4,4,1), 20, new PointEntity(4,4,1));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateVolume(coneEntity);
        double expected = 0;
        Assert.assertEquals(actual, expected, "Volume Negative Test Failed");
    }

        @Test
    public void testCoordinateDivisionPositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(0,0,-2), 3, new PointEntity(0,0,2));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateCoordinateDivision(coneEntity);
        double expected = 8;
        Assert.assertEquals(actual, expected, "Coordinate Division Test Failed");
    }

    @Test
    public void testCoordinateDivisionNegative() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(0,0,-2), 3, new PointEntity(0,2,2));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateCoordinateDivision(coneEntity);
        double expected = 0;
        Assert.assertEquals(actual, expected, "Coordinate Division Test Failed");
    }

    @Test
    public void testCoordinateDivisionCordNegative() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(6,6,0), 5, new PointEntity(6,6,20));
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateCoordinateDivision(coneEntity);
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
    public void testCoordinateStateNegative() throws Exception {
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
    public void testIsConeRadiusNegative() throws Exception {
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

}