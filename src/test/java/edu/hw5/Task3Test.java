package edu.hw5;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static edu.hw5.task3.Task3.parseDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    public void testParseDateWithUnsupportedFormats() {
        assertEquals(Optional.empty(), parseDate("tommmmmorow"));
        assertEquals(Optional.empty(), parseDate("test"));
        assertEquals(Optional.empty(), parseDate(""));
        assertEquals(Optional.empty(), parseDate("please give me date"));
        assertEquals(Optional.empty(), parseDate(null));
    }

    @Test
    public void testParseDateWithFormatValues() {
        assertEquals(Optional.of(LocalDate.of(2023, 11, 11)), parseDate("2023-11-11"));
        assertEquals(Optional.of(LocalDate.of(2002, 4, 20)), parseDate("2002-4-20"));
        assertEquals(Optional.of(LocalDate.of(2020, 1, 3)), parseDate("1/3/20"));
    }

    @Test
    public void testParseDateWithWordValues() {
        assertEquals(Optional.of(LocalDate.now()), parseDate("today"));
        assertEquals(Optional.of(LocalDate.now().plusDays(1)), parseDate("tomorrow"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), parseDate("yesterday"));
    }

    @Test
    public void testParseDateWithIntervals() {
        assertEquals(Optional.of(LocalDate.now().minusDays(5)), parseDate("5 days ago"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), parseDate("1 day ago"));

        assertEquals(Optional.of(LocalDate.now().plusDays(1)), parseDate("1 day after"));
        assertEquals(Optional.of(LocalDate.now().plusDays(5)), parseDate("5 days after"));
    }
}
