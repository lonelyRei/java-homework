package edu.hw1;

import java.util.Arrays;
import java.util.OptionalInt;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        return getLimitOfArray(a1, false) < getLimitOfArray(a2, false)
            && getLimitOfArray(a1, true) > getLimitOfArray(a2, true);
    }

    private static int getLimitOfArray(int[] arr, boolean min) {
        OptionalInt valueToCheck = min ? Arrays.stream(arr).min() : Arrays.stream(arr).max();
        return valueToCheck.isPresent() ? valueToCheck.getAsInt() : 0;
    }
}
