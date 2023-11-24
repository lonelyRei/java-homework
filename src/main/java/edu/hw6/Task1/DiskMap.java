package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiskMap implements Map<String, String> {
    private final String filePath;

    public DiskMap(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int size() {
        return readFromFile().size();
    }

    @Override
    public boolean isEmpty() {
        return readFromFile().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return readFromFile().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return readFromFile().containsValue(value);
    }

    @Override
    public String get(Object key) {
        return readFromFile().get(key);
    }

    @Override
    public String put(String key, String value) {
        Map<String, String> map = readFromFile();
        String previousValue = map.put(key, value);
        writeToFile(map);
        return previousValue;
    }

    @Override
    public String remove(Object key) {
        Map<String, String> map = readFromFile();
        String removedValue = map.remove(key);
        writeToFile(map);
        return removedValue;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        Map<String, String> map = readFromFile();
        map.putAll(m);
        writeToFile(map);
    }

    @Override
    public void clear() {
        writeToFile(new HashMap<>());
    }

    @Override
    public Set<String> keySet() {
        return readFromFile().keySet();
    }

    @Override
    public Collection<String> values() {
        return readFromFile().values();
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return readFromFile().entrySet();
    }

    private Map<String, String> readFromFile() {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        } catch (IOException ignored) {
        }
        return map;
    }

    private void writeToFile(Map<String, String> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException ignored) {
        }
    }
}
