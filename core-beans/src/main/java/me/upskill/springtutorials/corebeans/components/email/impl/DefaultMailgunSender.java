package me.upskill.springtutorials.corebeans.components.email.impl;

import me.upskill.springtutorials.corebeans.components.email.MailgunSender;

/**
 * Default implementation of mailgun sender
 */
public class DefaultMailgunSender implements MailgunSender {

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendEmail(String to, String subject, String body) {
        // format the message here and log
        String toLogMessage = String.format("Sending email using mailgun to [%s]. Email Subject [%s]. Email message Body [%s].",
                to, subject, body);
        System.out.println(toLogMessage);
    }
}
