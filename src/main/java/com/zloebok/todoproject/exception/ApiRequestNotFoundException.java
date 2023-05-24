package com.zloebok.todoproject.exception;

public class ApiRequestNotFoundException extends RuntimeException{

    public ApiRequestNotFoundException(String message) {
        super(message);
    }
}
