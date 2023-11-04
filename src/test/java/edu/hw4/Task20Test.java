package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.hw4.Task20.findAnimalsWithStringErrors;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task20Test {
    @Test
    public void testFindAnimalsWithStringErrors() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("", Animal.Type.FISH, Animal.Sex.F, 2, 5, -40, false),
            new Animal("CAT", Animal.Type.CAT, Animal.Sex.F, -2, -5, 40, false),
        });

        Map<String, String> actual = findAnimalsWithStringErrors(animals);

        Map<String, String> expected = new HashMap<>();
        expected.put(
            "",
            new ValidationError("Name is missing!", ErrorFields.NAME).getFullError() +
            new ValidationError("Incorrect weight!", ErrorFields.WEIGHT).getFullError()

        );
        expected.put(
            "CAT",
            new ValidationError("Incorrect height!", ErrorFields.HEIGHT).getFullError() +
                new ValidationError("Incorrect age!", ErrorFields.AGE).getFullError()
        );

        assertEquals(actual.size(), expected.size());

        for (String key : actual.keySet()) {
            assertEquals(expected.get(key), actual.get(key));
        }
    }
}
