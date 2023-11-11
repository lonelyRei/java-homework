package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {
    private Task7() {
    }

    public static boolean isAtLeast3SymbolsAndThirdIsZero(String input) {
        return Pattern.compile("^[01]{2}0[01]*$").matcher(input).find();
    }

    public static boolean isStartAndEndWithSameCharacter(String input) {
        return Pattern.compile("^0[01]*0$|^1[01]*1$|^0$|^1$").matcher(input).find();
    }

    public static boolean isLengthMoreOrEqualsOneAndLessOrEqualsThree(String input) {
        return Pattern.compile("^[01]{1,3}$").matcher(input).find();
    }
}
