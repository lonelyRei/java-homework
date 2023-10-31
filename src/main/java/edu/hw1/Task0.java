package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task0 {
    private Task0() {
    }

    private final static Logger LOGGER = LogManager.getLogger("Tinkoff");

    public static void sayHi() {
        LOGGER.info("Привет, мир!");
    }
}
