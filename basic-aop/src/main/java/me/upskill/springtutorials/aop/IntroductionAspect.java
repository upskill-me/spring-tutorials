package me.upskill.springtutorials.aop;

import me.upskill.springtutorials.aop.introductions.DefaultLogTracking;
import me.upskill.springtutorials.aop.introductions.Tracked;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * This is an aspect example which introduces Introduction advices
 */
@Component
@Aspect
public class IntroductionAspect {

    /**
     * This should apply to all the services in introductions package
     * Introductions are declared using @DeclareParents annotation
     * The value indicates the type pattern - all the matching classes with this type pattern will be considered
     * default impl is the default implementation of the interface.
     * Outcome - Any classes that matches the filter condition will implement this Tracked interface
     */
    @DeclareParents(value = "me.upskill.springtutorials.aop.introductions.service.*", defaultImpl = DefaultLogTracking.class)
    public static Tracked mixin;


    /**
     * all the calls to the methods of the matching classes are intercepted and this before advice will be called
     * for each one of them, we are expecting the bean itself as the argument parameter
     * Apply to any class within the service package and which is of type Tracked
     */
    @Before("within(me.upskill.springtutorials.aop.introductions.service.IService) && this(tracked)")
    public void logMethodUsage(JoinPoint jp, Tracked tracked) {
        tracked.track();
    }
}
