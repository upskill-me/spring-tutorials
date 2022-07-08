package com.example.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Communicator communicator = (Communicator) context.getBean("communicator");
        System.out.println("In Main Method Got Communicator Bean ==> " + communicator);
        communicator.process();
    }
}
