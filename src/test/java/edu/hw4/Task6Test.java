package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.hw4.Task6.getHeaviestAnimals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    public void testGetHeaviestAnimals() {
        Animal heavyCat =
            new Animal("cat1", Animal.Type.CAT, Animal.Sex.F, 5, 35, 50, true);
        Animal heavySpider =
            new Animal("spider2", Animal.Type.SPIDER, Animal.Sex.M, 3, 10, 20, false);
        Animal heavyDog =
            new Animal("dgo1", Animal.Type.DOG, Animal.Sex.F, 1, 1, 100, true);

        List<Animal> animals = List.of(new Animal[] {
            heavyCat,
            new Animal("cat2", Animal.Type.CAT, Animal.Sex.F, 2, 5, 40, false),
            new Animal("spider1", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
            heavySpider,
            heavyDog,
            new Animal("dgo2", Animal.Type.DOG, Animal.Sex.M, 3, 10, 20, false),
        });

        Map<Animal.Type, Animal> actual = getHeaviestAnimals(animals);

        Map<Animal.Type, Animal> expected = new HashMap<>();
        expected.put(Animal.Type.DOG, heavyDog);
        expected.put(Animal.Type.SPIDER, heavySpider);
        expected.put(Animal.Type.CAT, heavyCat);

        assertEquals(expected, actual);
    }
}
