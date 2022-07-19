package me.upskill.springtutorials;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("me.upskill")
@EnableAspectJAutoProxy
public class AppConfig {
}
