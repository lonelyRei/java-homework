package edu.hw2.Task3;

import java.util.logging.Logger;
import static edu.hw2.Task3.Utils.isConnectionUnstable;

public class FaultyConnection implements Connection {
    static boolean isClosed;
    private final Logger faultyConnectionLogger = Logger.getLogger("FAULTY_CONNECTION");

    @Override
    public void execute(String command) {
        open();
        if (isConnectionUnstable()) {
            close();
            throw new ConnectionException("Faulty Connection Error");
        } else {
            faultyConnectionLogger.info("Executing command: " + command);
            close();
        }
    }

    public void open() {
        faultyConnectionLogger.info("Open connection");
        isClosed = false;
    }

    @Override
    public void close() {
        faultyConnectionLogger.info("Close connection");
        isClosed = true;
    }
}
