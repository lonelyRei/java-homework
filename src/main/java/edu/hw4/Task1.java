package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    private Task1() {

    }

    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        List<Animal> copiedAnimals = new ArrayList<>(animals);
        copiedAnimals.sort(Comparator.comparingInt(Animal::height));
        return copiedAnimals;
    }
}
