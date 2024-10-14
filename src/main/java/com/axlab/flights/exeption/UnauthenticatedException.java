package com.axlab.flights.exeption;

import lombok.experimental.StandardException;
import org.springframework.security.core.AuthenticationException;

@StandardException
public class UnauthenticatedException extends AuthenticationException {
}
