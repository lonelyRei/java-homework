package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task5.validateRusCarNumber;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    public void testValidateRusCarNumberWithCorrectNumbers() {
        assertTrue(validateRusCarNumber("А123ВЕ777"));
        assertTrue(validateRusCarNumber("О777ОО177"));
    }

    @Test
    public void testValidateRusCarNumberWithIncorrectNumbers() {
        assertFalse(validateRusCarNumber("123АВЕ777"));
        assertFalse(validateRusCarNumber("А123ВГ77"));
        assertFalse(validateRusCarNumber("А123ВЕ7777"));
    }

    @Test
    public void testValidateRusCarNumberWithNull() {
        assertFalse(validateRusCarNumber(null));
    }
}
