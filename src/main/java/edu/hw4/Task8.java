package edu.hw4;

import java.util.List;
import java.util.Optional;

public class Task8 {
    private Task8() {

    }

    public static Optional<Animal> getHeaviestAnimalBelowK(List<Animal> animals, int k) {
        Optional<Animal> heaviestAnimal = Optional.empty();
        int maxWeight = 0;
        for (Animal animal : animals) {
            if (animal.height() < k && animal.weight() > maxWeight) {
                heaviestAnimal = Optional.of(animal);
                maxWeight = animal.weight();
            }
        }
        return heaviestAnimal;
    }
}
