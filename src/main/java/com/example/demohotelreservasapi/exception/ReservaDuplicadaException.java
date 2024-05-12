package com.example.demohotelreservasapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ReservaDuplicadaException extends RuntimeException {

    public ReservaDuplicadaException(String message) {
        super(message);
    }
}

