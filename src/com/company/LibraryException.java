package com.company;

/**
 * Exception class used to contain all the exceptions in our library app.
 */
public class LibraryException extends Exception {

    public LibraryException() {
        super();
    }

    public LibraryException(String message) {
        super(message);
    }

    public LibraryException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryException(Throwable cause) {
        super(cause);
    }

    protected LibraryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}






    // TODO : mettre l'exception librairie au clair dans ma méthode cmdNumber de Order

