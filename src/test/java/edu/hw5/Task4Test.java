package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task4.validatePassword;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    @Test
    public void testThatValidatePasswordReturnsFalseWithNull() {
        assertFalse(validatePassword(null));
    }

    @Test
    public void assertThatIsPasswordValidReturnedRightAnswer() {
        assertTrue(validatePassword("ContainsOne@"));
        assertFalse(validatePassword("@Contains!@!Many@"));
        assertFalse(validatePassword("Without"));
    }
}
