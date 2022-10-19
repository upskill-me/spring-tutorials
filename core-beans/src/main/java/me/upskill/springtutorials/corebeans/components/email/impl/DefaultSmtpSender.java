package me.upskill.springtutorials.corebeans.components.email.impl;

import me.upskill.springtutorials.corebeans.components.email.SmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.AwsSesSmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.GoogleSmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.MySmtpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Default implementation of smtp sender apis
 */
@Component
public class DefaultSmtpSender implements SmtpSender {

    // this bean depends on google, aws ses and my smtp senders, lets add them

    @Autowired
    private GoogleSmtpSender googleSmtpSender;

    @Autowired
    private AwsSesSmtpSender awsSesSmtpSender;

    @Autowired
    private MySmtpSender mySmtpSender;

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendEmail(String to, String subject, String body) {
        // make random choice to send out emails using 3 providers
        // using same logic as email sender
        int diff = (int) ((Math.random() * Integer.MAX_VALUE) % 3);
        if (diff == 0) {
            googleSmtpSender.sendEmail(to, subject, body);
        } else if (diff == 1) {
            awsSesSmtpSender.sendEmail(to, subject, body);
        } else {
            mySmtpSender.sendEmail(to, subject, body);
        }
    }
}
