package me.upskill.springtutorials.corebeans.components;

/**
 * Exposes apis to communicate via whatsapp
 */
public interface WhatsappSender {

    /**
     * Send out whatsapp communication to the specified recipient
     *
     * @param to   the recipient whatsapp number
     * @param body the whatsapp message body
     */
    void sendWhatsapp(String to, String body);
}
