package io.github.javafaktura.s02e08.boot.dummy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DummyAspect {
    @Before("execution(void iWillDoThisAfterTheLastExam())")
    public void logException() {
    }
}
