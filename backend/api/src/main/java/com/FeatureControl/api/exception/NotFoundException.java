package com.FeatureControl.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
//        System.out.println("Custom Mesaage");
        super(message);
    }
}
