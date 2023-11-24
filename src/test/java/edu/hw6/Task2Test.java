package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import static edu.hw6.Task2.cloneFile;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {
    @Test
    public void testCloneFileWithSeveralFiles() throws IOException {
        Path originalFile = Path.of("Tinkoff Bank Biggest Secret.txt");
        try {
            Files.delete(originalFile);
        } catch (NoSuchFileException ignored) {
        }

        try {
            Files.delete(originalFile.resolveSibling("Tinkoff Bank Biggest Secret — копия.txt"));
        } catch (NoSuchFileException ignored) {
        }

        try {
            Files.delete(originalFile.resolveSibling("Tinkoff Bank Biggest Secret — копия (2).txt"));
        } catch (NoSuchFileException ignored) {
        }

        Files.createFile(originalFile);
        cloneFile(originalFile);
        cloneFile(originalFile);

        assertTrue(Files.exists(originalFile));
        assertTrue(Files.exists(originalFile.resolveSibling("Tinkoff Bank Biggest Secret — копия.txt")));
        assertTrue(Files.exists(originalFile.resolveSibling("Tinkoff Bank Biggest Secret — копия (2).txt")));

        Files.delete(originalFile);
        Files.delete(originalFile.resolveSibling("Tinkoff Bank Biggest Secret — копия.txt"));
        Files.delete(originalFile.resolveSibling("Tinkoff Bank Biggest Secret — копия (2).txt"));
    }
}
