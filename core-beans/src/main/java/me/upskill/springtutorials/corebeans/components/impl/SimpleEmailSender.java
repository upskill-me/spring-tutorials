package me.upskill.springtutorials.corebeans.components.impl;

import me.upskill.springtutorials.corebeans.components.EmailSender;
import org.springframework.stereotype.Component;

/**
 * Simple implementation of email sender
 * this doesn't delegate to multiple email providers
 * demonstrating auto wiring ambiguity and use of primary or qualifier
 */
@Component
public class SimpleEmailSender implements EmailSender {

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendEmail(String to, String subject, String body) {
        // format the message here and log
        String toLogMessage = String.format("Sending email using Simple Email Sender to [%s]. Email Subject [%s]. Email message Body [%s].",
                to, subject, body);
        System.out.println(toLogMessage);
    }
}
