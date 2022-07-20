package me.upskill.springtutorials;

import me.upskill.springtutorials.aop.introductions.service.IService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean isXMLConfig = false;
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

        if (isXMLConfig) {
            // xml aop config
            XMLUserService xmlService = (XMLUserService) context.getBean("xmlUserService");
            xmlService.doProcessing();
        }

        // fetch the introduction bean to which introductions are applied
        IService iService = (IService) context.getBean("IService");
        iService.process();
    }
}
