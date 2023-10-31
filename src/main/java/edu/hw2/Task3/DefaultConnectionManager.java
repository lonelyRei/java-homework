package edu.hw2.Task3;

import static edu.hw2.Task3.Utils.isConnectionUnstable;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        if (isConnectionUnstable()) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
