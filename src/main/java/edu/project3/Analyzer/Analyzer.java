package edu.project3.Analyzer;

import edu.project3.Entities.CustomLogRecord;
import edu.project3.Entities.CustomLogReport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Analyzer {
    private static final String PATH_KEY = "--path";
    private static final String FROM_KEY = "--from";
    private static final String TO_KEY = "--to";
    private final CustomLogReport customLogRecord;
    private LocalDate fromDate;
    private LocalDate toDate;

    public Analyzer(Map<String, String> parameters) {
        if (parameters.get(PATH_KEY) == null) {
            throw new NullPointerException("Required start parameter `" + PATH_KEY + "` is not defined!");
        }

        defineFromAndTo(parameters.get(FROM_KEY), parameters.get(TO_KEY));

        Supplier<Stream<CustomLogRecord>> logRecords = () -> readLogRecords(parameters.get(PATH_KEY));
        Supplier<Stream<CustomLogRecord>> filteredLogRecords =
            () -> filterLogRecords(logRecords.get(), fromDate, toDate);

        // Генерируем репорт
        this.customLogRecord = analyzeLogRecords(filteredLogRecords, this.fromDate, this.toDate);
    }

    private static Stream<CustomLogRecord> readLogRecords(String path) {
        try {
            if (path.startsWith("http")) {
                URL url = new URL(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                return reader.lines().map(CustomLogRecord::parse);
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                return reader.lines().map(CustomLogRecord::parse);
            }
        } catch (IOException e) {
            return Stream.empty();
        }
    }

    private static CustomLogReport analyzeLogRecords(
        Supplier<Stream<CustomLogRecord>> logRecords,
        LocalDate fromDate,
        LocalDate toDate
    ) {
        long totalRequests = logRecords.get().count();
        int averageResponseSize = calculateAverageResponseSize(logRecords.get(), (int) totalRequests);
        Map<String, Integer> requestedResources = getRequestedResources(logRecords.get());
        Map<Integer, Integer> responseCodes = getResponseCodes(logRecords.get());

        return new CustomLogReport(
            fromDate,
            toDate,
            totalRequests,
            averageResponseSize,
            requestedResources,
            responseCodes
        );
    }

    private static Stream<CustomLogRecord> filterLogRecords(
        Stream<CustomLogRecord> logRecords,
        LocalDate fromDate,
        LocalDate toDate
    ) {
        return logRecords.filter((currentRecord) -> {
            if (currentRecord != null) {
                return (fromDate == null || currentRecord.getTimestamp().isAfter(fromDate))
                    && (toDate == null || currentRecord.getTimestamp().isBefore(toDate));
            } else {
                return false;
            }
        });
    }

    private static int calculateAverageResponseSize(Stream<CustomLogRecord> logRecords, int totalRequests) {
        AtomicInteger totalSize = new AtomicInteger();

        logRecords.forEach((currentRecord) -> {
            if (currentRecord != null) {
                totalSize.addAndGet(currentRecord.getResponseSize());
            }
        });

        return totalSize.get() / (totalRequests == 0 ? 1 : totalRequests);
    }

    private static Map<String, Integer> getRequestedResources(Stream<CustomLogRecord> logRecords) {
        Map<String, Integer> result = new HashMap<>();

        logRecords.forEach((currentRecord) -> {
            if (currentRecord != null) {
                String url = currentRecord.getRequest().getUrl();
                result.put(url, result.getOrDefault(url, 0) + 1);
            }

        });

        return result;
    }

    private static Map<Integer, Integer> getResponseCodes(Stream<CustomLogRecord> logRecords) {
        Map<Integer, Integer> result = new HashMap<>();

        logRecords.forEach((currentRecord) -> {
            if (currentRecord != null) {
                int code = currentRecord.getResponseCode();
                result.put(code, result.getOrDefault(code, 0) + 1);
            }
        });

        return result;
    }

    private void defineFromAndTo(String from, String to) {
        this.fromDate = from != null ? LocalDate.parse(from, DateTimeFormatter.ISO_LOCAL_DATE) : null;
        this.toDate = to != null ? LocalDate.parse(to, DateTimeFormatter.ISO_LOCAL_DATE) : null;
    }

    public CustomLogReport getCustomLogRecord() {
        return customLogRecord;
    }
}
