package io.github.javafaktura.s02e08.boot.tracing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

    private static final Logger log = LoggerFactory.getLogger(TracingAspect.class.getName());
    private boolean enteringCalled = false;

    public boolean isEnteringCalled() {
        return enteringCalled;
    }

    @Before("execution(* doSomething(..))")
    public void entering(JoinPoint joinPoint) {
        this.enteringCalled = true;
        log.debug("entering " + joinPoint.getStaticPart().getSignature().toString());
    }

}