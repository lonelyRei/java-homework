package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw4.Task9.getTotalPaws;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task9Test {
    @Test
    public void testGetTotalPawsWithNotEmptyList() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("CAT", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            new Animal("CAT", Animal.Type.CAT, Animal.Sex.F, 2, 5, 10, false),
            new Animal("SPIDER", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            new Animal("BIRD", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        int actual = getTotalPaws(animals);

        int expected = 18;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetTotalPawsWithEmptyList() {
        List<Animal> animals = List.of(new Animal[] {});

        int actual = getTotalPaws(animals);

        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetTotalPawsWithListOfFish() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("FISH1", Animal.Type.FISH, Animal.Sex.M, 30, 1560, 240, false),
            new Animal("FISH2", Animal.Type.FISH, Animal.Sex.M, 31, 102, 520, false),
            new Animal("FISH3", Animal.Type.FISH, Animal.Sex.M, 36, 120, 250, false),
            new Animal("FISH4", Animal.Type.FISH, Animal.Sex.M, 32, 130, 220, false),
        });

        int actual = getTotalPaws(animals);

        int expected = 0;

        assertEquals(expected, actual);
    }
}
