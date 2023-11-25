package edu.hw7;

import java.util.concurrent.ThreadLocalRandom;

public class Task4SingleThread {
    private Task4SingleThread() {

    }

    @SuppressWarnings("MagicNumber")
    public static double calculatePiSingleThreaded(int iterations) {
        int circleCount = 0;

        for (int i = 0; i < iterations; i++) {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();

            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }

        return 4.0 * circleCount / iterations;
    }
}
