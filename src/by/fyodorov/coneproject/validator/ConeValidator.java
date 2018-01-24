package by.fyodorov.coneproject.validator;

import by.fyodorov.coneproject.entity.ConeEntity;
import by.fyodorov.coneproject.entity.PointEntity;
import by.fyodorov.coneproject.exception.ConeException;
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
    private static final String POINT_EXPRESSION = "\\(-?\\d+\\.\\d+,\\s?-?\\d+\\.\\d+,\\s?-?\\d+\\.\\d+\\)";
    private static final String CONE_EXPRESSION = "^" + POINT_EXPRESSION + "[,;]\\s?-?\\d+\\.\\d+[,;]\\s?" + POINT_EXPRESSION + "$";

    /**
     * validating string with regular expression
     * @param string input string from file
     * @return is string was correct
     */
    public boolean validate(String string) {
        return string != null && string.matches(CONE_EXPRESSION);
    }
}

