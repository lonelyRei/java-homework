package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    @SuppressWarnings("MagicNumber")
    public static List<Animal> sortAnimalsByWeight(List<Animal> animals, int k) {
        if (k < 0) {
            throw new IllegalArgumentException("Incorrect argument k");
        }

        List<Animal> copiedAnimals = new ArrayList<>(animals);
        copiedAnimals.sort(Comparator.comparingInt(Animal::weight).reversed());

        return copiedAnimals.subList(0, Math.min(k, animals.size()));
    }
}
