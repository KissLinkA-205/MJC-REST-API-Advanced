package com.epam.esm.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Class {@code LoggingAspect} used to log the application.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(com.epam.esm..*)")
    public void dataAccessMethods() {
    }

    @Before("dataAccessMethods())")
    public void logBeforeExecutionTime(JoinPoint jp) {
        LOGGER.debug("Executing method: " + jp.getSignature() +
                " with arguments " + Arrays.asList(jp.getArgs()));
    }

    @Around("dataAccessMethods()")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object proceed = pjp.proceed();
        long end = System.nanoTime();
        LOGGER.debug("Execution of " + pjp.getSignature() + " took " +
                TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return proceed;
    }

    @AfterReturning(value = "dataAccessMethods()", returning = "object")
    public void logAfterReturningValue(JoinPoint jp, Object object) {
        LOGGER.debug("Method " + jp.getSignature() + " successfully executed and return value [" + object + "]");
    }

    @AfterThrowing(value = "dataAccessMethods()", throwing = "e")
    public void logAfterThrowingException(JoinPoint jp, Exception e) {
        LOGGER.error("Method " + jp.getSignature() + " throw " + e);
    }
}
