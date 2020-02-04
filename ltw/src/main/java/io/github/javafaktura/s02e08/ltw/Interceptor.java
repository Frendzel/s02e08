package io.github.javafaktura.s02e08.ltw;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import static org.slf4j.LoggerFactory.getLogger;

@Aspect
public class Interceptor {
    private static final Logger LOG = getLogger(Interceptor.class);

    @Around("execution(* *(..)) && !within(io.github.javafaktura.s02e08.ltw.Interceptor)"
            + " && (within(org.springframework.context.annotation.Condition+) || within(io.github..*))")
    public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        LOG.info("--------> " + joinPoint.toShortString() + ": " + result);
        return result;
    }

    @Around("execution(* *(..)) && within(io.github..*) && !within(io.github.javafaktura.s02e08.ltw.Interceptor+)")
    public Object stack(ProceedingJoinPoint joinPoint) throws Throwable {
        new RuntimeException().printStackTrace();
        return joinPoint.proceed();
    }

    @EventListener
    public void started(ContextRefreshedEvent event) {
        LOG.info("--------> Started" + ": " + event);
    }
}
