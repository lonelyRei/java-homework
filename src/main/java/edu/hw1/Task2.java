package edu.hw1;

import static edu.hw1.Constants.DECIMAL_PLACES;

public class Task2 {
    private Task2() {
    }

    public static int countDigits(int value) {
        if (value < DECIMAL_PLACES) {
            return 1;
        }
        return 1 + countDigits(value / DECIMAL_PLACES);
    }
}
