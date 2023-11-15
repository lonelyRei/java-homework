package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.isAtLeast3SymbolsAndThirdIsZero;
import static edu.hw5.Task7.isLengthMoreOrEqualsOneAndLessOrEqualsThree;
import static edu.hw5.Task7.isStartAndEndWithSameCharacter;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    public void testIsAtLeast3SymbolsAndThirdIsZero() {
        assertTrue(isAtLeast3SymbolsAndThirdIsZero("100"));
        assertTrue(isAtLeast3SymbolsAndThirdIsZero("110"));
        assertFalse(isAtLeast3SymbolsAndThirdIsZero("FF00"));
        assertFalse(isAtLeast3SymbolsAndThirdIsZero("F0"));
        assertFalse(isAtLeast3SymbolsAndThirdIsZero("0"));
        assertFalse(isAtLeast3SymbolsAndThirdIsZero("0010"));
    }

    @Test
    public void testIsStartAndEndWithSameCharacter() {
        assertTrue(isStartAndEndWithSameCharacter("101"));
        assertTrue(isStartAndEndWithSameCharacter("11"));
        assertFalse(isAtLeast3SymbolsAndThirdIsZero("0FF0"));
        assertFalse(isAtLeast3SymbolsAndThirdIsZero("01"));
        assertFalse(isAtLeast3SymbolsAndThirdIsZero(""));
    }

    @Test
    public void testIsLengthMoreOrEqualsOneAndLessOrEqualsThree() {
        assertTrue(isLengthMoreOrEqualsOneAndLessOrEqualsThree("101"));
        assertTrue(isLengthMoreOrEqualsOneAndLessOrEqualsThree("10"));
        assertTrue(isLengthMoreOrEqualsOneAndLessOrEqualsThree("1"));

        assertFalse(isLengthMoreOrEqualsOneAndLessOrEqualsThree(""));
        assertFalse(isLengthMoreOrEqualsOneAndLessOrEqualsThree("111111"));
    }
}
