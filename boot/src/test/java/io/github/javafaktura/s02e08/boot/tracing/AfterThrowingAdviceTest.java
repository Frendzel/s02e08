package io.github.javafaktura.s02e08.boot.tracing;

import io.github.javafaktura.s02e08.boot.transaction.LegacyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AfterThrowingAdviceTest {

    @Autowired
    AfterThrowingAdvice afterThrowingAdvice;

    @Autowired
    LegacyService simpleService;

    @BeforeEach
    public void rest() {
        afterThrowingAdvice.reset();
    }

    @Test
    public void afterThrowingIsNotCalledIfMethodReturnSuccessfully() {
        assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
        simpleService.doSomething();
        assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
    }

    @Test
    public void afterThrowingIsCalledIfMethodThrowsRuntimeException() {
        assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
        try {
            assertThrows(RuntimeException.class, () -> simpleService.throwsRuntimeException());
        } finally {
            assertTrue(afterThrowingAdvice.isAfterThrowingCalled());
        }
    }

    @Test
    public void afterThrowingIsNotCalledIfMethodThrowsException() {
        assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
        try {
            assertThrows(Exception.class, () -> simpleService.throwsException());
        } finally {
            assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
        }
    }


}