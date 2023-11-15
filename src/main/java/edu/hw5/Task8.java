package edu.hw5;

public class Task8 {
    private Task8() {

    }

    // Нечетная длина
    public static boolean isOddLength(String input) {
        return input.matches("^[01]([01]{2})*$");
    }

    // Начинается с 0 - нечетная длина; Начинается с 1 - четная длина
    public static boolean isEvenOrOddLength(String input) {
        return input.matches("^1[01]([01]{2})*$|^0([01]{2})*$");
    }

    // Все цифры на нечетных позициях = 1
    public static boolean areNumbersOnOddPositionsEqualOne(String input) {
        return input.matches("^1([01]1)*[01]?$");
    }

    // Нет последовательных единиц
    public static boolean areThereNoRepeatingOnes(String input) {
        return input.matches("^(?!.*11)[01]+$");
    }
}
