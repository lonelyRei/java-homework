package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private static final int COUNT_OF_MOUNTS_IN_YEAR = 12;
    private static final int THIRTEEN = 13;

    private Task2() {

    }

    public static List<LocalDate> findFridayTheThirteenths(int year) {
        List<LocalDate> fridayTheThirteenths = new ArrayList<>();

        for (int month = 1; month <= COUNT_OF_MOUNTS_IN_YEAR; month++) {
            LocalDate date = LocalDate.of(year, month, THIRTEEN);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridayTheThirteenths.add(date);
            }
        }

        return fridayTheThirteenths;
    }

    public static LocalDate findNextFriday13(LocalDate date) {
        return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))
            .with(TemporalAdjusters.next(DayOfWeek.FRIDAY))
            .withDayOfMonth(THIRTEEN);
    }
}
