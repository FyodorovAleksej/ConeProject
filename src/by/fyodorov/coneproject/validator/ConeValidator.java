package by.fyodorov.coneproject.validator;

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

