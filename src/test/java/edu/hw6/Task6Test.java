package edu.hw6;

import org.junit.jupiter.api.Test;

import static edu.hw6.Task6.isPortAvailable;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test public void testPortAvailability() {
        assertTrue(isPortAvailable(3145));
    }
}
