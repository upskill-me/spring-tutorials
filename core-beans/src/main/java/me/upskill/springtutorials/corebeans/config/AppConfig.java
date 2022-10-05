package me.upskill.springtutorials.corebeans.config;

import me.upskill.springtutorials.corebeans.components.Communicator;
import me.upskill.springtutorials.corebeans.components.EmailSender;
import me.upskill.springtutorials.corebeans.components.SmsSender;
import me.upskill.springtutorials.corebeans.components.VoiceCallSender;
import me.upskill.springtutorials.corebeans.components.WhatsappSender;
import me.upskill.springtutorials.corebeans.components.email.MailgunSender;
import me.upskill.springtutorials.corebeans.components.email.SendgridSender;
import me.upskill.springtutorials.corebeans.components.email.SmtpSender;
import me.upskill.springtutorials.corebeans.components.email.impl.DefaultMailgunSender;
import me.upskill.springtutorials.corebeans.components.email.impl.DefaultSendgridSender;
import me.upskill.springtutorials.corebeans.components.email.impl.DefaultSmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.AwsSesSmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.GoogleSmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.MySmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.impl.DefaultAwsSesSmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.impl.DefaultGoogleSmtpSender;
import me.upskill.springtutorials.corebeans.components.email.smtp.impl.DefaultMySmtpSender;
import me.upskill.springtutorials.corebeans.components.impl.DefaultCommunicator;
import me.upskill.springtutorials.corebeans.components.impl.DefaultEmailSender;
import me.upskill.springtutorials.corebeans.components.impl.DefaultSmsSender;
import me.upskill.springtutorials.corebeans.components.impl.DefaultVoiceCallSender;
import me.upskill.springtutorials.corebeans.components.impl.DefaultWhatsappSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Root configuration class
 */
@Configuration
public class AppConfig {

    /**
     * Create bean of communicator
     * these arguments are injected by spring
     *
     * @param eSender the email sender bean object
     * @param sSender the sms sender bean object
     * @param wSender the whatsapp sender bean object
     * @param vSender the voice call sender bean object
     */
    @Bean
    public Communicator communicator(EmailSender eSender, SmsSender sSender, WhatsappSender wSender, VoiceCallSender vSender) {
        DefaultCommunicator communicator = new DefaultCommunicator();
        communicator.setEmailSender(eSender);
        communicator.setSmsSender(sSender);
        communicator.setWhatsappSender(wSender);
        communicator.setVoiceCallSender(vSender);

        return communicator;
    }

    /**
     * Create bean object of Email sender implementation
     *
     * @param sSender  the sendgrid sender bean object
     * @param mSender  the mailgun sender bean object
     * @param smSender the smtp sender bean object
     * @return the email sender bean object to be managed by spring
     */
    @Bean
    public EmailSender emailSender(SendgridSender sSender, MailgunSender mSender, SmtpSender smSender) {
        DefaultEmailSender defaultEmailSender = new DefaultEmailSender();
        defaultEmailSender.setMailgunSender(mSender);
        defaultEmailSender.setSendgridSender(sSender);
        defaultEmailSender.setSmtpSender(smSender);

        return defaultEmailSender;
    }

    /**
     * Create instance of sendgrid sender bean
     * this object is managed by spring ioc container
     *
     * @return the sendgrid sender bean object
     */
    @Bean
    public SendgridSender sendgridSender() {
        return new DefaultSendgridSender();
    }

    /**
     * Create instance of mailgun sender bean
     * this object is managed by spring ioc container
     *
     * @return the mailgun sender bean object
     */
    @Bean
    public MailgunSender mailgunSender() {
        return new DefaultMailgunSender();
    }

    /**
     * Create instance of smtp sender bean
     * this object is managed by spring ioc container
     * the dependencies are injected by spring
     *
     * @param gSender google smtp sender bean instance
     * @param aSender aws ses smtp sender bean instance
     * @param mSender my smtp sender bean instance
     * @return smtp sender bean object to be managed by spring
     */
    @Bean
    public SmtpSender smtpSender(GoogleSmtpSender gSender, AwsSesSmtpSender aSender, MySmtpSender mSender) {
        DefaultSmtpSender smtpSender = new DefaultSmtpSender();
        smtpSender.setMySmtpSender(mSender);
        smtpSender.setGoogleSmtpSender(gSender);
        smtpSender.setAwsSesSmtpSender(aSender);

        return smtpSender;
    }

    /**
     * Create instance of google smtp sender bean
     * this object is managed by spring ioc container
     *
     * @return the google smtp sender bean object
     */
    @Bean
    public GoogleSmtpSender googleSmtpSender() {
        return new DefaultGoogleSmtpSender();
    }

    /**
     * Create instance of aws ses smtp sender bean
     * this object is managed by spring ioc container
     *
     * @return the aws ses smtp sender bean object
     */
    @Bean
    public AwsSesSmtpSender awsSesSmtpSender() {
        return new DefaultAwsSesSmtpSender();
    }

    /**
     * Create instance of my smtp sender bean
     * this object is managed by spring ioc container
     *
     * @return the my smtp sender bean object
     */
    @Bean
    public MySmtpSender mySmtpSender() {
        return new DefaultMySmtpSender();
    }

    /**
     * Create instance of sms sender bean
     * this object is managed by spring ioc container
     *
     * @return the sms sender bean object
     */
    @Bean
    public SmsSender smsSender() {
        return new DefaultSmsSender();
    }

    /**
     * Create instance of whatsapp sender bean
     * this object is managed by spring ioc container
     *
     * @return the whatsapp sender bean object
     */
    @Bean
    public WhatsappSender whatsappSender() {
        return new DefaultWhatsappSender();
    }

    /**
     * Create instance of voice call sender bean
     * this object is managed by spring ioc container
     *
     * @return the voice call sender bean object
     */
    @Bean
    public VoiceCallSender voiceCallSender() {
        return new DefaultVoiceCallSender();
    }
}
