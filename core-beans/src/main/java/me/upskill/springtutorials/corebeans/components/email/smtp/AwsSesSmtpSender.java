package me.upskill.springtutorials.corebeans.components.email.smtp;

/**
 * Exposes apis to send out emails using aws ses smtp server
 */
public interface AwsSesSmtpSender {

    /**
     * Send out an email with the given to address, subject and body
     * Implementations should use aws ses smtp server details to send out emails
     *
     * @param to      the to address
     * @param subject the email subject
     * @param body    the email body
     */
    void sendEmail(String to, String subject, String body);
}
