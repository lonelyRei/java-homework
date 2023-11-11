package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task8.areNumbersOnOddPositionsEqualOne;
import static edu.hw5.Task8.areThereNoRepeatingOnes;
import static edu.hw5.Task8.isEvenOrOddLength;
import static edu.hw5.Task8.isOddLength;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    public void testIsOddLength() {
        assertTrue(isOddLength("111"));
        assertTrue(isOddLength("11100"));
        assertTrue(isOddLength("1"));

        assertFalse(isOddLength("1FF"));
        assertFalse(isOddLength("1001"));
        assertFalse(isOddLength("101010"));
        assertFalse(isOddLength(""));
    }

    @Test
    public void testIsEvenOrOddLength() {
        assertTrue(isEvenOrOddLength("1010"));
        assertTrue(isEvenOrOddLength("01101"));

        assertFalse(isEvenOrOddLength("101"));
        assertFalse(isEvenOrOddLength("0110"));
        assertFalse(isEvenOrOddLength("0F1"));
        assertFalse(isEvenOrOddLength("1F01"));
        assertFalse(isEvenOrOddLength(""));
    }

    @Test
    public void testAreNumbersOnOddPositionsEqualOne() {
        assertTrue(areNumbersOnOddPositionsEqualOne("10101"));
        assertTrue(areNumbersOnOddPositionsEqualOne("101"));
        assertTrue(areNumbersOnOddPositionsEqualOne("10101"));
        assertTrue(areNumbersOnOddPositionsEqualOne("10"));

        assertFalse(areNumbersOnOddPositionsEqualOne(""));
        assertFalse(areNumbersOnOddPositionsEqualOne("010"));
        assertFalse(areNumbersOnOddPositionsEqualOne("110100"));
        assertFalse(areNumbersOnOddPositionsEqualOne("11010F"));
        assertFalse(areNumbersOnOddPositionsEqualOne("1F"));
    }

    @Test
    public void testAreThereNoRepeatingOnes() {
        assertTrue(areThereNoRepeatingOnes("10101"));
        assertTrue(areThereNoRepeatingOnes("00000"));
        assertTrue(areThereNoRepeatingOnes("00100"));

        assertFalse(areThereNoRepeatingOnes("11"));
        assertFalse(areThereNoRepeatingOnes("01100"));
        assertFalse(areThereNoRepeatingOnes("01A00"));
    }
}
