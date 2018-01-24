package by.fyodorov.coneproject.observe;

import by.fyodorov.coneproject.exception.ConeException;

public class VolumeListener implements ConeListener {
    private static volatile VolumeListener instance;

    private VolumeListener() throws ConeException {
        if (instance != null) {
            throw new ConeException("singleTone create");
        }
    }

    public static VolumeListener getInstance() throws ConeException {
        if (instance == null) {
            synchronized (VolumeListener.class) {
                if (instance == null) {
                    instance = new VolumeListener();
                }
            }
        }
        return instance;
    }

    @Override
    public void update() {
        System.out.println("Volume changed");
    }
}
