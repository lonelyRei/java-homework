package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw4.Task17.isSpidersBiteOftenThenDogs;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task17Test {
    @Test
    public void testIsSpidersBiteOftenThenDogsWithoutAnimals() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("a", Animal.Type.CAT, Animal.Sex.F, 2, 5, 40, false),
        });

        boolean actual = isSpidersBiteOftenThenDogs(animals);

        assertFalse(actual);
    }

    @Test
    public void testIsSpidersBiteOftenThenDogsReturnsTrue() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("a", Animal.Type.SPIDER, Animal.Sex.F, 2, 5, 40, true),
            new Animal("b", Animal.Type.SPIDER, Animal.Sex.F, 2, 5, 40, true),
            new Animal("a", Animal.Type.DOG, Animal.Sex.F, 2, 5, 40, false),
            new Animal("a", Animal.Type.DOG, Animal.Sex.F, 2, 5, 40, true),
        });

        boolean actual = isSpidersBiteOftenThenDogs(animals);

        assertTrue(actual);
    }

    @Test
    public void testIsSpidersBiteOftenThenDogsReturnsFalse() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("a", Animal.Type.SPIDER, Animal.Sex.F, 2, 5, 40, true),
            new Animal("b", Animal.Type.SPIDER, Animal.Sex.F, 2, 5, 40, false),
            new Animal("a", Animal.Type.DOG, Animal.Sex.F, 2, 5, 40, true),
            new Animal("b", Animal.Type.DOG, Animal.Sex.F, 2, 5, 40, true),
        });

        boolean actual = isSpidersBiteOftenThenDogs(animals);

        assertFalse(actual);
    }

    @Test
    public void testIsSpidersBiteOftenThenDogsReturnsFalseBecauseOfEqual() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("a", Animal.Type.SPIDER, Animal.Sex.F, 2, 5, 40, true),
            new Animal("a", Animal.Type.SPIDER, Animal.Sex.F, 2, 5, 40, false),
            new Animal("a", Animal.Type.DOG, Animal.Sex.F, 2, 5, 40, false),
            new Animal("a", Animal.Type.DOG, Animal.Sex.F, 2, 5, 40, true),
        });

        boolean actual = isSpidersBiteOftenThenDogs(animals);

        assertFalse(actual);
    }
}
