package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public interface TryParser {
    static Optional<LocalDate> tryParse(String input) {
        return Optional.empty();
    }
}
