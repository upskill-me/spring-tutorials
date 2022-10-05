package me.upskill.springtutorials.corebeans.components.email.impl;

import me.upskill.springtutorials.corebeans.components.email.SmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.AwsSesSmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.GoogleSmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.MySmtpSender;

/**
 * Default implementation of smtp sender apis
 */
public class DefaultSmtpSender implements SmtpSender {

    // this bean depends on google, aws ses and my smtp senders, lets add them

    private GoogleSmtpSender googleSmtpSender;

    private AwsSesSmtpSender awsSesSmtpSender;

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

    // getters and setters for properties


    public GoogleSmtpSender getGoogleSmtpSender() {
        return googleSmtpSender;
    }

    public void setGoogleSmtpSender(GoogleSmtpSender googleSmtpSender) {
        this.googleSmtpSender = googleSmtpSender;
    }

    public AwsSesSmtpSender getAwsSesSmtpSender() {
        return awsSesSmtpSender;
    }

    public void setAwsSesSmtpSender(AwsSesSmtpSender awsSesSmtpSender) {
        this.awsSesSmtpSender = awsSesSmtpSender;
    }

    public MySmtpSender getMySmtpSender() {
        return mySmtpSender;
    }

    public void setMySmtpSender(MySmtpSender mySmtpSender) {
        this.mySmtpSender = mySmtpSender;
    }
}
