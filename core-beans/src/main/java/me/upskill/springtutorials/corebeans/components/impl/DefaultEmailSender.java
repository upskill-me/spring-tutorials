package me.upskill.springtutorials.corebeans.components.impl;

import me.upskill.springtutorials.corebeans.components.EmailSender;
import me.upskill.springtutorials.corebeans.components.email.MailgunSender;
import me.upskill.springtutorials.corebeans.components.email.SendgridSender;
import me.upskill.springtutorials.corebeans.components.email.SmtpSender;

/**
 * Default implementation of email sender apis
 */
public class DefaultEmailSender implements EmailSender {

    // this bean internally depends on other beans, let us add those here

    /**
     * sendgrid sender bean reference
     * dependency injected by spring
     */
    private SendgridSender sendgridSender;

    /**
     * mailgun sender bean reference
     * dependency injected by spring
     */
    private MailgunSender mailgunSender;

    /**
     * Smtp sender bean reference
     * dependency injected by spring
     */
    private SmtpSender smtpSender;

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

    // getters and setters
    // mandatory so that spring can DI these properties

    public SendgridSender getSendgridSender() {
        return sendgridSender;
    }

    public void setSendgridSender(SendgridSender sendgridSender) {
        this.sendgridSender = sendgridSender;
    }

    public MailgunSender getMailgunSender() {
        return mailgunSender;
    }

    public void setMailgunSender(MailgunSender mailgunSender) {
        this.mailgunSender = mailgunSender;
    }

    public SmtpSender getSmtpSender() {
        return smtpSender;
    }


    public void setSmtpSender(SmtpSender smtpSender) {
        this.smtpSender = smtpSender;
    }
}
