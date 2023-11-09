package edu.hw4;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw4.Task14.isExistDogTallerThenK;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task14Test {
    @Test
    public void testIsExistDogTallerThenKReturnsTrue() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 101, 200, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 200, 50, true),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 300, 305, true),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 400, 1, false),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 2000, 50, true),
        });

        boolean actual = isExistDogTallerThenK(animals, 200);

        assertTrue(actual);
    }

    @Test
    public void testIsExistDogTallerThenKReturnsFalse() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 101, 200, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 200, 50, true),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 300, 305, true),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 400, 1, false),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 2000, 50, true),
        });

        boolean actual = isExistDogTallerThenK(animals, 20000);

        assertFalse(actual);
    }
}
