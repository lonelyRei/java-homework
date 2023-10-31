package edu.hw1;

import java.util.Arrays;
import static edu.hw1.Constants.KAPREKAR_CONST;

public class Task6 {
    private Task6() {
    }

    public static int countK(int value) {
        if (value == KAPREKAR_CONST) {
            return 0;
        }

        return 1 + countK(sortDigitsInNumber(value, true) - sortDigitsInNumber(value, false));
    }

    private static int sortDigitsInNumber(int number, boolean reversedOrder) {
        String numberString = String.valueOf(number);

        char[] digitsArray = numberString.toCharArray();

        Arrays.sort(digitsArray);

        if (reversedOrder) {
            StringBuilder sortedNumberString = new StringBuilder(new String(digitsArray));
            sortedNumberString.reverse();
            return Integer.parseInt(sortedNumberString.toString());
        } else {
            String sortedNumberString = new String(digitsArray);

            return Integer.parseInt(sortedNumberString);
        }
    }
}
