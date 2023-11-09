package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.*;
import static edu.hw4.Task19.findAnimalsWithErrors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task19Test {
    @Test
    public void testFindAnimalsWithErrors() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("", Animal.Type.FISH, Animal.Sex.F, 2, 5, 40, false),
            new Animal("CAT", Animal.Type.CAT, Animal.Sex.F, -2, 5, 40, false),
            new Animal("DOG", Animal.Type.DOG, Animal.Sex.F, 2, -5, 40, false),
            new Animal("BIRD", Animal.Type.BIRD, Animal.Sex.F, 2, 5, -40, false)
        });

        Map<String, LinkedHashSet <ValidationError>> actual = findAnimalsWithErrors(animals);

        Map<String, Set<ValidationError>> expected = new HashMap<>();
        expected.put("", new HashSet<>(List.of(new ValidationError("Name is missing!", ErrorFields.NAME))));
        expected.put("CAT", new HashSet<>(List.of(new ValidationError("Incorrect age!", ErrorFields.AGE))));
        expected.put("DOG", new HashSet<>(List.of(new ValidationError("Incorrect height!", ErrorFields.HEIGHT))));
        expected.put("BIRD", new HashSet<>(List.of(new ValidationError("Incorrect weight!", ErrorFields.WEIGHT))));

        assertEquals(actual.size(), expected.size());

        assertEquals(expected.get("").size(), actual.get("").size());
        assertTrue(expected.get("").stream().anyMatch(error -> error.getError().equals("Name is missing!")));

        assertEquals(expected.get("CAT").size(), actual.get("CAT").size());
        assertTrue(expected.get("CAT").stream().anyMatch(error -> error.getError().equals("Incorrect age!")));

        assertEquals(expected.get("DOG").size(), actual.get("DOG").size());
        assertTrue(expected.get("DOG").stream().anyMatch(error -> error.getError().equals("Incorrect height!")));

        assertEquals(expected.get("BIRD").size(), actual.get("BIRD").size());
        assertTrue(expected.get("BIRD").stream().anyMatch(error -> error.getError().equals("Incorrect weight!")));
    }
}
