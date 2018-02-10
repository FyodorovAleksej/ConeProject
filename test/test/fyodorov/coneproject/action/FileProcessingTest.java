package test.fyodorov.coneproject.action;

import by.fyodorov.coneproject.action.ConeCreator;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.validator.ConeValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.fyodorov.coneproject.help.TestHelper;

import java.util.LinkedList;

public class FileProcessingTest {


    @DataProvider(name = "ValidatorProvider")
    public static Object[][] getCoordinateStateTestInput() throws Exception {
        final String ACTUAL_PATH = "./input/Validate/actual.txt";
        final String EXPECTED_PATH = "./input/Validate/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.stringBool(ACTUAL_PATH, EXPECTED_PATH);
    }


    @Test
    public void testCreateAll() {
        ConeCreator fileProcessing = new ConeCreator();
        LinkedList<ConeEntity> linkedList = fileProcessing.createAll("./input/input.txt");
        Assert.assertNotEquals(linkedList.size(), 0);
    }

    @Test
    public void testCreateAllNegative() {
        ConeCreator fileProcessing = new ConeCreator();
        Assert.assertEquals(fileProcessing.createAll("./input/null.txt").size(), 0);
    }

    @Test(dataProvider = "ValidatorProvider")
    public void testValidateAll(String string, Boolean expected) {
        ConeValidator validator = new ConeValidator();
        Assert.assertEquals(validator.validate(string), expected.booleanValue(), "Validate All Failed: \"" + string + "\"");
    }
}


