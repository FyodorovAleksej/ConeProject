package by.fyodorov.coneproject.action;

public class ConeCreatorId {
    private static long last = 0;

    public static long getId() {
        return last++;
    }
}
