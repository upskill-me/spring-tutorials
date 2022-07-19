package me.upskill;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        // derive configuration from App config class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // get the user service bean
        UserService service = (UserService) context.getBean("userService");
        service.getName();
        try {
            service.getNameExceptional();
        } catch (Exception ignore) {
        }
        int result = service.argNamesEx("hello world", 10, 20);
        System.out.println("Result of arg names ==> " + result);
    }
}
