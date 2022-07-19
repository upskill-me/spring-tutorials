package me.upskill.springtutorials;

import org.springframework.stereotype.Component;

/**
 * Since this bean is autowired it needs to be scanned by spring container
 * marking it with @Component so that is will be picked up in component scanning
 */
@Component
public class EmailSender {
}
