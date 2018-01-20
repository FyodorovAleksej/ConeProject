package test.fyodorov.coneproject.processing;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.validator.ConeValidator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FileProcessingTest {

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void createAllTest() throws Exception {
        ConeValidator fileProcessing = new ConeValidator();
        ArrayList<ConeEntity> arrayList = fileProcessing.createAll("./input/input.txt");
        Assert.assertNotEquals(arrayList, null);
    }

    @Test(expectedExceptions = ConeException.class)
    public void testCreateAllNegative() throws Exception {
        ConeValidator fileProcessing = new ConeValidator();
        fileProcessing.createAll("./input/null.txt");
    }
}


