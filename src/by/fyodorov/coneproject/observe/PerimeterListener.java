package by.fyodorov.coneproject.observe;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerimeterListener implements ConeListener {
    private static final Logger LOGGER = LogManager.getLogger(ConeListener.class);
    private static volatile PerimeterListener instance;

    private PerimeterListener() throws ConeException {
        if (instance != null) {
            throw new ConeException("singleTone create");
        }
    }

    public static PerimeterListener getInstance() throws ConeException {
        if (instance == null) {
            synchronized (PerimeterListener.class) {
                if (instance == null) {
                    instance = new PerimeterListener();
                }
            }
        }
        return instance;
    }

    @Override
    public void update() {
        System.out.println("Perimeter changed");
    }
}
