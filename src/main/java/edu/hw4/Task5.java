package edu.hw4;

import java.util.List;

public class Task5 {
    private Task5() {

    }

    public static Animal.Sex getDominantSex(List<Animal> animals) {
        int maleCount = 0;
        int femaleCount = 0;

        for (Animal animal : animals) {
            if (animal.sex() == Animal.Sex.M) {
                maleCount++;
            } else if (animal.sex() == Animal.Sex.F) {
                femaleCount++;
            }
        }

        return compareCountOfAnimals(maleCount, femaleCount);
    }

    private static Animal.Sex compareCountOfAnimals(int maleCount, int femaleCount) {
        if (maleCount > femaleCount) {
            return Animal.Sex.M;
        } else if (femaleCount > maleCount) {
            return Animal.Sex.F;
        } else {
            return null;
        }
    }
}
