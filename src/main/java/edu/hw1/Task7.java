package edu.hw1;

import static edu.hw1.Constants.BINARY_DIGIT;

public class Task7 {
    private Task7() {
    }

    public static int rotateRight(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        int binaryShift = shift % binaryStr.length();
        String rotatedBinaryStr = binaryStr.substring(binaryStr.length() - binaryShift)
            + binaryStr.substring(0, binaryStr.length() - binaryShift);
        return Integer.parseInt(rotatedBinaryStr, BINARY_DIGIT);
    }

    public static int rotateLeft(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        int binaryShift = shift % binaryStr.length();
        String rotatedBinaryStr = binaryStr.substring(binaryShift) + binaryStr.substring(0, binaryShift);
        return Integer.parseInt(rotatedBinaryStr, BINARY_DIGIT);
    }
}
