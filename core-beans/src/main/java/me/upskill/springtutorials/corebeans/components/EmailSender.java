package me.upskill.springtutorials.corebeans.components;

/**
 * Exposes apis to send out email communication
 */
public interface EmailSender {

    /**
     * Send out an email with the given to address, subject and body
     *
     * @param to      the to address
     * @param subject the email subject
     * @param body    the email body
     */
    void sendEmail(String to, String subject, String body);
}
