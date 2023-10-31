package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8Test {
    @Test
    public void testBackwardIterator() {
        List<Integer> numbers = List.of(1, 2, 3);
        BackwardIterator<Integer> iterator = new BackwardIterator<>(numbers);

        iterator.next();
        iterator.next();

        Integer expected = 1;
        Integer actual = iterator.next();

        assertEquals(expected, actual);
    }
}
