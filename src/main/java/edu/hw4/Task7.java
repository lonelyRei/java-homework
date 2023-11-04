package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task7 {
    private Task7() {

    }

    @SuppressWarnings("MagicNumber")
    public static Animal getKthOldestAnimal(List<Animal> animals, int k) {
        if (k <= 0 || k > animals.size()) {
            throw new IllegalArgumentException("Illegal argument k");
        }

        List<Animal> copiedAnimals = new ArrayList<>(animals);
        copiedAnimals.sort(Comparator.comparingInt(Animal::age).reversed());

        return copiedAnimals.get(k - 1);
    }
}
