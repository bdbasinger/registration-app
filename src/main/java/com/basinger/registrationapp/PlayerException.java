package com.basinger.registrationapp;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class PlayerException extends RuntimeException {
    public PlayerException(String message) {
        super(message);
    }
}
