package me.upskill.springtutorials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Make this class a component to be eligible for component scanning
 */
@Component
public class Communicator {

    /**
     * Constructor using autowiring
     * NOTE: In any class only one constructor can be declared with @Autowired annotation.
     * All other constructors using @Autowired must use @Autowired required false as shown in this example
     * <p>
     * I don't recommend constructor autowiring as it is not easy to modify if new dependency comes in
     */
    @Autowired
    public Communicator(EmailSender sender, BeanA a) {
        System.out.println("Inside Communicator constructor. Email sender ==> " + sender + " bean A ==> " + a);
    }

    /**
     * Auto wiring on field - uses reflection
     */
    @Autowired
    private EmailSender emailSender;

    /**
     * Bean B doesn't exist in the container
     * This field is marked with Autowired required false - so that spring doesn't throw exception if no bean
     * of type BeanB is present in the container.
     */
    @Autowired(required = false)
    private BeanB beanB;

    /**
     * This field is not marked with autowired to indicate purposefully so as to demonstrate setter method autowiring
     */
    private BeanA beanA;

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Autowired
    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
        System.out.println("Inside Bean A setter method ==> " + beanA);
    }

    /**
     * Auto wiring on random method
     *
     * @param sender the email sender bean
     */
    @Autowired
    public void prepare(EmailSender sender, BeanA beanA) {
        System.out.println("Autowiring on random method with multiple arguments, " +
                "Email sender is ==> " + sender + " bean a is ==> " + beanA);
    }

    public void process() {
        System.out.println("Inside communicator bean, email sender is ==> " + this.emailSender + " bean A is ==> " + this.beanA);
    }
}
