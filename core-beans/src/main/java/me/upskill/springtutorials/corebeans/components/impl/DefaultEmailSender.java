package me.upskill.springtutorials.corebeans.components.impl;

import me.upskill.springtutorials.corebeans.components.EmailSender;
import me.upskill.springtutorials.corebeans.components.email.MailgunSender;
import me.upskill.springtutorials.corebeans.components.email.SendgridSender;
import me.upskill.springtutorials.corebeans.components.email.SmtpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Default implementation of email sender apis
 */
@Component
@Primary
public class DefaultEmailSender implements EmailSender {

    // this bean internally depends on other beans, let us add those here

    /**
     * sendgrid sender bean reference
     * dependency injected by spring
     */
    @Autowired
    private SendgridSender sendgridSender;

    /**
     * mailgun sender bean reference
     * dependency injected by spring
     */
    @Autowired
    private MailgunSender mailgunSender;

    /**
     * Smtp sender bean reference
     * dependency injected by spring
     */
    @Autowired
    private SmtpSender smtpSender;

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendEmail(String to, String subject, String body) {
        int diff = (int) ((Math.random() * Integer.MAX_VALUE) % 3);
        if (diff == 0) {
            sendgridSender.sendEmail(to, subject, body);
        } else if (diff == 1) {
            mailgunSender.sendEmail(to, subject, body);
        } else {
            smtpSender.sendEmail(to, subject, body);
        }
    }
}
