package edu.hw3;

public class Task1 {
    private final static int LATTER_CHAR_CODE = 25;

    private Task1() {

    }

    public static String atbash(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c) && validateSymbol(Character.toString(c).toLowerCase())) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encryptedChar = (char) (LATTER_CHAR_CODE - (c - base) + base);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    private static boolean validateSymbol(String input) {
        return input.matches("[a-z]");
    }
}
