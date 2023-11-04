package edu.hw4;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import static edu.hw4.Task19.findAnimalsWithErrors;

public class Task20 {
    private Task20() {

    }

    public static Map<String, String> findAnimalsWithStringErrors(List<Animal> animals) {
        Map<String, LinkedHashSet<ValidationError>> animalsWithErrors = findAnimalsWithErrors(animals);

        Map<String, String> result = new HashMap<>();

        for (String key : animalsWithErrors.keySet()) {
            StringBuilder currentAnimalError = new StringBuilder();

            for (ValidationError error : animalsWithErrors.get(key)) {
                currentAnimalError.append(error.getFullError());
            }

            result.put(key, currentAnimalError.toString());
        }

        return result;
    }
}
