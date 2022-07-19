package me.upskill.springtutorials.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Defines an aspect.
 * An aspect can define a pointcuts, advices all in single component
 * for ordering - lowest number means highest precedence
 */
@Component
@Aspect
@Order(0)
public class LoggingAspect {

    /**
     * This pointcut targets any public method
     */
    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation() {
    }

    // all the advices are ordered, we can define the order of advices
    // While going in the highest precedence will run first, while coming out the highest precedence will run last
    // if no order is defined the order is undefined

    /**
     * This advice will run before any public methods
     */
    @Before("me.upskill.springtutorials.aop.LoggingAspect.anyPublicOperation()")
    public void logMethodEntry(JoinPoint jp) {
        System.out.println("Logging Method Entry ==> " + jp.getSignature().getName());
    }

    /**
     * This advice will run after any public methods are returned successfully (without throwing exceptions)
     */
    @AfterReturning(pointcut = "me.upskill.springtutorials.aop.LoggingAspect.anyPublicOperation()", returning = "val")
    public void logMethodExit(JoinPoint jp, Object val) {
        System.out.println("Successful Method Exit ==> " + jp.getSignature().getName() + " return val ==> " + val);
    }

    /**
     * This advice will run after any public methods throw exceptions
     */
    @AfterThrowing(pointcut = "me.upskill.springtutorials.aop.LoggingAspect.anyPublicOperation()", throwing = "ex")
    public void logMethodFail(JoinPoint jp, Exception ex) {
        System.out.println("Exception Method Exit ==> " + jp.getSignature().getName() + " exception message ==> " + ex.getMessage());
    }

    /**
     * This advice will run after any public methods are run (whether successfully or throws exceptions)
     */
    @After("me.upskill.springtutorials.aop.LoggingAspect.anyPublicOperation()")
    public void logMethodAfter(JoinPoint jp) {
        System.out.println("Either success or fail method Exit ==> " + jp.getSignature().getName());
    }

    /**
     * This advice will wrap around the method execution
     * It is the responsibility of advice to invoke the desired method
     * We can control if we want to invoke the method or not
     */
    @Around("me.upskill.springtutorials.aop.LoggingAspect.anyPublicOperation()")
    public Object logMethodPerformance(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        // this line can throw exception and hence wrap in try catch
        try {
            // calling proceed here without arguments would make the default arguments passed by caller
            // to be passed to callee
            return jp.proceed();
        } finally {
            System.out.println("Time took to execute method ==> " + (System.currentTimeMillis() - start));
        }
    }


    /**
     * Before advice
     * this advice will only match those methods which has 3 arguments
     * one of type string and then 2 of type integers
     * Arguments passed by the caller to the callee will be intercepted by spring
     * and passed to advice method by spring
     * the argNames is used to match the parameter names
     * If there are no methods which match this signature this advice will not apply anywhere
     * NOTE: Where ever this advice is applied the first before advice will also be applied
     * This just filters out only those methods which takes 3 arguments from all the public methods set
     */
    @Before("me.upskill.springtutorials.aop.LoggingAspect.anyPublicOperation() && args(a,b,c)")
    public void logMethodEntryWithArgs(JoinPoint jp, String a, Integer b, Integer c) {
        System.out.println("Method Entry ==> " + jp.getSignature().getName());
        System.out.println("First argument ==> " + a + " Second argument ==> " + b + " third argument ==> " + c);
    }
}
