package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private Task4() {
    }

    public static boolean validatePassword(String password) {
        return password != null
            && Pattern.compile("^[^~!@#$%^&*|]*?[~!@#$%^&*|][^~!@#$%^&*|]*?$").matcher(password).find();
    }
}
