package edu.hw3;

public class Task4 {
    private Task4() {
    }

    @SuppressWarnings("MagicNumber")
    public static String convertToRoman(int number) {
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumber = new StringBuilder();

        int inputNumber = number;

        for (int i = 0; i < arabicValues.length; i++) {
            while (inputNumber >= arabicValues[i]) {
                romanNumber.append(romanSymbols[i]);
                inputNumber -= arabicValues[i];
            }
        }

        return romanNumber.toString();
    }
}
