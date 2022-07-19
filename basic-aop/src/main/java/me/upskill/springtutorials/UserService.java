package me.upskill.springtutorials;

import org.springframework.stereotype.Component;

/**
 * Define a simple user service bean
 * Since we have an aspect pointcut defined that should apply to all the public methods
 * There would be a proxy created for this bean
 */
@Component
public class UserService {

    public String getName() {
        return "Hello World";
    }

    public String getNameExceptional() {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    public int argNamesEx(String a, int b, int c) {
        return b + c;
    }
}
