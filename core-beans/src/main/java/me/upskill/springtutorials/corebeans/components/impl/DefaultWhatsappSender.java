package me.upskill.springtutorials.corebeans.components.impl;

import me.upskill.springtutorials.corebeans.components.WhatsappSender;
import org.springframework.stereotype.Component;

/**
 * Default implementation of whatsapp sender apis
 */
@Component
public class DefaultWhatsappSender implements WhatsappSender {

    @Override
    public void sendWhatsapp(String to, String body) {
        // format the message here and log
        String toLogMessage = String.format("Sending whatsapp to [%s]. Whatsapp message Body [%s].", to, body);
        System.out.println(toLogMessage);
    }
}
