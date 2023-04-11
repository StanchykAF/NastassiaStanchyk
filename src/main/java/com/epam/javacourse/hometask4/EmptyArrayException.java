package com.epam.javacourse.hometask4;

public class EmptyArrayException extends NullPointerException{

    public EmptyArrayException() {}
    public EmptyArrayException(String message) {
        super(message);
    }
}
