package me.upskill.springtutorials.corebeans.components.email.smtp.impl;

import me.upskill.springtutorials.corebeans.components.email.smtp.GoogleSmtpSender;

/**
 * Default implementation of google smtp sender
 */
public class DefaultGoogleSmtpSender implements GoogleSmtpSender {

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendEmail(String to, String subject, String body) {
        // format the message here and log
        String toLogMessage = String.format("Sending email using Google SMTP to [%s]. Email Subject [%s]. Email message Body [%s].",
                to, subject, body);
        System.out.println(toLogMessage);
    }
}
