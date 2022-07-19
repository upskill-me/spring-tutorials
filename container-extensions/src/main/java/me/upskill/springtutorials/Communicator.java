package me.upskill.springtutorials;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Make this class a component to be eligible for component scanning
 */
public class Communicator {

    /**
     * Auto wiring on field - uses reflection
     */
    @Autowired
    private EmailSender emailSender;

    public void process() {
        System.out.println("Inside communicator bean, email sender is ==> " + this.emailSender);
    }
}
