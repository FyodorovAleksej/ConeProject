package by.fyodorov.coneproject.processing;

import by.fyodorov.coneproject.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ConeReader {
    private static final Logger LOGGER = LogManager.getLogger(ConeReader.class);

    public String[] readAllCone(String path) throws ConeException {
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get(path));
            LOGGER.info("file \"" + path + "\" was opened");
            return stream.toArray(String[]::new);
        } catch (IOException e) {
            throw new ConeException("file can't read");
        }
        finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}
