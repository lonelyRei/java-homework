package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw4.Task10.getAnimalsWithMismatchedAgeAndPaws;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task10Test {
    @Test
    public void testGetAnimalsWithMismatchedAgeAndPawsWithMismatches() {
        Animal firstMismatch =
            new Animal("cat1", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true);
        Animal secondMismatch =
            new Animal("spider2", Animal.Type.SPIDER, Animal.Sex.M, 18, 10, 20, false);
        Animal thirdMismatch =
            new Animal("dgo1", Animal.Type.DOG, Animal.Sex.F, 1, 1, 100, true);

        List<Animal> animals = List.of(new Animal[] {
            firstMismatch,
            new Animal("cat2", Animal.Type.CAT, Animal.Sex.F, 4, 5, 40, false),
            new Animal("spider1", Animal.Type.SPIDER, Animal.Sex.F, 8, 1, 1, true),
            secondMismatch,
            thirdMismatch,
            new Animal("dgo2", Animal.Type.DOG, Animal.Sex.M, 4, 10, 20, false),
        });

        List<Animal> actual = getAnimalsWithMismatchedAgeAndPaws(animals);

        List<Animal> expected = List.of(new Animal[] {firstMismatch, secondMismatch, thirdMismatch});

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAnimalsWithMismatchedAgeAndPawsWithoutMismatches() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("cat2", Animal.Type.CAT, Animal.Sex.F, 4, 5, 40, false),
            new Animal("spider1", Animal.Type.SPIDER, Animal.Sex.F, 8, 1, 1, true),
            new Animal("dgo2", Animal.Type.DOG, Animal.Sex.M, 4, 10, 20, false),
        });

        List<Animal> actual = getAnimalsWithMismatchedAgeAndPaws(animals);

        List<Animal> expected = List.of(new Animal[] {});

        assertEquals(expected, actual);
    }
}
