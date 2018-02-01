package by.fyodorov.coneproject.action;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class ConeCreator {
    private static final Logger LOGGER = LogManager.getLogger(ConeCreator.class);

    /**
     * creating all Cones with params from file
     * @param path path of input file
     * @return list of all Cones from file
     */
    public LinkedList<ConeEntity> createAll(String path) {
        ConeReader reader = new ConeReader();
        try {
            String[] strings = reader.readAllCones(path);
            LinkedList<ConeEntity> coneList = new LinkedList<ConeEntity>();
            for (String string : strings) {
                ConeEntity cone = create(string);
                if (cone != null) {
                    coneList.add(cone);
                }
            }
            return coneList;
        } catch (ConeException e) {
            LOGGER.fatal("Can't read file", e);
            return new LinkedList<ConeEntity>();
        }
    }

    /**
     * creating new Cone with params from string
     * @param str string wit params for creating Cone
     * @return new Cone with params from string
     */
    private ConeEntity create(String str) {
        ConeParser parser = new ConeParser();
        double[] doubles = parser.parse(str);
        if (doubles == null) {
            return null;
        }
        else {
            return new ConeEntity(new PointEntity(doubles[0], doubles[1], doubles[2]), doubles[3], new PointEntity(doubles[4], doubles[5], doubles[6]));
        }
    }
}
