package edu.hw5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw5.Task1.calculateAverageSessionTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void testCalculateAverageSessionTime() {
        List<String> input = List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20");

        String actual = calculateAverageSessionTime(input);

        String expected = "3ч 40м";

        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateAverageSessionTimeWithOneValue() {
        List<String> input = List.of("2022-03-12, 20:20 - 2022-03-12, 23:50");

        String actual = calculateAverageSessionTime(input);

        String expected = "3ч 30м";

        assertEquals(expected, actual);
    }
}
