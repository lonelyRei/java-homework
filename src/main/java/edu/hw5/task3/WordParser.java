package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class WordParser implements TryParser {
    private WordParser() {

    }

    public static Optional<LocalDate> tryParse(String input) {
        return switch (input) {
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            case "today" -> Optional.of(LocalDate.now());
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            default -> Optional.empty();
        };
    }
}
