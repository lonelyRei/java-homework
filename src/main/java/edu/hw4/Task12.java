package edu.hw4;

import java.util.List;

public class Task12 {
    private Task12() {

    }

    public static int getCountOfAnimalsWeightGraterThenHeight(List<Animal> animals) {
        int totalCount = 0;

        for (Animal animal : animals) {
            if (animal.weight() > animal.height()) {
                totalCount++;
            }
        }

        return totalCount;
    }
}
