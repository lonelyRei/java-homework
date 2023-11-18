package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL_TEMPLATE = "https://hacker-news.firebaseio.com/v0/item/%d.json";
    private final HttpClient httpClient;

    Task5() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public long[] hackerNewsTopStories() {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(TOP_STORIES_URL))
            .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            String[] idStrings = responseBody.replaceAll("[\\[\\]\"]", "").split(",");
            long[] ids = new long[idStrings.length];
            for (int i = 0; i < idStrings.length; i++) {
                ids[i] = Long.parseLong(idStrings[i].trim());
            }

            return ids;
        } catch (IOException | InterruptedException e) {
            return new long[0];
        }
    }

    public String news(long id) {
        String itemUrl = String.format(ITEM_URL_TEMPLATE, id);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(itemUrl))
            .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            Pattern pattern = Pattern.compile("\"title\"\\s*:\\s*\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(responseBody);
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                return "Title not found";
            }
        } catch (IOException | InterruptedException e) {
            return "Error fetching news title";
        }
    }
}
