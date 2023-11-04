package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw4.Task13.getAnimalsWithCompositeName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task13Test {
    @Test
    public void testGetAnimalsWithCompositeNameWithMatches() {
        Animal catThatMatch =
            new Animal("cat cat cat", Animal.Type.CAT, Animal.Sex.M, 5, 101, 30, true);

        Animal fishThatMatch =
            new Animal("fish fish ff", Animal.Type.FISH, Animal.Sex.F, 2, 300, 10, true);

        List<Animal> animals = List.of(new Animal[] {
            catThatMatch,
            new Animal("", Animal.Type.DOG, Animal.Sex.F, 5, 20, 50, true),
            fishThatMatch,
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 400, 1, false),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 1006, 20, false),
        });

        List<Animal> actual = getAnimalsWithCompositeName(animals);
        List<Animal> expected = List.of(new Animal[] {catThatMatch, fishThatMatch});

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAnimalsWithCompositeNameWithoutMatches() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("cat cat", Animal.Type.CAT, Animal.Sex.M, 5, 101, 30, true),
            new Animal("", Animal.Type.DOG, Animal.Sex.F, 5, 20, 50, true),
            new Animal("fish fish", Animal.Type.FISH, Animal.Sex.F, 2, 300, 10, true),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 400, 1, false),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 1006, 20, false),
        });

        List<Animal> actual = getAnimalsWithCompositeName(animals);
        List<Animal> expected = List.of(new Animal[] {});

        assertEquals(expected, actual);
    }
}
