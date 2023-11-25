package edu.hw7;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3WithLockTest {
    @Test
    public void testAddAndFindByName() {
        Task3WithLock service = new Task3WithLock();
        service.add(new Person(1, "Даниил", "Тест", "14141414"));
        List<Person> result = service.findByName("Даниил");
        assertEquals(1, result.size());
    }

    @Test
    public void testDeleteAndFindByAddress() {
        Task3WithLock service = new Task3WithLock();
        Person person = new Person(1, "Даниил", "Тест", "4124124142412");
        service.add(person);
        service.delete(1);
        List<Person> result = service.findByAddress("Тест");
        assertEquals(0, result.size());
    }

    @Test
    public void testFindByPhoneNonExistent() {
        Task3WithLock service = new Task3WithLock();
        service.add(new Person(1, "Даниил", "улица Пушкина", "88005553535"));
        List<Person> result = service.findByPhone("88005553535");
        assertEquals(1, result.size());
    }
}