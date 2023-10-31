package edu.hw3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.hw3.Task2.clusterize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void testClusterizeBracketsSimpleInput() {
        List<String> actual = clusterize("()()()");
        List<String> expected = List.of(new String[] {"()", "()", "()"});

        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeBracketsWithoutClusters() {
        List<String> actual = clusterize("((()))");
        List<String> expected = List.of(new String[] {"((()))"});

        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeBracketsWithMultipleClusters() {
        List<String> actual = clusterize("((()))(())()()(()())");
        List<String> expected = List.of(new String[] {"((()))", "(())", "()", "()", "(()())"});

        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeBracketsWithSmallCountOfClusters() {
        List<String> actual = clusterize("((())())(()(()()))");
        List<String> expected = List.of(new String[] {"((())())", "(()(()()))"});

        assertEquals(expected, actual);
    }
}
