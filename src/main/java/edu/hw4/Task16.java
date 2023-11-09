package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task16 {
    private Task16() {

    }

    public static List<Animal> sortAnimals(List<Animal> animals) {
        List<Animal> sortedAnimals = new ArrayList<>(animals);

        sortedAnimals.sort(Comparator.comparing(Animal::type)
            .thenComparing(Animal::sex)
            .thenComparing(Animal::name));

        return sortedAnimals;
    }
}
