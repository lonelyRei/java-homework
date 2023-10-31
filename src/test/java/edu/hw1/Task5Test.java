package edu.hw1;

import org.junit.jupiter.api.Test;

import static edu.hw1.Task5.isPalindromeDescendant;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    public void testIsPalindromeDescendant1() {
        assertTrue(isPalindromeDescendant(11211230));
    }

    @Test
    public void testIsPalindromeDescendant2() {
        assertTrue(isPalindromeDescendant(13001120));
    }

    @Test
    public void testIsPalindromeDescendant3() {
        assertTrue(isPalindromeDescendant(23336014));
    }

    @Test
    public void testIsPalindromeDescendant4() {
        assertTrue(isPalindromeDescendant(761));
    }

    @Test
    public void testIsPalindromeDescendant5() {
        assertFalse(isPalindromeDescendant(16));
    }

    @Test
    public void testIsPalindromeDescendant6() {
        assertTrue(isPalindromeDescendant(224));
    }
}
