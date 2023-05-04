package edu.guilford;

public class BadEmailException extends Exception {

    public BadEmailException() {
        super();
    }

    public BadEmailException(String message) {
        super(message);
    }

    public BadEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadEmailException(Throwable cause) {
        super(cause);
    }
}

