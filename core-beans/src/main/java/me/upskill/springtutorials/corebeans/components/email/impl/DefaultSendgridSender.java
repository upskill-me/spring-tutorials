package me.upskill.springtutorials.corebeans.components.email.impl;

import me.upskill.springtutorials.corebeans.components.email.SendgridSender;
import org.springframework.stereotype.Component;

/**
 * Default implementation of sendgrid sender apis
 */
@Component
public class DefaultSendgridSender implements SendgridSender {

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendEmail(String to, String subject, String body) {
        // format the message here and log
        String toLogMessage = String.format("Sending email using sendgrid to [%s]. Email Subject [%s]. Email message Body [%s].",
                to, subject, body);
        System.out.println(toLogMessage);
    }
}
