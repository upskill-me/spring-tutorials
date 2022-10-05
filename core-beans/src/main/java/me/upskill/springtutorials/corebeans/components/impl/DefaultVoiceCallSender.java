package me.upskill.springtutorials.corebeans.components.impl;

import me.upskill.springtutorials.corebeans.components.VoiceCallSender;

/**
 * Default implementation of voice call sender apis
 */
public class DefaultVoiceCallSender implements VoiceCallSender {

    @Override
    public void sendVoiceCall(String to, String textToSpeak) {
        // format the message here and log
        String toLogMessage = String.format("Initiating voice call to [%s]. Voice call Text [%s].", to, textToSpeak);
        System.out.println(toLogMessage);
    }
}
