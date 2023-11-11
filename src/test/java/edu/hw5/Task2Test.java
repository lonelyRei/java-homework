package edu.hw5;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static edu.hw5.Task2.findFridayTheThirteenths;
import static edu.hw5.Task2.findNextFriday13;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void testFindFridayTheThirteenthsWith1925Year() {
        List<LocalDate> actual = findFridayTheThirteenths(1925);
        List<LocalDate> expected = List.of(new LocalDate[] {
            LocalDate.of(1925, 2, 13),
            LocalDate.of(1925, 3, 13),
            LocalDate.of(1925, 11, 13),
        });

        assertEquals(expected, actual);
    }

    @Test
    public void testFindFridayTheThirteenthsWith2024Year() {
        List<LocalDate> actual = findFridayTheThirteenths(2024);
        List<LocalDate> expected = List.of(new LocalDate[] {
            LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13),
        });

        assertEquals(expected, actual);
    }

    @Test
    public void testFindNextFriday13With1925Year() {
        LocalDate actual = findNextFriday13(LocalDate.of(1925, 3, 10));
        LocalDate expected = LocalDate.of(1925, 3, 13);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindNextFriday13With2024Year() {
        LocalDate actual = findNextFriday13(LocalDate.of(2024, 9, 10));
        LocalDate expected = LocalDate.of(2024, 9, 13);
        assertEquals(expected, actual);
    }
}
