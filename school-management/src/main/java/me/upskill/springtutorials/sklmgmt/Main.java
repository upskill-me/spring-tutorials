package me.upskill.springtutorials.sklmgmt;

import me.upskill.springtutorials.sklmgmt.webservers.UndertowWebServer;
import me.upskill.springtutorials.sklmgmt.webservers.WebServer;

/**
 * A dummy main class
 */
public class Main {

    /**
     * Fetch the web server to use with this application
     * If you want to use different web server return the corresponding instance from this method
     * The application code needn't change
     *
     * @return the web server instance to use with this application
     */
    private static WebServer fetchWebServer() {
        return new UndertowWebServer();
    }


    /**
     * Main method invoked by jvm
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        WebServer server = fetchWebServer();
        server.start();
    }
}
