package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task13 {
    private final static int COUNT_OF_WORDS_IN_NAME = 2;

    private Task13() {

    }

    public static List<Animal> getAnimalsWithCompositeName(List<Animal> animals) {
        List<Animal> filteredAnimals = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.name().split(" ").length > COUNT_OF_WORDS_IN_NAME) {
                filteredAnimals.add(animal);
            }
        }

        return filteredAnimals;
    }
}
