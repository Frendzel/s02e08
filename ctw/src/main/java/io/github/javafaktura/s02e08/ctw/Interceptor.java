package io.github.javafaktura.s02e08.ctw;

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

    @Around("execution(* *(..)) && !within(io.github.javafaktura.s02e08.ctw.Interceptor)"
            + " && (within(org.springframework.context.annotation.Condition+) || within(io.github..*))")
    public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        LOG.info("--------> " + joinPoint.toShortString() + ": " + result);
        return result;
    }

    @EventListener
    public void started(ContextRefreshedEvent event) {
        LOG.info("--------> Started" + ": " + event);
    }
}
