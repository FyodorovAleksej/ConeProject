package by.fyodorov.coneproject.action;

import by.fyodorov.coneproject.validator.ConeValidator;

import java.util.Arrays;
import java.util.stream.DoubleStream;

/**
 * parser of string to doubles
 */
public class ConeParser {
    private static final String SEPARATOR_EXPRESSION = "[,;]";
    private static final String REDUCE_SYMBOLS = "[()]";

    /**
     * parsing input string. Checked string by validator
     * @param str input string for parsing
     * @return - array of doubles - if input string was valid
     *         - null - if input string wasn't valid
     */
    public double[] parse(String str) {
        ConeValidator validator = new ConeValidator();
        if (validator.validate(str)) {
            str = str.replaceAll(REDUCE_SYMBOLS, "");
            return Arrays.stream(str.split(SEPARATOR_EXPRESSION)).flatMapToDouble((s) -> DoubleStream.of(Double.parseDouble(s))).toArray();
        }
        else {
            return null;
        }
    }
}
