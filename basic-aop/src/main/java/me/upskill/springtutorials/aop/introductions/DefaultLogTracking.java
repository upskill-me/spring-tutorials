package me.upskill.springtutorials.aop.introductions;

public class DefaultLogTracking implements Tracked {

    @Override
    public void track() {
        System.out.println("Log tracking started");
    }
}
