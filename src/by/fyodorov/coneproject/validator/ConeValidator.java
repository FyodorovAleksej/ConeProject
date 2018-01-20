package by.fyodorov.coneproject.validator;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.exception.ConeException;
import by.fyodorov.coneproject.processing.ConeProcessing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * class for validate file for working with cone
 */
public class ConeValidator {
    private static final Logger log = LogManager.getLogger(ConeValidator.class);

    private static final String POINTEXP = "\\(-?\\d+\\.\\d+, -?\\d+\\.\\d+, -?\\d+\\.\\d+\\)";
    private static final String CONEEXP = "^" + POINTEXP + ", \\d+\\.\\d+, " + POINTEXP + "$";

    /**
     * creating all Cones with params from file
     * @param path path of input file
     * @return list of all Cones from file
     * @throws ConeException if can't read file
     */
    public ArrayList<ConeEntity> createAll(String path) throws ConeException {
        Stream<String> stream = null;
        try {
            log.info("trying open file \"" + path + "\"");
            stream = Files.lines(Paths.get(path));
            log.info("file \"" + path + "\" was opened");
            String[] strings = stream.filter(this::validate).toArray(String[]::new);
            ArrayList<ConeEntity> arrayList = new ArrayList<>();
            for (String string : strings) {
                try {
                    arrayList.add(create(string));
                }
                catch (ConeException e) {
                    log.error(e.getMessage());
                }
            }
            return arrayList;
        } catch (IOException e) {
            throw new ConeException("can't read file: \"" + path + "\"");
        }
        finally {
            if (stream != null) {
                log.info("close stream");
                stream.close();
            }
        }
    }

    /**
     * creating new Cone with params from string
     * @param str string wit params for creating Cone
     * @return new Cone with params from string
     * @throws ConeException if params wasn't correct
     */
    private ConeEntity create(String str) throws ConeException {
        log.info("creating Cone: \"" + str + "\"");
        str = str.replaceAll("[()]","");
        double[] doubles = Arrays.stream(str.split(",")).flatMapToDouble((s)-> DoubleStream.of(Double.parseDouble(s))).toArray();
        ConeEntity cone = new ConeEntity(new PointEntity(doubles[0], doubles[1], doubles[2]), doubles[3], new PointEntity(doubles[4], doubles[5], doubles[6]));
        ConeProcessing processing = new ConeProcessing();
        if (!processing.isCone(cone)) {
            throw new ConeException("invalid cone: \"" + str + "\"");
        }
        return cone;
    }

    /**
     * validating string with regular expression
     * @param string input string from file
     * @return is string was correct
     */
    private boolean validate(String string) {
        return string.matches(CONEEXP);
    }
}

