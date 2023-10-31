package edu.hw2.Task3;

import java.util.logging.Logger;

public class StableConnection implements Connection {
    static boolean isClosed;
    private final Logger stableConnectionLogger = Logger.getLogger("STABLE_CONNECTION");

    @Override
    public void execute(String command) {
        open();
        stableConnectionLogger.info("Executing command: " + command);
        close();
    }

    public void open() {
        stableConnectionLogger.info("Open connection");
        isClosed = false;
    }

    @Override
    public void close() {
        stableConnectionLogger.info("Close connection");
        isClosed = true;
    }
}
