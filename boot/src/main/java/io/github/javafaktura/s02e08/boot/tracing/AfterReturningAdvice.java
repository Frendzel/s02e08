package io.github.javafaktura.s02e08.boot.tracing;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AfterReturningAdvice {

    private boolean afterReturningCalled = false;

    public boolean isAfterReturningCalled() {
        return afterReturningCalled;
    }

    @AfterReturning(pointcut = "execution(* returnsStringAndThrowsRuntimeException(..))", returning = "string")
    public void logResult(String string) {
        afterReturningCalled = true;
        log.debug("result " + string);
    }

}
