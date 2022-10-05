package me.upskill.springtutorials.corebeans.components.email.smtp;

/**
 * Exposes apis to send out smtp email using google as smtp provider
 */
public interface GoogleSmtpSender {

    /**
     * Send out an email with the given to address, subject and body
     * Implementations should use google smtp server details to send out emails
     *
     * @param to      the to address
     * @param subject the email subject
     * @param body    the email body
     */
    void sendEmail(String to, String subject, String body);
}
