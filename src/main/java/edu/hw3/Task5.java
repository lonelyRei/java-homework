package edu.hw3;

import java.util.Arrays;

public class Task5 {
    private Task5() {

    }

    public static String[] parseContacts(String[] contacts, SortOrders sortOrder) {
        if (contacts == null || contacts.length == 0) {
            return new String[0];
        }

        Arrays.sort(contacts, (value1, value2) -> {
            String lastName1 = value1.substring(value1.lastIndexOf(" ") + 1);
            String lastName2 = value2.substring(value2.lastIndexOf(" ") + 1);

            if (sortOrder == SortOrders.ASC) {
                return lastName1.compareTo(lastName2);
            } else {
                return lastName2.compareTo(lastName1);
            }
        });

        return contacts;
    }
}
