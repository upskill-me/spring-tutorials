package me.upskill.springtutorials.sklmgmt.webservers;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Implementation of {@link WebServer} for jetty embedded web server
 */
public class JettyWebServer implements WebServer {

    /**
     * Configure and start a jetty web server
     *
     * @throws Exception if any error occurs
     */
    @Override
    public void start() throws Exception {
        // create server
        Server server = new Server();

        // configure connectors
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);

        // configure servlet handlers
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);

        // add servlets
        handler.addServlet("me.upskill.springtutorials.sklmgmt.servlets.AttendanceServlet",
                "/school/classes/x/attendance");

        connector.start();
        server.start();
        System.out.println("Jetty Embedded Server Started Successfully!");
    }
}
