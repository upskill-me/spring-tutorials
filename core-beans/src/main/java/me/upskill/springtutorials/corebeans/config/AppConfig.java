package me.upskill.springtutorials.corebeans.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * Root configuration class
 */
@Configuration
@ComponentScan("me.upskill.springtutorials")
public class AppConfig {

    // we don't need manual bean definitions as we will be using component scanning
    // and stereotype annotations

    /**
     * Define a {@link MessageSource} bean
     * The name of the bean must be messageSource
     *
     * @return the {@link MessageSource} bean
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.addBasenames("messages");
        messageSource.setAlwaysUseMessageFormat(true);
        messageSource.setDefaultLocale(Locale.ENGLISH);

        return messageSource;
    }
}
