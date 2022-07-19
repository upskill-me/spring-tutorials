package me.upskill.springtutorials.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is a configuration class
 * Annotated with Component Scan to indicate to spring to scan everything inside com.example and register any bean definitions
 * if it finds any classes marked with stereotype annotations
 */
@Configuration
@ComponentScan("com.example")
public class AppConfig {
}
