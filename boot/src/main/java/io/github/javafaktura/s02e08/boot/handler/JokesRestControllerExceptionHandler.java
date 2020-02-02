package io.github.javafaktura.s02e08.boot.handler;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class JokesRestControllerExceptionHandler {

    @ExceptionHandler(value = MismatchedInputException.class)
    public void handleMismatchedInputException(HttpServletRequest request,
                                               HttpServletResponse response) throws IOException {
        response.sendError(400, "Wrong Json structure");
    }

}
