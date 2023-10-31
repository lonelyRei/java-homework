package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task2.countDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void testCountDigits1() {
        assertEquals(countDigits(4666), 4);
    }

    @Test
    public void testCountDigits2() {
        assertEquals(countDigits(566), 3);
    }

    @Test
    public void testCountDigits3() {
        assertEquals(countDigits(0), 1);
    }

    @Test
    public void testCountDigits4() {
        assertEquals(countDigits(100), 3);
    }
}
