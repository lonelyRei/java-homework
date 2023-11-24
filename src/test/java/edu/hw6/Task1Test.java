package edu.hw6;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class Task1Test {
    private static final String TEST_FILE_PATH = "test_disk_map.txt";
    private DiskMap diskMap;

    @BeforeEach
    void setUp() {
        diskMap = new DiskMap(TEST_FILE_PATH);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE_PATH));
    }

    @Test
    void testPutAndGet() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        assertEquals("value1", diskMap.get("key1"));
        assertEquals("value2", diskMap.get("key2"));
    }

    @Test
    void testRemove() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        assertEquals("value1", diskMap.remove("key1"));
        assertNull(diskMap.get("key1"));
        assertEquals(1, diskMap.size());
    }

    @Test
    void testClear() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        diskMap.clear();

        assertTrue(diskMap.isEmpty());
    }

    @Test
    void testContainsKey() {
        diskMap.put("key1", "value1");

        assertTrue(diskMap.containsKey("key1"));
        assertFalse(diskMap.containsKey("key2"));
    }
}
