package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw4.Task16.sortAnimals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task16Test {
    @Test
    public void testSortAnimals() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("a", Animal.Type.CAT, Animal.Sex.F, 2, 5, 40, false),

            new Animal("a", Animal.Type.SPIDER, Animal.Sex.M, 3, 1, 5, true),
            new Animal("b", Animal.Type.SPIDER, Animal.Sex.F, 5, 1, 15, true),

            new Animal("a", Animal.Type.DOG, Animal.Sex.F, 30, 100, 250, false),
            new Animal("b", Animal.Type.DOG, Animal.Sex.M, 4, 10, 25, false),
            new Animal("b", Animal.Type.DOG, Animal.Sex.F, 5, 10, 25, false),
            new Animal("a", Animal.Type.DOG, Animal.Sex.M, 6, 10, 25, false),
        });

        List<Animal> actual = sortAnimals(animals);
        List<Animal> expected = List.of(new Animal[] {
            new Animal("a", Animal.Type.CAT, Animal.Sex.F, 2, 5, 40, false),

            new Animal("a", Animal.Type.DOG, Animal.Sex.F, 30, 100, 250, false),
            new Animal("b", Animal.Type.DOG, Animal.Sex.F, 5, 10, 25, false),
            new Animal("a", Animal.Type.DOG, Animal.Sex.M, 6, 10, 25, false),
            new Animal("b", Animal.Type.DOG, Animal.Sex.M, 4, 10, 25, false),

            new Animal("b", Animal.Type.SPIDER, Animal.Sex.F, 5, 1, 15, true),
            new Animal("a", Animal.Type.SPIDER, Animal.Sex.M, 3, 1, 5, true),
        });

        assertEquals(expected, actual);
    }
}
