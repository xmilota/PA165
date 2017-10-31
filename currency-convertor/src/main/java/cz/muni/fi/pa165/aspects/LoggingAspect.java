package cz.muni.fi.pa165.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import javax.inject.Named;

import static java.lang.System.currentTimeMillis;

/**
 * @author Tomas Milota
 */
@Named
@Aspect
public class LoggingAspect {

    @Around("execution(public * *(..))")
    public Object logMethodDuration(ProceedingJoinPoint joinPoint) throws Throwable {

        Long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();

        System.err.println("Method " + joinPoint.getSignature() + " lasted " + (endTime - startTime) + "ms.");

        return result;
    }

}
