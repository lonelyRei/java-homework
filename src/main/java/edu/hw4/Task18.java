package edu.hw4;

import java.util.List;

public class Task18 {
    private Task18() {

    }

    public static Animal findHeaviestFish(List<List<Animal>> animalLists) {
        Animal heaviestFish = null;
        double maxWeight = 0.0;

        for (List<Animal> animalList : animalLists) {
            for (Animal animal : animalList) {
                if (animal.type() == Animal.Type.FISH && animal.weight() > maxWeight) {
                    maxWeight = animal.weight();
                    heaviestFish = animal;
                }
            }
        }

        return heaviestFish;
    }
}
