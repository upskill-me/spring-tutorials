package me.upskill.springtutorials;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // accessing this will return the communicator bean
        Communicator communicator = (Communicator) context.getBean("communicator");
        System.out.println("In Main Method Got Communicator Bean ==> " + communicator);
        communicator.process();

        // accessing this will return the communicator factory bean
        CommunicatorFactory communicatorF = (CommunicatorFactory) context.getBean("&communicator");
        System.out.println("Communicator factory bean ==> " + communicatorF);
    }
}
