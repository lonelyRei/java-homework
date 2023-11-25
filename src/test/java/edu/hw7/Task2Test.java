package edu.hw7;

import org.junit.Test;
import static edu.hw7.Task2.calculateFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void testFactorial() {
        assertEquals(1, calculateFactorial(0));
        assertEquals(1, calculateFactorial(1));
        assertEquals(120, calculateFactorial(5));
        assertEquals(3628800, calculateFactorial(10));
    }
}
