package me.upskill.springtutorials.corebeans.components.impl;

import me.upskill.springtutorials.corebeans.components.Communicator;
import me.upskill.springtutorials.corebeans.components.EmailSender;
import me.upskill.springtutorials.corebeans.components.SmsSender;
import me.upskill.springtutorials.corebeans.components.VoiceCallSender;
import me.upskill.springtutorials.corebeans.components.WhatsappSender;
import me.upskill.springtutorials.corebeans.model.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Default implementation of communicator apis
 */
@Component
public class DefaultCommunicator implements Communicator, InitializingBean, DisposableBean {

    // hardcoding the communications body and subject
    // in reality these would be read from a config file

    /**
     * Hardcoding the email subject
     */
    private static final String EMAIL_SUBJECT = "Hello! Welcome to spring framework tutorials";

    /**
     * Hardcoding the email subject
     */
    private static final String EMAIL_BODY = "This is sent as email. It's very good that you are part of this course. Keep Learning.";

    /**
     * Hardcoding the sms body
     */
    private static final String SMS_BODY = "This is sent as sms. It's very good that you are part of this course. Keep Learning.";

    /**
     * Hardcoding the whatsapp body
     */
    private static final String WHATSAPP_BODY = "This is sent as whatsapp. It's very good that you are part of this course. Keep Learning.";

    /**
     * Hardcoding the voice call body
     */
    private static final String VOICE_CALL_BODY = "This is sent as voice call. It's very good that you are part of this course. Keep Learning.";

    // this is dependent on following components/beans

    /**
     * Email sender subcomponent
     * this class is depending on this component
     * this is Dependency injected by spring
     */
    @Autowired
    private EmailSender emailSender;

    /**
     * sms sender subcomponent
     * this class is depending on this component
     * this is Dependency injected by spring
     */
    @Autowired
    private SmsSender smsSender;

    /**
     * Whatsapp sender subcomponent
     * this class is depending on this component
     * this is Dependency injected by spring
     */
    @Autowired
    private WhatsappSender whatsappSender;

    /**
     * Voice call sender subcomponent
     * this class is depending on this component
     * this is Dependency injected by spring
     */
    @Autowired
    private VoiceCallSender voiceCallSender;

    /**
     * This method will be invoked by spring on main thread
     * do any initialization task here
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // make sure not to run any long running tasks here
        System.out.println("Initialization callback invoked on bean DefaultCommunicator");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void communicateViaEmail(User user) {
        // delegating to sub component
        emailSender.sendEmail(user.getEmail(), EMAIL_SUBJECT, EMAIL_BODY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void communicateViaSms(User user) {
        smsSender.sendSms(user.getMobileNumber(), SMS_BODY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void communicateViaWhatsapp(User user) {
        whatsappSender.sendWhatsapp(user.getMobileNumber(), WHATSAPP_BODY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void communicateViaVoiceCall(User user) {
        voiceCallSender.sendVoiceCall(user.getMobileNumber(), VOICE_CALL_BODY);
    }

    // custom destroy method

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Destruction callback invoked on DefaultCommunication Bean. Destroying communicator bean");
    }
}
