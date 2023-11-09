package edu.hw4;

import java.util.List;

public class Task17 {
    private Task17() {

    }

    public static boolean isSpidersBiteOftenThenDogs(List<Animal> animals) {
        int spidersThatBite = 0;
        int dogsThatBite = 0;
        for (Animal animal : animals) {
            if (animal.type() == Animal.Type.DOG && animal.bites()) {
                dogsThatBite++;
            }

            if (animal.type() == Animal.Type.SPIDER && animal.bites()) {
                spidersThatBite++;
            }
        }

        return spidersThatBite == 0 && dogsThatBite == 0 ? false : spidersThatBite > dogsThatBite;
    }
}
