package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.hw4.Task15.calculateTotalWeightByType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task15Test {
    @Test
    public void testCalculateTotalWeightByType() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("cat2", Animal.Type.CAT, Animal.Sex.F, 2, 5, 40, false),
            // too young
            new Animal("spider1", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),

            // match
            new Animal("dgo2", Animal.Type.DOG, Animal.Sex.M, 3, 10, 25, false),
            new Animal("dgo2", Animal.Type.DOG, Animal.Sex.M, 4, 10, 25, false),
            new Animal("dgo2", Animal.Type.DOG, Animal.Sex.M, 5, 10, 25, false),
            new Animal("dgo2", Animal.Type.DOG, Animal.Sex.M, 6, 10, 25, false),

            // too old
            new Animal("dgo2", Animal.Type.DOG, Animal.Sex.M, 7, 10, 25, false),

            // match
            new Animal("spider1", Animal.Type.SPIDER, Animal.Sex.F, 3, 1, 5, true),
            new Animal("spider1", Animal.Type.SPIDER, Animal.Sex.F, 5, 1, 15, true),
        });

        Map<Animal.Type, Integer> actual = calculateTotalWeightByType(animals, 3, 6);

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.DOG, 100);
        expected.put(Animal.Type.SPIDER, 20);

        assertEquals(expected, actual);
    }
}
