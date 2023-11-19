package edu.project3;

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
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String path = args[0];
        String from = args[1];
        String to = args[2];
        String format = args[3];

        if (path == null) {
            System.out.println("Не указан путь к файлу");
            return;
        }

        // если параметр from указан, то его нужно обработать
        LocalDate fromDate = null;
        if (from != null) {
            fromDate = LocalDate.parse(from, DateTimeFormatter.ISO_DATE);
        }

        // если параметр to указан, то его нужно обработать
        LocalDate toDate = null;
        if (to != null) {
            toDate = LocalDate.parse(to, DateTimeFormatter.ISO_DATE);
        }

        // Преобразуем в записи
        Stream<CustomLogRecord> logRecords = readLogRecords(path);

        // Генерируем репорт
        CustomLogReport report = analyzeLogRecords(logRecords, fromDate, toDate);

        // Генерируем вывод
        String output = generateOutput(report, format);

        // Выводим информацию
        System.out.println(output);
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
        Stream<CustomLogRecord> logRecords,
        LocalDate fromDate,
        LocalDate toDate
    ) {
        Stream<CustomLogRecord> filteredRecords = filterLogRecords(logRecords, fromDate, toDate);

        long totalRequests = filteredRecords.count();
        int averageResponseSize = calculateAverageResponseSize(filteredRecords);
        Map<String, Integer> requestedResources = getRequestedResources(filteredRecords);
        Map<Integer, Integer> responseCodes = getResponseCodes(filteredRecords);

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
        return logRecords.filter((record) -> record.getTimestamp().isAfter(fromDate) &&
            record.getTimestamp().isBefore(toDate));
    }

    private static int calculateAverageResponseSize(Stream<CustomLogRecord> logRecords) {
        AtomicInteger totalSize = new AtomicInteger();

        logRecords.forEach((record) -> totalSize.addAndGet(record.getResponseSize()));

        return totalSize.get();
    }

    private static Map<String, Integer> getRequestedResources(Stream<CustomLogRecord> logRecords) {
        Map<String, Integer> result = new HashMap<>();

        logRecords.forEach((record) -> result.put(
            record.getRequest().getUrl(),
            result.getOrDefault(record.getRequest().getUrl(), 0) + 1
        ));

        return result;
    }

    private static Map<Integer, Integer> getResponseCodes(Stream<CustomLogRecord> logRecords) {
        Map<Integer, Integer> result = new HashMap<>();

        logRecords.forEach((record) -> result.put(
            record.getResponseCode(),
            result.getOrDefault(record.getResponseCode(), 0) + 1
        ));

        return result;
    }

    private static String generateOutput(CustomLogReport report, String format) {
        StringBuilder result = new StringBuilder();


        return "";
    }
}
