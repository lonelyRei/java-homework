package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    public record Negate(Expr value) implements Expr {
        private static final int ZERO = 0;

        @Override
        public double evaluate() {
            double evaluatedValue = value.evaluate();

            return evaluatedValue == ZERO ? ZERO : -evaluatedValue;
        }
    }

    public record Exponent(Expr base, double power) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), power);
        }
    }

    public record Addition(Expr firstOperand, Expr secondOperand) implements Expr {
        @Override
        public double evaluate() {
            return firstOperand().evaluate() + secondOperand().evaluate();
        }
    }

    public record Multiplication(Expr firstOperand, Expr secondOperand) implements Expr {
        @Override
        public double evaluate() {
            return firstOperand().evaluate() * secondOperand().evaluate();
        }
    }
}
