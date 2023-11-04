package edu.hw4;

import java.util.List;

public class Task4 {
    private Task4() {

    }

    public static Animal getAnimalWithLongestName(List<Animal> animals) {
        Animal animalWithLongestName = null;
        int maxLength = 0;

        for (Animal animal : animals) {
            int nameLength = animal.name().length();
            if (nameLength > maxLength) {
                maxLength = nameLength;
                animalWithLongestName = animal;
            }
        }

        return animalWithLongestName;
    }
}
