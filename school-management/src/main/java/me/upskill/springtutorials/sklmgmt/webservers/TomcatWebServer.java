package me.upskill.springtutorials.sklmgmt.webservers;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.nio.file.Files;

/**
 * Implementation of {@link WebServer} for tomcat embedded web server
 */
public class TomcatWebServer implements WebServer {

    private File createTempDirectory() throws Exception {
        return Files.createTempDirectory(String.format("tomcat-%d", System.currentTimeMillis())).toFile();
    }

    /**
     * Configure the tomcat server for this web application with attendance servlet and start it
     * The default port is 8080
     * <p>
     * In my opinion the apis provided by tomcat to configure a web app is complex
     * in comparison, the apis provided by undertow is very simple and intuitive
     * <p>
     * I don't prefer to use tomcat as embedded server, this code is for reference
     *
     * @throws Exception if any error occurs
     */
    @Override
    public void start() throws Exception {
        Tomcat tomcat = new Tomcat();

        // tomcat needs a base dir, set it to any temp directory
        File baseDir = createTempDirectory();
        tomcat.setBaseDir(baseDir.getAbsolutePath());

        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setThrowOnFailure(true);
        tomcat.getService().addConnector(connector);
        connector.setPort(8080);
        tomcat.setConnector(connector);
        tomcat.getHost().setAutoDeploy(false);

        // next add a context, context is equivalent to a web app
        // this context is available from root
        // empty string is treated as root
        Context ctx = tomcat.addContext("", null);
        // we can use this context object to add any servlets, filters, error pages
        // welcome files etc
        // add the servlet
        Tomcat.addServlet(ctx, "AttendanceServlet",
                "me.upskill.springtutorials.sklmgmt.servlets.AttendanceServlet");

        // add servlet mapping
        ctx.addServletMappingDecoded("/school/classes/x/attendance", "AttendanceServlet");

        tomcat.start();

        System.out.println("Tomcat Embedded Server Started Successfully!");
    }
}
