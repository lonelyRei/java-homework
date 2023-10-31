package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task4.convertToRoman;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    public void testConvertToRomanWithSimpleNumber() {
        String expected = "II";

        String actual = convertToRoman(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToRomanWithTwelve() {
        String expected = "XII";

        String actual = convertToRoman(12);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToRomanWithSixteen() {
        String expected = "XVI";

        String actual = convertToRoman(16);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToRomanWithOneHundred() {
        String expected = "C";

        String actual = convertToRoman(100);
        assertEquals(expected, actual);
    }
}
