package io.github.javafaktura.s02e08.boot.exception;


import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ResponseStatus(INTERNAL_SERVER_ERROR)
public class ReportingException extends RuntimeException {
}
