package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw4.Task11.filterAnimals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task11Test {
    @Test
    public void testFilterAnimalsWithCorrectValues() {
        Animal catThatMatch =
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 101, 30, true);

        Animal fishThatMatch =
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 300, 10, true);

        List<Animal> animals = List.of(new Animal[] {
            catThatMatch,
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 20, 50, true),
            fishThatMatch,
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 400, 1, false),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 1006, 20, false),
        });

        List<Animal> actual = filterAnimals(animals);

        List<Animal> expected = List.of(new Animal[] {catThatMatch, fishThatMatch});

        assertEquals(expected, actual);
    }

    @Test
    public void testFilterAnimalsWithEmptyList() {
        List<Animal> animals = List.of(new Animal[] {});

        List<Animal> actual = filterAnimals(animals);

        List<Animal> expected = List.of();

        assertEquals(expected, actual);
    }
}
