package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String str) {
        char[] charStr = str.toCharArray();

        for (int currentPos = 0; currentPos < charStr.length - 1; currentPos += 2) {
            char tmp = charStr[currentPos];
            charStr[currentPos] = charStr[currentPos + 1];
            charStr[currentPos + 1] = tmp;
        }

        return new String(charStr);
    }
}
