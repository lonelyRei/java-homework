package edu.hw6;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static edu.hw6.Task4.writeTextToFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    public void testWriteTextToFile() throws IOException {
        String fileName = "output.txt";
        writeTextToFile(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            assertEquals("Programming is learned by writing programs. ― Brian Kernighan", line);
        }

        try {
            Files.delete(Path.of(fileName));
        } catch (NoSuchFileException ignored) {
        }
    }
}
