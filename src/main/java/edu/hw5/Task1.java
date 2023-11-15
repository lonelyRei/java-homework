package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    private static final String DATE_PATTERN = "yyyy-MM-dd, HH:mm";

    private Task1() {

    }

    public static String calculateAverageSessionTime(List<String> input) {
        Duration totalDuration = Duration.ZERO;

        for (String entry : input) {
            String[] parts = entry.split(" - ");
            LocalDateTime startDateTime =
                LocalDateTime.parse(parts[0], DateTimeFormatter.ofPattern(DATE_PATTERN));
            LocalDateTime endDateTime = LocalDateTime.parse(parts[1], DateTimeFormatter.ofPattern(DATE_PATTERN));
            Duration sessionDuration = Duration.between(startDateTime, endDateTime);
            totalDuration = totalDuration.plus(sessionDuration);
        }

        long averageDurationInSeconds = totalDuration.toSeconds() / input.size();
        Duration averageDuration = Duration.ofSeconds(averageDurationInSeconds);

        long hours = averageDuration.toHours();
        long minutes = averageDuration.toMinutesPart();

        return hours + "ч " + minutes + "м";
    }
}
