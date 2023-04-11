package com.epam.javacourse.hometask4;

import java.io.IOException;

public class IllegalOptionException extends IOException {

    public IllegalOptionException() {}
    public IllegalOptionException(String message) {
        super(message);
    }
}
