package edu.project3.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateFormatters {
    private DateFormatters() {

    }

    public static LocalDate parseDate(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        try {
            return LocalDate.parse(input, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
