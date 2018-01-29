package by.fyodorov.coneproject.exception;

/**
 * Exception class for Cone
 */
public class ConeException extends Exception {

    /**
     * creating cone exception with specific message
     * @param message message for exception
     */
    public ConeException(String message) {
        super(message);
    }

    /**
     * creating cone exception with previous exception
     * @param message message of exception
     * @param e previous exception
     */
    public ConeException(String message, Exception e) {
        super(message, e);
    }
}
