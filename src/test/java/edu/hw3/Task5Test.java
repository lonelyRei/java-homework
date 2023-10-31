package edu.hw3;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task5.parseContacts;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @Test
    public void testParseContactsASCSort() {
        List<String> expected = List.of(new String[] {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"});
        List<String> actual = List.of(parseContacts(
            new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
            SortOrders.ASC
        ));

        assertEquals(expected, actual);
    }

    @Test
    public void testParseContactsDESCSort() {
        List<String> expected = List.of(new String[] {"Carl Gauss", "Leonhard Euler", "Paul Erdos"});
        List<String> actual = List.of(parseContacts(
            new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"},
            SortOrders.DESC
        ));

        assertEquals(expected, actual);
    }

    @Test
    public void testParseContactsWithEmptyArray() {
        List<String> expected = List.of(new String[] {});
        List<String> actual = List.of(parseContacts(
            new String[] {},
            SortOrders.DESC
        ));

        assertEquals(expected, actual);
    }

    @Test
    public void testParseContactsWithNull() {
        List<String> expected = List.of(new String[] {});
        List<String> actual = List.of(parseContacts(
            null,
            SortOrders.DESC
        ));

        assertEquals(expected, actual);
    }
}
