package me.upskill.springtutorials.aop.introductions.service;

import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Simple service to demonstrate that introduction advices are applicable to these services
 * as defined by pointcut and {@link DeclareParents}
 */
@Component
public class IService {

    public void process() {
        System.out.println("IService processing started....");
    }
}
