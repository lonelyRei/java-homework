package edu.hw7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Task3 {
    private final Map<Integer, Person> cache = new ConcurrentHashMap<>();
    private final Map<String, Set<Integer>> nameIndex = new ConcurrentHashMap<>();
    private final Map<String, Set<Integer>> addressIndex = new ConcurrentHashMap<>();
    private final Map<String, Set<Integer>> phoneIndex = new ConcurrentHashMap<>();

    Task3() {

    }

    public synchronized void add(Person person) {
        cache.put(person.id(), person);
        addToIndex(nameIndex, person.name(), person.id());
        addToIndex(addressIndex, person.address(), person.id());
        addToIndex(phoneIndex, person.phoneNumber(), person.id());
    }

    public synchronized void delete(int id) {
        Person person = cache.remove(id);
        if (person != null) {
            removeFromIndex(nameIndex, person.name(), id);
            removeFromIndex(addressIndex, person.address(), id);
            removeFromIndex(phoneIndex, person.phoneNumber(), id);
        }
    }

    public List<Person> findByName(String name) {
        return searchFromIndex(nameIndex, name);
    }

    public List<Person> findByAddress(String address) {
        return searchFromIndex(addressIndex, address);
    }

    public List<Person> findByPhone(String phone) {
        return searchFromIndex(phoneIndex, phone);
    }

    private synchronized void addToIndex(Map<String, Set<Integer>> index, String key, int id) {
        index.computeIfAbsent(key, k -> ConcurrentHashMap.newKeySet()).add(id);
    }

    private synchronized void removeFromIndex(Map<String, Set<Integer>> index, String key, int id) {
        index.computeIfPresent(key, (k, v) -> {
            v.remove(id);
            if (v.isEmpty()) {
                return null;
            }
            return v;
        });
    }

    private List<Person> searchFromIndex(Map<String, Set<Integer>> index, String key) {
        Set<Integer> ids = index.get(key);
        if (ids == null) {
            return Collections.emptyList();
        }
        List<Person> results = new ArrayList<>();
        for (int id : ids) {
            Person person = cache.get(id);
            if (person != null) {
                results.add(person);
            }
        }
        return results;
    }
}
