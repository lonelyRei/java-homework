package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task19 {
    private Task19() {

    }

    public static Map<String, Set<ValidationError>> findAnimalsWithErrors(List<Animal> animals) {
        Map<String, Set<ValidationError>> animalsWithErrors = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> errors = new HashSet<>();

            performValidations(animal, errors);

            if (!errors.isEmpty()) {
                animalsWithErrors.put(animal.name(), errors);
            }
        }

        return animalsWithErrors;
    }

    private static void performValidations(Animal animal, Set<ValidationError> errors) {
        if (validateAnimalName(animal)) {
            errors.add(new ValidationError("Name is missing!", ErrorFields.NAME));
        }

        if (validateAnimalHeight(animal)) {
            errors.add(new ValidationError("Incorrect height!", ErrorFields.HEIGHT));
        }

        if (validateAnimalWeight(animal)) {
            errors.add(new ValidationError("Incorrect weight!", ErrorFields.WEIGHT));
        }

        if (validateAnimalAge(animal)) {
            errors.add(new ValidationError("Incorrect age!", ErrorFields.AGE));
        }
    }

    private static boolean validateAnimalName(Animal animal) {
        return animal.name() == null || animal.name().isEmpty();
    }

    private static boolean validateAnimalHeight(Animal animal) {
        return animal.height() < 0;
    }

    private static boolean validateAnimalWeight(Animal animal) {
        return animal.weight() < 0;
    }

    private static boolean validateAnimalAge(Animal animal) {
        return animal.age() < 0;
    }
}
