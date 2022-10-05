package me.upskill.springtutorials.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is a configuration class
 * Annotated with Component Scan to indicate to spring to scan everything inside me.upskill and register any bean definitions
 * if it finds any classes marked with stereotype annotations
 */
@Configuration
@ComponentScan("me.upskill")
public class AppConfig {
}
