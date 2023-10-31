package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task3.freqDict;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    public void testGetFrequencyDictWithLetters() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("bb", 2);
        expected.put("a", 2);

        Map<String, Integer> actual = freqDict(List.of(new String[] {"a", "bb", "a", "bb"}));

        assertEquals(expected, actual);
    }

    @Test
    public void testGetFrequencyDictWithWords() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("this", 1);
        expected.put("and", 2);
        expected.put("that", 1);

        Map<String, Integer> actual = freqDict(List.of(new String[] {"this", "and", "that", "and"}));

        assertEquals(expected, actual);
    }

    @Test
    public void testGetFrequencyDictWithWordsFromDifferentLanguages() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("код", 3);
        expected.put("bug", 1);

        Map<String, Integer> actual = freqDict(List.of(new String[] {"код", "код", "код", "bug"}));

        assertEquals(expected, actual);
    }

    @Test
    public void testGetFrequencyDictWithDigits() {
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 2);

        Map<Integer, Integer> actual = freqDict(List.of(new Integer[] {1, 1, 2, 2}));

        assertEquals(expected, actual);
    }
}
