package by.fyodorov.coneproject.action;

import by.fyodorov.coneproject.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * class for reading strings from file
 */
public class ConeReader {
    private static final Logger LOGGER = LogManager.getLogger(ConeReader.class);

    /**
     * reading all strings from file with input path
     * @param path path of the file for reading
     * @return array of strings from file
     * @throws ConeException if file wasn't readied
     */
    public String[] readAllCone(String path) throws ConeException {
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get(path));
            LOGGER.info("file \"" + path + "\" was opened");
            return stream.toArray(String[]::new);
        } catch (IOException e) {
            throw new ConeException("file \"" + path + "\" can't read");
        }
        finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}
