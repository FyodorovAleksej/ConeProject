package test.fyodorov.coneproject.help;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.processing.ConeCreator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class TestHelper {

    public Object[][] coneDouble(String actualPath, String expectedPath) throws Exception {
        ConeCreator creator = new ConeCreator();
        LinkedList<ConeEntity> coneList = creator.createAll(actualPath);
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

    public Object[][] coneBool(String actualPath, String expectedPath) throws Exception {
        ConeCreator creator = new ConeCreator();
        LinkedList<ConeEntity> coneList = creator.createAll(actualPath);
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

    public Object[][] stringBool(String actualPath, String expectedPath) throws Exception {
        String[] actualValues = Files.lines(Paths.get(actualPath)).toArray(String[]::new);
        Boolean[] expectedValues = Files.lines(Paths.get(expectedPath)).map(Boolean::parseBoolean).toArray(Boolean[]::new);
        Object[][] result = new Object[actualValues.length][2];
        for (int i = 0; i < actualValues.length; i++) {
            result[i][0] = actualValues[i];
            result[i][1] = expectedValues[i];
        }
        return result;
    }
}
