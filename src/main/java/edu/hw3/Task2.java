package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';

    private Task2() {

    }

    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        int openBracketsCount = 0;
        int closeBracketCount = 0;
        int startIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == OPEN_BRACKET) {
                openBracketsCount++;
            } else if (input.charAt(i) == CLOSE_BRACKET) {
                closeBracketCount++;
            }

            if (openBracketsCount == closeBracketCount) {
                clusters.add(input.substring(startIndex, i + 1));
                startIndex = i + 1;
            }
        }

        return clusters;
    }
}
