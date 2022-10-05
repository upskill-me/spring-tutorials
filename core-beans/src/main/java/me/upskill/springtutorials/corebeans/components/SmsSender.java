package me.upskill.springtutorials.corebeans.components;

/**
 * Exposes apis to send out sms communication
 */
public interface SmsSender {

    /**
     * Send out the sms to the specified recipient as to argument
     *
     * @param to   the recipient mobile number
     * @param body the sms body
     */
    void sendSms(String to, String body);
}
