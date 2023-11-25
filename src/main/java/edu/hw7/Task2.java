package edu.hw7;

import java.util.stream.LongStream;

public class Task2 {
    private Task2() {

    }

    public static long calculateFactorial(int n) {
        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(1, (long a, long b) -> a * b);
    }
}
