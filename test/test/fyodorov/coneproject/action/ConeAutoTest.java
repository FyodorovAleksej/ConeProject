package test.fyodorov.coneproject.action;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.action.ConeProcessing;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.fyodorov.coneproject.help.TestHelper;

public class ConeAutoTest {
    private final static double DELTA = 0.001;

    @DataProvider(name = "CoordinateDivisionProvider")
    public static Object[][] getCoordinateDivisionTestInput() throws Exception {
        final String ACTUAL_PATH = "./input/CoordDivision/actual.txt";
        final String EXPECTED_PATH = "./input/CoordDivision/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneDouble(ACTUAL_PATH, EXPECTED_PATH);
    }

    @DataProvider(name = "CoordinateStateProvider")
    public static Object[][] getCoordinateStateTestInput() throws Exception {
        final String ACTUAL_PATH = "./input/CoordState/actual.txt";
        final String EXPECTED_PATH = "./input/CoordState/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneBool(ACTUAL_PATH, EXPECTED_PATH);
    }

    @DataProvider(name = "IsConeProvider")
    public static Object[][] getIsConeTestInput() throws Exception {
        final String ACTUAL_PATH = "./input/IsCone/actual.txt";
        final String EXPECTED_PATH = "./input/IsCone/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneBool(ACTUAL_PATH, EXPECTED_PATH);
    }

    @DataProvider(name = "SquareProvider")
    public static Object[][] getSquareTestInput() throws Exception {
        final String ACTUAL_PATH = "./input/Square/actual.txt";
        final String EXPECTED_PATH = "./input/Square/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneDouble(ACTUAL_PATH, EXPECTED_PATH);
    }

    @DataProvider(name = "VolumeProvider")
    public static Object[][] getVolumeTestInput() throws Exception {
        final String ACTUAL_PATH = "./input/Volume/actual.txt";
        final String EXPECTED_PATH = "./input/Volume/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.coneDouble(ACTUAL_PATH, EXPECTED_PATH);
    }



    @Test(dataProvider = "CoordinateDivisionProvider")
    public void testCoordinateDivisionAll(ConeEntity coneEntity, double expected) throws Exception {
        ConeProcessing processing = new ConeProcessing();
        double actual = processing.calculateCoordinateDivision(coneEntity);
        Assert.assertEquals(actual, expected, DELTA, "All Coord Division Test Failed");
    }

    @Test(dataProvider = "CoordinateStateProvider")
    public void testCoordinateStateAll(ConeEntity coneEntity, boolean expected) throws Exception {
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
