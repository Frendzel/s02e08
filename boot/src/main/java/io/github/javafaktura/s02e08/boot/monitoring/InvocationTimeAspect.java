package io.github.javafaktura.s02e08.boot.monitoring;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;

import static java.lang.Thread.currentThread;
import static java.time.Duration.between;
import static java.time.Instant.now;

@Component
@Aspect
public class InvocationTimeAspect {

    private static final Logger log = LoggerFactory.getLogger(InvocationTimeAspect.class.getName());

    @Before("@annotation(io.github.javafaktura.s02e08.boot.monitoring.CalculateInvocationTime)")
    public void logTimeInvocation1() {
        log.info("Before invocation");
    }

    @After("@annotation(io.github.javafaktura.s02e08.boot.monitoring.CalculateInvocationTime)")
    public void logTimeInvocation2() {
        log.info("After invocation");
    }

    @Around("@annotation(io.github.javafaktura.s02e08.boot.monitoring.CalculateInvocationTime)")
    public Object logTimeInvocation3(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Instant start = now();
        Object proceed = proceedingJoinPoint.proceed();
        StringBuilder builder = new StringBuilder();
        builder.append(Arrays.toString(proceedingJoinPoint.getArgs()));
        builder.append(proceedingJoinPoint.getSignature());
        builder.append(proceed);
        Thread thread = currentThread();
        builder.append(thread.getName());
        log.debug(builder.toString());
        Instant end = now();
        log.debug("Invocation: " + between(start, end).toMillis());
        return proceed;
    }
}
