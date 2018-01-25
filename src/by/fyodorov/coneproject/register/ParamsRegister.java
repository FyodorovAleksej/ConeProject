package by.fyodorov.coneproject.register;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ParamsRegister implements ConeRegister {
    private static final Logger LOGGER = LogManager.getLogger(ParamsRegister.class);

    private Map<Long, ConeParams> map = new HashMap<Long, ConeParams>();
    private static volatile ParamsRegister instance;

    private  ParamsRegister() {
    }

    public static ParamsRegister getInstance() {
        if (instance == null) {
            synchronized (ParamsRegister.class) {
                if (instance == null) {
                    instance = new ParamsRegister();
                }
            }
        }
        return instance;
    }

    public void add(ConeEntity cone) {
        if (!map.containsKey(cone.getConeId())) {
            LOGGER.info("adding cone in register \"" + cone + "\"");
            ConeProcessing processing = new ConeProcessing();
            try {
                map.put(cone.getConeId(), new ConeParams(processing.getPerimeter(cone), processing.getSquare(cone), processing.getVolume(cone)));
            }
            catch (ConeException e) {
                LOGGER.error("NullPoint", e);
            }
        }
    }

    public void remove(ConeEntity cone) {
        if (map.containsKey(cone.getConeId())) {
            LOGGER.info("remove cone from register \"" + cone + "\"");
            map.remove(cone.getConeId());
        }
    }

    public void update(ConeEvent event) {
        ConeEntity cone = event.getSource();
        if (map.containsKey(cone.getConeId())) {
            LOGGER.info("update slot");
            ConeParams params = map.get(cone.getConeId());
            ConeProcessing processing = new ConeProcessing();
            try {
                params.setPerimeter(processing.getPerimeter(cone));
                params.setSquare(processing.getSquare(cone));
                params.setVolume(processing.getVolume(cone));
            }
            catch (ConeException e) {
                LOGGER.error("NullPoint", e);
            }
        }
    }
}
