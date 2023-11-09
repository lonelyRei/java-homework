package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Task1.sortAnimalsByHeight;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void testSortAnimalsByHeightWithCorrectValues() {
        List<Animal> animalsBeforeSort = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 35, 50, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 10, false),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
        });

        List<Animal> actual = sortAnimalsByHeight(animalsBeforeSort);

        List<Animal> expected = List.of(new Animal[] {
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 5, 10, false),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 10, false),
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 35, 50, true),
        });

        assertEquals(expected, actual);
    }

    @Test
    public void testSortAnimalsByHeightWithEmptyList() {
        List<Animal> animalsBeforeSort = List.of(new Animal[] {});

        List<Animal> actual = sortAnimalsByHeight(animalsBeforeSort);

        List<Animal> expected = List.of(new Animal[] {});

        assertEquals(expected, actual);
    }
}
