package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private final AtomicInteger counter = new AtomicInteger(0);

    Task1() {

    }

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public int getCounterValue() {
        return counter.get();
    }
}
