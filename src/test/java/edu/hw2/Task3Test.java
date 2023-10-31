package edu.hw2;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnection;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.StableConnection;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    private static final int ITERATIONS_TO_TEST = 100;

    @Test
    @DisplayName("FaultyConnectionManager always returns FaultyConnection")
    public void testFaultyConnectionManager() {
        Connection connection = new FaultyConnectionManager().getConnection();
        assertEquals(connection.getClass(), FaultyConnection.class);
    }

    @Test
    @DisplayName("DefaultConnectionManager sometimes might returns StableConnection")
    public void testDefaultConnectionManagerReturnStableConnection() {
        assertTrue(IntStream.range(0, ITERATIONS_TO_TEST)
            .mapToObj(iteration -> new DefaultConnectionManager())
            .anyMatch(manager -> manager.getConnection() instanceof StableConnection));
    }

    @Test
    @DisplayName("DefaultConnectionManager sometimes might returns FaultyConnection")
    public void testDefaultConnectionManagerReturnFaultyConnection() {
        assertTrue(IntStream.range(0, ITERATIONS_TO_TEST)
            .mapToObj(iteration -> new DefaultConnectionManager())
            .anyMatch(manager -> manager.getConnection() instanceof FaultyConnection));
    }

    @Test
    @DisplayName("StableConnection never throws errors")
    public void testStableConnectionToNotThrowErrors() {
        IntStream.range(0, ITERATIONS_TO_TEST)
            .mapToObj(iteration -> new StableConnection())
            .forEach(connection -> assertDoesNotThrow(() -> connection.execute("test command")));
    }
}
