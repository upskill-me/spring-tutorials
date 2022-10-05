package me.upskill.springtutorials.corebeans.components.email;

/**
 * Send out email using sendgrid
 */
public interface SendgridSender {

    /**
     * Send out an email with the given to address, subject and body
     * Implementations should use sendgrid email service
     *
     * @param to      the to address
     * @param subject the email subject
     * @param body    the email body
     */
    void sendEmail(String to, String subject, String body);
}
