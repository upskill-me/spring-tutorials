package me.upskill.springtutorials.corebeans.components.email;

/**
 * Send out emails using smtp
 */
public interface SmtpSender {

    /**
     * Send out an email with the given to address, subject and body
     * Implementations should use smtp protocol to send out emails
     *
     * @param to      the to address
     * @param subject the email subject
     * @param body    the email body
     */
    void sendEmail(String to, String subject, String body);
}
