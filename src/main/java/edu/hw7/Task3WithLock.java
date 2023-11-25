package edu.hw7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Task3WithLock {
    private final Map<Integer, Person> cache = new HashMap<>();
    private final Map<String, Set<Integer>> nameIndex = new HashMap<>();
    private final Map<String, Set<Integer>> addressIndex = new HashMap<>();
    private final Map<String, Set<Integer>> phoneIndex = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(Person person) {
        lock.writeLock().lock();
        try {
            cache.put(person.id(), person);
            addToIndex(nameIndex, person.name(), person.id());
            addToIndex(addressIndex, person.address(), person.id());
            addToIndex(phoneIndex, person.phoneNumber(), person.id());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = cache.remove(id);
            if (person != null) {
                removeFromIndex(nameIndex, person.name(), id);
                removeFromIndex(addressIndex, person.address(), id);
                removeFromIndex(phoneIndex, person.phoneNumber(), id);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return searchFromIndex(nameIndex, name);
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return searchFromIndex(addressIndex, address);
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return searchFromIndex(phoneIndex, phone);
        } finally {
            lock.readLock().unlock();
        }
    }

    private void addToIndex(Map<String, Set<Integer>> index, String key, int id) {
        index.computeIfAbsent(key, k -> new HashSet<>()).add(id);
    }

    private void removeFromIndex(Map<String, Set<Integer>> index, String key, int id) {
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
