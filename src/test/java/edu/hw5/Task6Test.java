package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.isSubsequence;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    public void testIsSubsequenceWithCorrectValue() {
        String s = "abc";
        String t = "achfdbaabgabcaabg";

        assertTrue(isSubsequence(s, t));
    }

    @Test
    public void testIsSubsequenceWithIncorrectValue() {
        String s = "abc";
        String t = "achfdbaabgacaabg";

        assertFalse(isSubsequence(s, t));
    }
}
