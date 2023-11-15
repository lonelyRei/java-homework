package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    private Task6() {

    }

    public static boolean isSubsequence(String s, String t) {
        String pattern = ".*" + s + ".*";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(t);

        return matcher.matches();
    }
}
