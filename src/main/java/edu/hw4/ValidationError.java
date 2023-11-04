package edu.hw4;

public class ValidationError {
    private final String error;
    private final ErrorFields errorField;

    public ValidationError(String error, ErrorFields errorField) {
        this.error = error;
        this.errorField = errorField;
    }

    public String getError() {
        return error;
    }

    public ErrorFields getErrorField() {
        return errorField;
    }

    public String getFullError() {
        return this.errorField.getField() + ": " + this.error;
    }
}
