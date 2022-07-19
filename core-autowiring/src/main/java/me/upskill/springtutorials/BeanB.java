package me.upskill.springtutorials;

/**
 * This bean is defined however it is not annotated with Stereotype annotations
 * and hence it will not be picked up while component scanning phase
 */
public class BeanB {

    private Communicator communicator;


    public Communicator getCommunicator() {
        return communicator;
    }


    public void setCommunicator(Communicator communicator) {
        System.out.println("DI - Setting communicator bean ==> " + communicator);
        this.communicator = communicator;
    }
}
