package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task15 {
    private Task15() {

    }

    public static Map<Animal.Type, Integer> calculateTotalWeightByType(List<Animal> animals, int k, int l) {
        Map<Animal.Type, Integer> totalWeightByType = new HashMap<>();

        for (Animal animal : animals) {
            if (animal.age() >= k && animal.age() <= l) {
                int currentWeight = totalWeightByType.getOrDefault(animal.type(), 0);
                totalWeightByType.put(animal.type(), currentWeight + animal.weight());
            }
        }

        return totalWeightByType;
    }
}
