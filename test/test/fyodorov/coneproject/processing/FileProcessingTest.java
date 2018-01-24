package test.fyodorov.coneproject.processing;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.processing.ConeCreator;
import by.fyodorov.coneproject.validator.ConeValidator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.fyodorov.coneproject.help.TestHelper;

import java.util.ArrayList;
import java.util.LinkedList;

public class FileProcessingTest {

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @DataProvider(name = "ValidatorProvider")
    public static Object[][] getCoordStateTestInput() throws Exception {
        String actualPath = "./input/Validate/actual.txt";
        String expectedPath = "./input/Validate/expected.txt";
        TestHelper helper = new TestHelper();
        return helper.stringBool(actualPath, expectedPath);
    }


    @Test
    public void createAllTest() throws Exception {
        ConeCreator fileProcessing = new ConeCreator();
        LinkedList<ConeEntity> linkedList = fileProcessing.createAll("./input/input.txt");
        Assert.assertNotEquals(linkedList.size(), 0);
    }

    @Test
    public void testCreateAllNegative() throws Exception {
        ConeCreator fileProcessing = new ConeCreator();
        Assert.assertEquals(fileProcessing.createAll("./input/null.txt").size(), 0);
    }

    @Test(dataProvider = "ValidatorProvider")
    public void testValidateAll(String string, Boolean expected) {
        ConeValidator validator = new ConeValidator();
        Assert.assertEquals(validator.validate(string), expected.booleanValue(), "Validate All Failed: \"" + string + "\"");
    }
}


