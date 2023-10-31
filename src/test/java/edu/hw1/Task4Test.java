package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task4.fixString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    public void testFixString1() {
        assertEquals(fixString("123456"), "214365");
    }

    @Test
    public void testFixString2() {
        assertEquals(fixString("hTsii  s aimex dpus rtni.g"), "This is a mixed up string.");
    }

    @Test
    public void testFixString3() {
        assertEquals(fixString("badce"), "abcde");
    }
}
