package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Task2.sortAnimalsByWeight;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @Test
    public void testSortAnimalsByWeightWithCorrectValues() {
        List<Animal> animalsBeforeSort = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        List<Animal> actual = sortAnimalsByWeight(animalsBeforeSort, 3);

        List<Animal> expected = List.of(new Animal[] {
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 35, 50, true),
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        assertEquals(expected, actual);
    }

    @Test
    public void testSortAnimalsByWeightWithKValueGraterThenListSize() {
        List<Animal> animalsBeforeSort = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        List<Animal> actual = sortAnimalsByWeight(animalsBeforeSort, 100);

        List<Animal> expected = List.of(new Animal[] {
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 35, 50, true),
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
        });

        assertEquals(expected, actual);
    }

    @Test
    public void testSortAnimalsByWeightWithException() {
        List<Animal> animalsBeforeSort = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 20, 30, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 35, 50, true),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 5, 10, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 10, 20, false),
        });

        assertThrows(IllegalArgumentException.class, () -> sortAnimalsByWeight(animalsBeforeSort, -3));
    }
}
