package edu.hw2.Task3;

public class Utils {
    private Utils() {
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isConnectionUnstable() {
        int randomValue = 5;
        int rangePositionStart = 0;
        return (int) (Math.random() * ++randomValue) == rangePositionStart;
    }
}
