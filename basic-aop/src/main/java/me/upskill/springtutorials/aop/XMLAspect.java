package me.upskill.springtutorials.aop;

import org.aspectj.lang.JoinPoint;

public class XMLAspect {

    public void before(JoinPoint jp) throws Throwable {
        System.out.println("XML Aspect Method Before Advice Called with arguments ==> " + jp.getArgs());
    }
}
