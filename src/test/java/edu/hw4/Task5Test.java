package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw4.Task5.getDominantSex;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task5Test {
    @Test
    public void testGetDominantSexReturnsMale() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("dog", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.CAT, Animal.Sex.M, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 1, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        Animal.Sex actual = getDominantSex(animals);

        Animal.Sex expected = Animal.Sex.M;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetDominantSexReturnsFemale() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("dog", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.CAT, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        Animal.Sex actual = getDominantSex(animals);

        Animal.Sex expected = Animal.Sex.F;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetDominantSexReturnsEquals() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("dog", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.CAT, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 1, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        Animal.Sex actual = getDominantSex(animals);

        assertNull(actual);
    }
}
