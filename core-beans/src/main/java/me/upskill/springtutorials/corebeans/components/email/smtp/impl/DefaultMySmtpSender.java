package me.upskill.springtutorials.corebeans.components.email.smtp.impl;

import me.upskill.springtutorials.corebeans.components.email.smtp.MySmtpSender;
import org.springframework.stereotype.Component;

/**
 * Default implementation of my smtp sender
 */
@Component
public class DefaultMySmtpSender implements MySmtpSender {

    @Override
    public void sendEmail(String to, String subject, String body) {
        // format the message here and log
        String toLogMessage = String.format("Sending email using my SMTP to [%s]. Email Subject [%s]. Email message Body [%s].",
                to, subject, body);
        System.out.println(toLogMessage);
    }
}
