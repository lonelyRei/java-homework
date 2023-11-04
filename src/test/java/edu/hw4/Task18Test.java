package edu.hw4;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw4.Task18.findHeaviestFish;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task18Test {
    @Test
    public void testFindHeaviestFish() {
        List<Animal> animals1 = List.of(new Animal[] {
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 2, 5, 40, false),
            new Animal("a", Animal.Type.CAT, Animal.Sex.F, 2, 5, 40, false),
        });

        Animal heaviestFish =
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 2, 5, 41, false);

        List<Animal> animals2 = List.of(new Animal[] {
            heaviestFish,
            new Animal("a", Animal.Type.DOG, Animal.Sex.F, 2, 5, 40, false),
        });

        List<Animal> animals3 = List.of(new Animal[] {
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 2, 5, 3, false),
            new Animal("a", Animal.Type.SPIDER, Animal.Sex.F, 2, 5, 40, false),
        });

        Animal actual = findHeaviestFish(List.of(animals3, animals1, animals2));

        assertEquals(heaviestFish, actual);
    }
}
