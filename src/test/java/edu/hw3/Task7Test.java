package edu.hw3;

import edu.hw3.Task7.NullKeyComparator;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    public void testNullKeyComparator() {
        TreeMap<String, String> tree = new TreeMap<>(new NullKeyComparator());
        tree.put(null, "test");

        assertTrue(tree.containsKey(null));
    }
}
