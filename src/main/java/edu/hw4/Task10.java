package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task10 {
    private Task10() {

    }

    public static List<Animal> getAnimalsWithMismatchedAgeAndPaws(List<Animal> animals) {
        List<Animal> mismatchedList = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.paws() != animal.age()) {
                mismatchedList.add(animal);
            }
        }
        return mismatchedList;
    }
}
