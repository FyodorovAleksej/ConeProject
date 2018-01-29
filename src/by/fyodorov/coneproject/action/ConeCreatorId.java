package by.fyodorov.coneproject.action;

/**
 * class for generating id for ConeEntity
 */
public class ConeCreatorId {
    private static long last = 0;

    /**
     * generate unique id for ConeEntity
     * @return unique id
     */
    public static long getId() {
        return last++;
    }
}
