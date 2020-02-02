package io.github.javafaktura.s02e08.boot.tracing;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AfterThrowingAdvice {
    private boolean afterThrowingCalled;

    public boolean isAfterThrowingCalled() {
        return afterThrowingCalled;
    }

    public void reset() {
        afterThrowingCalled = false;
    }

    @AfterThrowing(pointcut = "execution(void throwsRuntimeException())", throwing = "ex")
    public void logException(RuntimeException ex) {
        afterThrowingCalled = true;
        log.error("Exception ", ex);
    }
}
