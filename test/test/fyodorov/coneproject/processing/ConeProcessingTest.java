package test.fyodorov.coneproject.processing;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.processing.ConeProcessing;
import by.fyodorov.coneproject.validator.ConeValidator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ConeProcessingTest {

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    private static Object[][] coneDouble(String actualPath, String expectedPath) throws Exception {
        ConeValidator validator = new ConeValidator();
        ArrayList<ConeEntity> coneList = validator.createAll(actualPath);
        Double[] expectedValues = Files.lines(Paths.get(expectedPath)).map(Double::parseDouble).toArray(Double[]::new);
        ConeEntity[] actualValues = new ConeEntity[expectedValues.length];
        coneList.toArray(actualValues);
        Object[][] result = new Object[actualValues.length][2];
        for (int i = 0; i < actualValues.length; i++) {
            result[i][0] = actualValues[i];
            result[i][1] = expectedValues[i];
        }
        return result;
    }

    private static Object[][] coneBool(String actualPath, String expectedPath) throws Exception {
        ConeValidator validator = new ConeValidator();
        ArrayList<ConeEntity> coneList = validator.createAll(actualPath);
        Boolean[] expectedValues = Files.lines(Paths.get(expectedPath)).map(Boolean::parseBoolean).toArray(Boolean[]::new);
        ConeEntity[] actualValues = new ConeEntity[expectedValues.length];
        coneList.toArray(actualValues);
        Object[][] result = new Object[actualValues.length][2];
        for (int i = 0; i < actualValues.length; i++) {
            result[i][0] = actualValues[i];
            result[i][1] = expectedValues[i];
        }
        return result;
    }


    @DataProvider(name = "CoordDivisionProvider")
    public static Object[][] getCoordDivisionTestInput() throws Exception {
        String actualPath = "./input/CoordDivision/actual.txt";
        String expectedPath = "./input/CoordDivision/expected.txt";
        return coneDouble(actualPath, expectedPath);
    }

    @DataProvider(name = "CoordStateProvider")
    public static Object[][] getCoordStateTestInput() throws Exception {
        String actualPath = "./input/CoordState/actual.txt";
        String expectedPath = "./input/CoordState/expected.txt";
        return coneBool(actualPath, expectedPath);
    }

    @DataProvider(name = "IsConeProvider")
    public static Object[][] getIsConeTestInput() throws Exception {
        String actualPath = "./input/IsCone/actual.txt";
        String expectedPath = "./input/IsCone/expected.txt";
        return coneBool(actualPath, expectedPath);
    }

    @DataProvider(name = "SquareProvider")
    public static Object[][] getSquareTestInput() throws Exception {
        String actualPath = "./input/Square/actual.txt";
        String expectedPath = "./input/Square/expected.txt";
        return coneDouble(actualPath, expectedPath);
    }

    @DataProvider(name = "VolumeProvider")
    public static Object[][] getVolumeTestInput() throws Exception {
        String actualPath = "./input/Volume/actual.txt";
        String expectedPath = "./input/Volume/expected.txt";
        return coneDouble(actualPath, expectedPath);
    }





    @Test
    public void testGetSquareBasePositive() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(1,0,0), 3, new PointEntity(5,0,0));
        ConeProcessing processing = new ConeProcessing();
        double expected = 75.39816;
        double actual = processing.getSquare(coneEntity);
        double delta = 0.001;
        Assert.assertEquals(actual, expected, delta, "Base Square Test Failed");
    }

    @Test
    public void testGetSquareIsoPositive() throws Exception {
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
    public void testGetVolumeBase() throws Exception {
        ConeEntity coneEntity = new ConeEntity(new PointEntity(2,2,5), 4, new PointEntity(2,-5,5));
        ConeProcessing processing = new ConeProcessing();
        double expected = 117.28602;
        double actual = processing.getVolume(coneEntity);
        double delta = 0.001;
        Assert.assertEquals(actual, expected, delta, "Get Volume Base Failed");
    }


    //FILE
    @Test(dataProvider = "CoordDivisionProvider")
    public void testCoordDivisionAll(ConeEntity coneEntity, double expected) {
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.coordinateDivision(coneEntity);
        Assert.assertEquals(actual, expected, "All Coord Division Test Failed");
    }

    @Test(dataProvider = "CoordStateProvider")
    public void testCoordStateAll(ConeEntity coneEntity, boolean expected) {
        ConeProcessing processing = new ConeProcessing();
        boolean actual = processing.coordinateState(coneEntity);
        Assert.assertTrue(actual == expected, "All Coord State Test Failed");
    }

    @Test(dataProvider = "IsConeProvider")
    public void testIsConeAll(ConeEntity coneEntity, boolean expected) {
        ConeProcessing processing = new ConeProcessing();
        boolean actual = processing.isCone(coneEntity);
        Assert.assertTrue(actual == expected, "All Is Cone Test Failed");
    }

    @Test(dataProvider = "SquareProvider")
    public void testSquareAll(ConeEntity coneEntity, double expected) {
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.getSquare(coneEntity);
        double delta = 0.01;
        Assert.assertEquals(actual, expected, delta, "All Square Test Failed");
    }

    // FILE
    @Test(dataProvider = "VolumeProvider")
    public void testVolumeAll(ConeEntity coneEntity, double expected) {
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.getVolume(coneEntity);
        Assert.assertEquals(actual, expected, "All Volume Test Failed");
    }
}