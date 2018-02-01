package test.fyodorov.coneproject.action;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.action.ConeProcessing;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.fyodorov.coneproject.help.TestHelper;

public class ConeAutoTest {
    private final static double DELTA = 0.001;

    @DataProvider(name = "CoordDivisionProvider")
    public static Object[][] getCoordDivisionTestInput() throws Exception {
        String actualPath = "./input/CoordDivision/actual.txt";
        String expectedPath = "./input/CoordDivision/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneDouble(actualPath, expectedPath);
    }

    @DataProvider(name = "CoordStateProvider")
    public static Object[][] getCoordStateTestInput() throws Exception {
        String actualPath = "./input/CoordState/actual.txt";
        String expectedPath = "./input/CoordState/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneBool(actualPath, expectedPath);
    }

    @DataProvider(name = "IsConeProvider")
    public static Object[][] getIsConeTestInput() throws Exception {
        String actualPath = "./input/IsCone/actual.txt";
        String expectedPath = "./input/IsCone/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneBool(actualPath, expectedPath);
    }

    @DataProvider(name = "SquareProvider")
    public static Object[][] getSquareTestInput() throws Exception {
        String actualPath = "./input/Square/actual.txt";
        String expectedPath = "./input/Square/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneDouble(actualPath, expectedPath);
    }

    @DataProvider(name = "VolumeProvider")
    public static Object[][] getVolumeTestInput() throws Exception {
        String actualPath = "./input/Volume/actual.txt";
        String expectedPath = "./input/Volume/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneDouble(actualPath, expectedPath);
    }


    @Test(dataProvider = "CoordDivisionProvider")
    public void testCoordDivisionAll(ConeEntity coneEntity, double expected) throws Exception {
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateCoordinateDivision(coneEntity);
        Assert.assertEquals(actual, expected, DELTA, "All Coord Division Test Failed");
    }

    @Test(dataProvider = "CoordStateProvider")
    public void testCoordStateAll(ConeEntity coneEntity, boolean expected) throws Exception {
        ConeProcessing processing = new ConeProcessing();
        boolean actual = processing.coordinateState(coneEntity);
        Assert.assertTrue(actual == expected, "All Coord State Test Failed");
    }

    @Test(dataProvider = "IsConeProvider")
    public void testIsConeAll(ConeEntity coneEntity, boolean expected) throws Exception {
        ConeProcessing processing = new ConeProcessing();
        boolean actual = processing.isCone(coneEntity);
        Assert.assertTrue(actual == expected, "All Is Cone Test Failed");
    }

    @Test(dataProvider = "SquareProvider")
    public void testSquareAll(ConeEntity coneEntity, double expected) throws Exception {
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateSquare(coneEntity);
        Assert.assertEquals(actual, expected, DELTA, "All Square Test Failed");
    }

    @Test(dataProvider = "VolumeProvider")
    public void testVolumeAll(ConeEntity coneEntity, double expected) throws Exception {
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateVolume(coneEntity);
        Assert.assertEquals(actual, expected, DELTA, "All Volume Test Failed");
    }


}
