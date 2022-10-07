package me.upskill.springtutorials.corebeans;

import me.upskill.springtutorials.corebeans.components.Communicator;
import me.upskill.springtutorials.corebeans.config.AppConfig;
import me.upskill.springtutorials.corebeans.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main entry point class of the application
 */
public class Main {


    /**
     * Entry point for the application
     * JVM invokes this method
     *
     * @param args the command line arguments
     * @throws Exception if any error occurs, pass it to JVM
     */
    public static void main(String[] args) throws Exception {
        // instantiate application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // comment the above line and uncomment below line if want to use xml configuration
        // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // get communicator bean

        ((AbstractApplicationContext) context).registerShutdownHook();

        Communicator communicator = context.getBean("communicator", Communicator.class);
        // read inputs from console
        // making sure that streams are auto closed as program exists
        // always a good practice
        try (InputStreamReader ir = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(ir)) {
            // read 10 inputs
            for (int i = 0; i < 10; i++) {
                String[] inputs = br.readLine().split(" ");
                // using user object to pass the values to communicator apis
                if ("email".equalsIgnoreCase(inputs[0])) {
                    communicator.communicateViaEmail(new User(inputs[1], null));
                } else if ("sms".equalsIgnoreCase(inputs[0])) {
                    communicator.communicateViaSms(new User(null, inputs[1]));
                } else if ("whatsapp".equalsIgnoreCase(inputs[0])) {
                    communicator.communicateViaWhatsapp(new User(null, inputs[1]));
                } else if ("voicecall".equalsIgnoreCase(inputs[0])) {
                    communicator.communicateViaVoiceCall(new User(null, inputs[1]));
                } else {
                    // any other input throw error
                    throw new RuntimeException("invalid communication type");
                }
            }
        }

        System.out.println("Demo complete. Thank you. Keep learning.");
    }
}
