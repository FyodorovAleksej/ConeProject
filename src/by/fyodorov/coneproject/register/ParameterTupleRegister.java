package by.fyodorov.coneproject.register;

import by.fyodorov.coneproject.action.ConeProcessing;
import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * class of register for all Cone's params. Singleton
 */
public class ParameterTupleRegister implements ConeRegister {
    private static final Logger LOGGER = LogManager.getLogger(ParameterTupleRegister.class);

    private Map<Long, ConeParameterTuple> map = new HashMap<Long, ConeParameterTuple>();
    private static volatile ParameterTupleRegister instance;

    private ParameterTupleRegister() {
    }

    public static ParameterTupleRegister getInstance() {
        if (instance == null) {
            synchronized (ParameterTupleRegister.class) {
                if (instance == null) {
                    instance = new ParameterTupleRegister();
                }
            }
        }
        return instance;
    }

    /**
     * getting params form register by id
     * @param id id from register
     * @return params of cone with input id from register
     */
    public ConeParameterTuple findParams(long id) {
        return map.get(id);
    }

    /**
     * adding cone's params in register
     * @param cone cone for getting params
     */
    public void add(ConeEntity cone) {
        if (!map.containsKey(cone.getConeId())) {
            LOGGER.info("adding cone in register \"" + cone + "\"");
            ConeProcessing processing = new ConeProcessing();
            try {
                map.put(cone.getConeId(), new ConeParameterTuple(processing.calculatePerimeter(cone), processing.calculateSquare(cone), processing.calculateVolume(cone)));
            }
            catch (ConeException e) {
                LOGGER.error("NullPoint", e);
            }
        }
    }

    /**
     * removing cone's params from register
     * @param cone cone for removing
     */
    public void remove(ConeEntity cone) {
        if (map.containsKey(cone.getConeId())) {
            LOGGER.info("remove cone from register \"" + cone + "\"");
            map.remove(cone.getConeId());
        }
    }


    /**
     * updating params of cone in register
     * @param cone cone for updating
     */
    @Override
    public void update(ConeEntity cone) {
        if (map.containsKey(cone.getConeId())) {
            LOGGER.info("update slot");
            ConeParameterTuple params = map.get(cone.getConeId());
            ConeProcessing processing = new ConeProcessing();
            try {
                params.setPerimeter(processing.calculatePerimeter(cone));
                params.setSquare(processing.calculateSquare(cone));
                params.setVolume(processing.calculateVolume(cone));
            }
            catch (ConeException e) {
                LOGGER.error("NullPoint", e);
            }
        }
    }

    public LinkedList<ConeParameterTuple> findAll() {
        LinkedList<ConeParameterTuple> list = new LinkedList<ConeParameterTuple>();
        for (HashMap.Entry<Long, ConeParameterTuple> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
