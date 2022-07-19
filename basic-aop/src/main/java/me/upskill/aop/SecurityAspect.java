package me.upskill.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {

    /**
     * This pointcut targets any public method
     */
    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation() {
    }

    /**
     * This advice will run before any public methods
     */
    @Before("me.upskill.aop.SecurityAspect.anyPublicOperation()")
    public void logMethodEntry(JoinPoint jp) {
        System.out.println("Security Method Entry ==> " + jp.getSignature().getName());
    }
}
