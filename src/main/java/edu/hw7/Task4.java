package edu.hw7;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    private Task4() {

    }

    @SuppressWarnings("MagicNumber")
    public static double calculatePiMultiThreaded(int iterations, int numThreads) throws InterruptedException,
        ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
        int perThread = iterations / numThreads;

        for (int i = 0; i < numThreads; i++) {
            completionService.submit(() -> {
                int circleCount = 0;
                for (int j = 0; j < perThread; j++) {
                    double x = ThreadLocalRandom.current().nextDouble();
                    double y = ThreadLocalRandom.current().nextDouble();

                    if (x * x + y * y <= 1) {
                        circleCount++;
                    }
                }
                return circleCount;
            });
        }

        int circleCount = 0;
        for (int i = 0; i < numThreads; i++) {
            circleCount += completionService.take().get();
        }

        executor.shutdown();

        return 4.0 * circleCount / iterations;
    }
}
