package by.fyodorov.coneproject.register;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;

import java.util.HashMap;
import java.util.Map;

public class PerimeterRegister {
    Map<Integer, Double> perimeterMap = new HashMap<Integer, Double>();
    static int last = 0;

    public PerimeterRegister() {
    }

    public void add(ConeEntity cone) {
        ConeProcessing processing = new ConeProcessing();
        try {
            last++;
            perimeterMap.put(last, processing.getPerimeter(cone));
        }
        catch (ConeException e) {

        }
    }
}
