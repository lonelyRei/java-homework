package edu.hw4;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static edu.hw4.Task8.getHeaviestAnimalBelowK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8Test {
    @Test
    public void testGetHeaviestAnimalBelowKWithCorrectValues() {
        Animal expectedOutput =
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false);

        List<Animal> animals = List.of(new Animal[] {
            new Animal("dog", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            expectedOutput,
            new Animal("fish", Animal.Type.CAT, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
        });

        Optional<Animal> actual = getHeaviestAnimalBelowK(animals, 25);

        assertEquals(Optional.of(expectedOutput), actual);
    }

    @Test
    public void testGetHeaviestAnimalBelowKWithoutFindAnyAnimal() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("dog", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.CAT, Animal.Sex.F, 2, 500, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 100, 1, true),
        });

        Optional<Animal> actual = getHeaviestAnimalBelowK(animals, 20);

        Optional<Animal> expected = Optional.empty();

        assertEquals(expected, actual);
    }
}
