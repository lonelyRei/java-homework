package edu.hw6;

import java.io.IOException;
import java.net.ServerSocket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {
    private static final int MAX_PORT = 49151;
    private final static Logger LOGGER = LogManager.getLogger();

    private Task6() {

    }

    public static void checkAllPorts() {
        for (int port = 0; port <= MAX_PORT; port++) {
            LOGGER.info("Port " + port + (isPortAvailable(port) ? " is available" : " is busy"));
        }
    }

    public static boolean isPortAvailable(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
