package me.upskill.springtutorials.corebeans.components.impl;

import me.upskill.springtutorials.corebeans.components.SmsSender;
import org.springframework.stereotype.Component;

/**
 * Default implementation of sms sender apis
 */
@Component
public class DefaultSmsSender implements SmsSender {

    @Override
    public void sendSms(String to, String body) {
        // format the message here and log
        String toLogMessage = String.format("Sending sms to [%s]. Sms Body [%s]", to, body);
        System.out.println(toLogMessage);
    }
}
