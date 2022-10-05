package me.upskill.springtutorials.corebeans.components.email;

/**
 * Exposes apis to send out email using mailgun service
 */
public interface MailgunSender {

    /**
     * Send out an email with the given to address, subject and body
     * Implementations should use mailgun email service
     *
     * @param to      the to address
     * @param subject the email subject
     * @param body    the email body
     */
    void sendEmail(String to, String subject, String body);
}
