package com.alienation.exceptionfiles;

public class InvalidSynonymInputException extends Exception {

    //ctor
    public InvalidSynonymInputException() {
        super("Action unrecognized. Please try another command.");
    }

    public InvalidSynonymInputException(String message) {
        super(message);
    }

}
