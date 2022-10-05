package me.upskill.springtutorials.corebeans.components;

import me.upskill.springtutorials.corebeans.model.User;

/**
 * Central component which exposes api to send out communications to a specified user
 * The user is expected as method arguments
 */
public interface Communicator {

    /**
     * Communicate with the given user using email
     * When sending out email, spread out the requests to multiple email providers
     *
     * @param user the user
     */
    void communicateViaEmail(User user);

    /**
     * Communicate with the given user via sms
     *
     * @param user the user
     */
    void communicateViaSms(User user);

    /**
     * Communicate with the given user via whatsapp
     *
     * @param user the user
     */
    void communicateViaWhatsapp(User user);

    /**
     * Communicate with the given user via voice call
     *
     * @param user the user
     */
    void communicateViaVoiceCall(User user);
}
