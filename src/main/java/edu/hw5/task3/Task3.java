package edu.hw5.task3;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Task3 {

    private Task3() {

    }

    public static Optional<LocalDate> parseDate(String input) {
        return input == null ? Optional.empty() : getParsedDate(List.of(
            WordParser.tryParse(input),
            FormatParser.tryParse(input),
            IntervalParser.tryParse(input)
        ));
    }

    private static Optional<LocalDate> getParsedDate(List<Optional<LocalDate>> parsedDates) {
        for (Optional<LocalDate> date : parsedDates) {
            if (date.isPresent()) {
                return date;
            }
        }

        return Optional.empty();
    }
}
