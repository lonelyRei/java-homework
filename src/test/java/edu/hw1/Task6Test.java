package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task6.countK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    public void testCountK1() {
        assertEquals(countK(3524), 3);
    }

    @Test
    public void testCountK2() {
        assertEquals(countK(6621), 5);
    }

    @Test
    public void testCountK3() {
        assertEquals(countK(6554), 4);
    }

    @Test
    public void testCountK4() {
        assertEquals(countK(1234), 3);
    }
}
