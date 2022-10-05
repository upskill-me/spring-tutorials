package me.upskill.springtutorials.corebeans.components.email.smtp.impl;

import me.upskill.springtutorials.corebeans.components.email.smtp.AwsSesSmtpSender;

/**
 * Default implementation of the aws ses smtp sender apis
 */
public class DefaultAwsSesSmtpSender implements AwsSesSmtpSender {

    @Override
    public void sendEmail(String to, String subject, String body) {
        // format the message here and log
        String toLogMessage = String.format("Sending email using AWS SES SMTP to [%s]. Email Subject [%s]. Email message Body [%s].",
                to, subject, body);
        System.out.println(toLogMessage);
    }
}
