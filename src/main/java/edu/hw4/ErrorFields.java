package edu.hw4;

public enum ErrorFields {
    NAME("name"),
    AGE("age"),
    WEIGHT("weight"),
    HEIGHT("height");

    private final String field;

    ErrorFields(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
