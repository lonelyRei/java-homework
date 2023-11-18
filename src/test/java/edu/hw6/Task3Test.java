package edu.hw6;

import edu.hw6.Task3.CastomAbstractFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class Task3Test {
    private static final Path TEST_DIR =  Paths.get("src/test/java/edu/hw6/task3_tests");

    @Test
    public void testFilterChainWithPng() throws IOException {
        CastomAbstractFilter filter = CastomAbstractFilter.REGULAR_FILE
            .and(CastomAbstractFilter.READABLE)
            .and(CastomAbstractFilter.largerThan(30000))
            .and(CastomAbstractFilter.magicNumber(0x89, 'P', 'N', 'G'))
            .and(CastomAbstractFilter.globMatches("*.png"))
            .and(CastomAbstractFilter.regexContains("[-]"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TEST_DIR, filter)) {
            entries.forEach(System.out::println);
        }
    }
}
