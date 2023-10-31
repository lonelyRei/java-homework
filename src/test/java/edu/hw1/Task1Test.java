package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task1.minutesToSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void testMinutesToSeconds1() {
        assertEquals(minutesToSeconds("01:00"), 60);
    }

    @Test
    public void testMinutesToSeconds2() {
        assertEquals(minutesToSeconds("13:56"), 836);
    }

    @Test
    public void testMinutesToSeconds3() {
        assertEquals(minutesToSeconds("10:60"), -1);
    }

    @Test
    public void testMinutesToSeconds4() {
        assertEquals(minutesToSeconds("10:-1"), -1);
    }

    @Test
    public void testMinutesToSeconds5() {
        assertEquals(minutesToSeconds("abc:-1"), -1);
    }
}
