package com.axlab.flights.exeption;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationNotFoundUserException extends AuthenticationException {
    public AuthenticationNotFoundUserException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public AuthenticationNotFoundUserException(String msg) {
        super(msg);
    }
}
