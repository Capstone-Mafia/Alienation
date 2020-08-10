package com.alienation.exceptionfiles;

public class ExceptionMessage extends Exception {

    //ctor
    public ExceptionMessage() {
        super("Something went wrong!");
    }

    public ExceptionMessage(String message) {
        super(message);
    }

}
