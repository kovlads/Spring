package ru.geekbrains.springboot.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super("boot - " + message);
    }
}
