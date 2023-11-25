package edu.project3.Entities;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static edu.project3.utils.DateFormatters.parseDate;

public class CustomLogRecord {
    private String ipAddress;
    private LocalDate timestamp;
    private Request request;
    private int responseCode;
    private int responseSize;

    CustomLogRecord(String ipAddress, LocalDate timestamp, Request request, int responseCode, int responseSize) {
        this.ipAddress = ipAddress;
        this.timestamp = timestamp;
        this.request = request;
        this.responseCode = responseCode;
        this.responseSize = responseSize;
    }

    public static CustomLogRecord parse(String line) {
        // Паттерн для распознавания элементов строки
        String pattern = "^(\\S+) - - \\[(.*?)\\] \"(.*?)\" (\\d+) (\\d+) \"(.*?)\" \"(.*?)\"$";

        // Создание объекта Pattern
        Pattern regex = Pattern.compile(pattern);

        // Создание объекта Matcher
        Matcher matcher = regex.matcher(line);

        return parseValues(matcher);
    }

    @SuppressWarnings("MagicNumber")
    private static CustomLogRecord parseValues(Matcher matcher) {
        if (matcher.matches()) {
            String ipAddress = matcher.group(1);
            String timestamp = matcher.group(2);
            String request = matcher.group(3);
            String responseCode = matcher.group(4);
            String responseSize = matcher.group(5);

            LocalDate parsedTimestamp = parseDate(timestamp);
            Request parsedRequest = parseRequest(request);
            int parsedResponseCode = parseInteger(responseCode);
            int parsedResponseSize = parseInteger(responseSize);

            return new CustomLogRecord(
                ipAddress,
                parsedTimestamp,
                parsedRequest,
                parsedResponseCode,
                parsedResponseSize
            );
        } else {
            return null;
        }
    }

    @SuppressWarnings("MagicNumber")
    private static Request parseRequest(String requestToParse) {
        String regex = "^(\\w+)\\s+(\\S+)\\s+(\\S+)$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(requestToParse);

        if (matcher.matches()) {
            String method = matcher.group(1);
            String url = matcher.group(2);
            String protocol = matcher.group(3);
            return new Request(method, url, protocol);
        } else {
            return null;
        }
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(int responseSize) {
        this.responseSize = responseSize;
    }
}
