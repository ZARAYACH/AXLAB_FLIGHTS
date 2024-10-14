package com.axlab.flights.exeption;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationInvalidTokenException extends AuthenticationException {
    public AuthenticationInvalidTokenException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public AuthenticationInvalidTokenException(String msg) {
        super(msg);
    }
}
