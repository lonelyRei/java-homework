package edu.hw2.Task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (int currentAttempt = 1; currentAttempt <= maxAttempts; currentAttempt++) {
            try {
                manager.getConnection().execute(command);
                return;
            } catch (ConnectionException e) {
                if (currentAttempt == maxAttempts) {
                    throw new ConnectionException("Something went wrong!", e);
                }
            }
        }
    }
}
