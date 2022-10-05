package me.upskill.springtutorials.corebeans.components;

/**
 * exposes apis to Send communication using voice call
 */
public interface VoiceCallSender {

    /**
     * Send out a voice call communication
     * the text to speech will be spoken out by a robot
     *
     * @param to          the to recipient address
     * @param textToSpeak the message to deliver
     */
    void sendVoiceCall(String to, String textToSpeak);
}
