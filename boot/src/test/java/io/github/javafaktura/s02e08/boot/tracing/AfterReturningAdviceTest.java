package io.github.javafaktura.s02e08.boot.tracing;

import io.github.javafaktura.s02e08.boot.transaction.LegacyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AfterReturningAdviceTest {

    @Autowired
    AfterReturningAdvice afterReturningAdvice;

    @Autowired
    LegacyService simpleService;

    @Test
    public void afterReturningIsNotCalledIfExceptionIsThrown() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
        try {
        assertThrows(RuntimeException.class, () -> simpleService.returnsStringAndThrowsRuntimeException())            ;
        } finally {
            assertFalse(afterReturningAdvice.isAfterReturningCalled());
        }
    }
}