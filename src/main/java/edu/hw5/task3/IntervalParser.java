package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntervalParser implements TryParser {
    private IntervalParser() {

    }

    public static Optional<LocalDate> tryParse(String input) {
        Matcher matcher = Pattern.compile("^(?<daysCount>\\d+) day(s)? (?<interval>ago|after)$").matcher(input);

        if (matcher.find()) {
            String daysCount = "daysCount";
            int days = Integer.parseInt(matcher.group(daysCount));

            String interval = "interval";
            return switch (matcher.group(interval)) {
                case "ago" -> Optional.of(LocalDate.now().minusDays(days));
                case "after" -> Optional.of(LocalDate.now().plusDays(days));
                default -> Optional.empty();
            };
        }

        return Optional.empty();
    }
}
