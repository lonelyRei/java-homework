package edu.hw1;

import static edu.hw1.Constants.ONE_MINUTE_IN_SECONDS;

public class Task1 {
    private static final int COUNT_OF_PART_IN_TIME = 2;

    private Task1() {
    }

    public static int minutesToSeconds(String str) {
        String[] splitedStr = str.split(":");

        if (splitedStr.length == COUNT_OF_PART_IN_TIME && validateTime(splitedStr[0]) && validateTime(splitedStr[1])) {
            int minutes = getTime(splitedStr[0]);
            int seconds = getTime(splitedStr[1]);

            return (seconds < ONE_MINUTE_IN_SECONDS && seconds > -1) ? seconds + minutes * ONE_MINUTE_IN_SECONDS : -1;
        } else {
            return -1;
        }
    }

    private static int getTime(String timeStr) {
        return Integer.parseInt(timeStr);
    }

    private static boolean validateTime(String timeStr) {
        return timeStr.matches("[-+]?\\d+");
    }
}
