package edu.hw4;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw4.Task12.getCountOfAnimalsWeightGraterThenHeight;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task12Test {
    @Test
    public void testGetCountOfAnimalsWeightGraterThenHeightWithAnswersExist() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 101, 200, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 20, 50, true),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 300, 305, true),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 400, 1, false),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 1006, 20, false),
        });

        int expected = 3;
        int actual = getCountOfAnimalsWeightGraterThenHeight(animals);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCountOfAnimalsWeightGraterThenHeightWithoutAnswers() {
        List<Animal> animals = List.of(new Animal[] {
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 101, 10, true),
            new Animal("dog", Animal.Type.DOG, Animal.Sex.F, 5, 20, 7, true),
            new Animal("fish", Animal.Type.FISH, Animal.Sex.F, 2, 300, 3, true),
            new Animal("spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 400, 1, false),
            new Animal("bird", Animal.Type.BIRD, Animal.Sex.M, 3, 1006, 20, false),
        });

        int expected = 0;
        int actual = getCountOfAnimalsWeightGraterThenHeight(animals);
        assertEquals(expected, actual);
    }
}
