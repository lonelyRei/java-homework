package edu.hw4;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Task19 {
    private Task19() {

    }

    public static Map<String, LinkedHashSet<ValidationError>> findAnimalsWithErrors(List<Animal> animals) {
        Map<String, LinkedHashSet<ValidationError>> animalsWithErrors = new HashMap<>();

        for (Animal animal : animals) {
            LinkedHashSet<ValidationError> errors = new LinkedHashSet<>();

            performValidations(animal, errors);

            if (!errors.isEmpty()) {
                animalsWithErrors.put(animal.name(), errors);
            }
        }

        return animalsWithErrors;
    }

    private static void performValidations(Animal animal, LinkedHashSet<ValidationError> errors) {
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
