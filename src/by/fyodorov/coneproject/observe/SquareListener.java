package by.fyodorov.coneproject.observe;

import by.fyodorov.coneproject.exception.ConeException;

public class SquareListener implements ConeListener {
    private static volatile SquareListener instance;

    private SquareListener() throws ConeException {
        if (instance != null) {
            throw new ConeException("singleTone create");
        }
    }

    public static SquareListener getInstance() throws ConeException {
        if (instance == null) {
            synchronized (SquareListener.class) {
                if (instance == null) {
                    instance = new SquareListener();
                }
            }
        }
        return instance;
    }

    @Override
    public void update() {
        System.out.println("Square changed");
    }
}
