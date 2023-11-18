package edu.hw6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Task5Test {
    @Test
    public void testHackerNewsTopStories() {
        Task5 hackerNews = new Task5();
        long[] topStories = hackerNews.hackerNewsTopStories();
        assertNotNull(topStories);
        assertNotEquals(0, topStories.length);
    }

    @Test
    public void testNews() {
        Task5 hackerNews = new Task5();
        String newsTitle = hackerNews.news(37570037);
        assertNotNull(newsTitle);
        assertNotEquals("Title not found", newsTitle);
    }
}
