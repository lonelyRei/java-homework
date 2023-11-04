package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw4.Task7.getKthOldestAnimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task7Test {
    @Test
    public void testGetKthOldestAnimalWithCorrectValues() {
        Animal expectedOutput =
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false);

        List<Animal> animals = List.of(new Animal[] {
            new Animal("dog", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            expectedOutput,
            new Animal("fish", Animal.Type.CAT, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
        });

        Animal actual = getKthOldestAnimal(animals, 2);

        assertEquals(expectedOutput, actual);
    }

    @Test
    public void testGetKthOldestAnimalWithException() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("dog", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
            new Animal("fish", Animal.Type.CAT, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
        });

        assertThrows(IllegalArgumentException.class, () -> getKthOldestAnimal(animals, 100));
    }
}
