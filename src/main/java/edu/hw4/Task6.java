package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {
    private Task6() {

    }

    public static Map<Animal.Type, Animal> getHeaviestAnimals(List<Animal> animals) {
        Map<Animal.Type, Animal> heaviestAnimals = new HashMap<>();

        for (Animal animal : animals) {
            Animal.Type type = animal.type();
            if (!heaviestAnimals.containsKey(type) || animal.weight() > heaviestAnimals.get(type).weight()) {
                heaviestAnimals.put(type, animal);
            }
        }

        return heaviestAnimals;
    }
}
