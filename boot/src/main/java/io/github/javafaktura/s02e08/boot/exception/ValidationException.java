package io.github.javafaktura.s02e08.boot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(code = BAD_REQUEST, reason = "Validation Exception")
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
