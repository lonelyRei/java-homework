package edu.hw1;

import static edu.hw1.Constants.DECIMAL_PLACES;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        int valueToCheck = number;
        while (valueToCheck >= DECIMAL_PLACES) {
            if (isPalindrome(valueToCheck)) {
                return true;
            }
            valueToCheck = getDescendant(valueToCheck);
        }

        return false;
    }

    private static int getDescendant(int number) {
        StringBuilder sb = new StringBuilder();
        String str = Integer.toString(number);
        for (int currentPos = 0; currentPos < str.length() - 1; currentPos += 2) {
            int digit1 = Character.getNumericValue(str.charAt(currentPos));
            int digit2 = Character.getNumericValue(str.charAt(currentPos + 1));
            sb.append(digit1 + digit2);
        }

        if (str.length() % 2 != 0) {
            sb.append(str.charAt(str.length() - 1));
        }

        return Integer.parseInt(sb.toString());
    }

    private static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

}
