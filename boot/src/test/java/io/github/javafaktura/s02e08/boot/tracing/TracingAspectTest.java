package io.github.javafaktura.s02e08.boot.tracing;

import io.github.javafaktura.s02e08.boot.transaction.LegacyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TracingAspectTest {

    @Autowired
    TracingAspect tracingAspect;

    @Autowired
    LegacyService simpleService;

    @Test
    public void aspectIsCalled() {
        assertFalse(tracingAspect.isEnteringCalled());
        simpleService.doSomething();
        assertTrue(tracingAspect.isEnteringCalled());
    }
}