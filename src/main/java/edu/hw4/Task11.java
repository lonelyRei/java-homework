package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task11 {
    private final static int MIN_HEIGHT = 100;

    private Task11() {

    }

    public static List<Animal> filterAnimals(List<Animal> animals) {
        List<Animal> filteredAnimals = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.bites() && animal.height() > MIN_HEIGHT) {
                filteredAnimals.add(animal);
            }
        }

        return filteredAnimals;
    }
}
