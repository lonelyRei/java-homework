package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task7.rotateLeft;
import static edu.hw1.Task7.rotateRight;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    public void testRotate() {
        assertEquals(rotateRight(8, 1), 4);
    }

    @Test
    public void testRotate2() {
        assertEquals(rotateLeft(16, 1), 1);
    }

    @Test
    public void testRotate3() {
        assertEquals(rotateLeft(17, 2), 6);
    }
}
