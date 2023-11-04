package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw4.Task4.getAnimalWithLongestName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task4Test {
    @Test
    public void testGetAnimalWithLongestNameWithCorrectValues() {
        Animal catWithVeryLongName =
            new Animal("catWithVeryLongName", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true);

        List<Animal> animals = List.of(new Animal[] {
            catWithVeryLongName,
            new Animal("dog", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.CAT, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        Animal actual = getAnimalWithLongestName(animals);

        assertEquals(catWithVeryLongName, actual);
    }

    @Test
    public void testGetAnimalWithLongestNameEmptyList() {
        List<Animal> animals = List.of(new Animal[] {});

        Animal actual = getAnimalWithLongestName(animals);

        assertNull(actual);
    }
}
