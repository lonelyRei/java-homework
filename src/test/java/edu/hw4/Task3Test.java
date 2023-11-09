package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.hw4.Task3.getCuntOfAnimals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    public void testCountOfAnimalsWithSingleValue() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        Map<Animal.Type, Integer> actual = getCuntOfAnimals(animals);

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.BIRD, 1);
        expected.put(Animal.Type.CAT, 1);
        expected.put(Animal.Type.DOG, 1);
        expected.put(Animal.Type.FISH, 1);
        expected.put(Animal.Type.SPIDER, 1);

        assertEquals(expected, actual);
    }

    @Test
    public void testCountOfAnimalsWithSeveralValues() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true),
            new Animal("dog", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.CAT, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        Map<Animal.Type, Integer> actual = getCuntOfAnimals(animals);

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.SPIDER, 1);
        expected.put(Animal.Type.CAT, 3);
        expected.put(Animal.Type.BIRD, 1);

        assertEquals(expected, actual);
    }

    @Test
    public void testCountOfAnimalsWithEmptyValues() {
        List<Animal> animals = List.of(new Animal[] {});

        Map<Animal.Type, Integer> actual = getCuntOfAnimals(animals);

        Map<Animal.Type, Integer> expected = new HashMap<>();

        assertEquals(expected, actual);
    }
}
