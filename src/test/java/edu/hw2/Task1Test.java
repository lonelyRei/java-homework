package edu.hw2;

import edu.hw2.Task1.Expr.Addition;
import edu.hw2.Task1.Expr.Constant;
import edu.hw2.Task1.Expr.Exponent;
import edu.hw2.Task1.Expr.Multiplication;
import edu.hw2.Task1.Expr.Negate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void testThatConstantEqualsValue() {
        assertEquals(new Constant(2).evaluate(), 2);
    }

    @Test
    void testThatNegateEqualsValue() {
        assertEquals(new Negate(new Constant(42)).evaluate(), -42);
    }

    @Test
    void testThatAdditionEqualsValue() {
        Constant fortyTwo = new Constant(42);
        assertEquals(new Addition(fortyTwo, new Negate(fortyTwo)).evaluate(), 0);
    }

    @Test
    void testThatMultiplicationEqualsValue() {
        Constant fortyTwo = new Constant(42);
        Negate minusTwo = new Negate(new Constant(-2));
        assertEquals(new Multiplication(fortyTwo, minusTwo).evaluate(), 84);
    }

    @Test
    void testThatMultiplicationEqualsZero() {
        Constant fortyTwo = new Constant(42);
        Negate zero = new Negate(new Constant(0));
        assertEquals(new Multiplication(fortyTwo, zero).evaluate(), 0);
    }

    @Test
    void testZeroPowerExponent() {
        Constant fortyTwo = new Constant(42);
        assertEquals(new Exponent(fortyTwo, 0).evaluate(), 1);
    }

    @Test
    void testNegativeExponent() {
        Constant two = new Constant(2);
        assertEquals(new Exponent(two, -2).evaluate(), 0.25);
    }

    @Test
    void testPositiveExponent() {
        Constant two = new Constant(2);
        assertEquals(new Exponent(two, 3).evaluate(), 8);
    }
}
