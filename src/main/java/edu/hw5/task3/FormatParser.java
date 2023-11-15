package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class FormatParser implements TryParser {
    private static final DateTimeFormatter[] DATE_FORMATS = {
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("yyyy-MM-d"),
        DateTimeFormatter.ofPattern("yyyy-M-dd"),
        DateTimeFormatter.ofPattern("yyyy-M-d"),
        DateTimeFormatter.ofPattern("M/d/yyyy"),
        DateTimeFormatter.ofPattern("M/d/yy"),
        DateTimeFormatter.ofPattern("MM/dd/yyyy"),
        DateTimeFormatter.ofPattern("MM/dd/yy"),
    };

    private FormatParser() {

    }

    public static Optional<LocalDate> tryParse(String input) {
        for (DateTimeFormatter formatter : DATE_FORMATS) {
            try {
                LocalDate date = LocalDate.parse(input, formatter);
                return Optional.of(date);
            } catch (Exception ignored) {
            }
        }

        return Optional.empty();
    }
}
