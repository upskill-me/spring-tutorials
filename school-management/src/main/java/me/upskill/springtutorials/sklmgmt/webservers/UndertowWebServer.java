package me.upskill.springtutorials.sklmgmt.webservers;

import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import me.upskill.springtutorials.sklmgmt.Main;
import me.upskill.springtutorials.sklmgmt.servlets.AttendanceServlet;

/**
 * Implementation of web server for undertow embedded web server
 * In comparision to tomcat the apis provided by undertow are very simple
 */
public class UndertowWebServer implements WebServer {

    private DeploymentInfo fetchDeploymentInfo() {
        return Servlets.deployment()
                .setClassLoader(Main.class.getClassLoader())
                .setContextPath("/")
                .setDeploymentName("school.war")
                .addServlet(Servlets.servlet("AttendanceServlet", AttendanceServlet.class)
                        .addMapping("/school/classes/x/attendance"));
    }

    /**
     * configure and start the undertow web server
     * <p>
     * In my opinion the apis provided by undertow are simple and intuitive
     * It's very easy to configure a servlet application programmatically
     *
     * @throws Exception if any error occurs
     */
    @Override
    public void start() throws Exception {
        // need to configure the servlet
        DeploymentInfo info = fetchDeploymentInfo();

        DeploymentManager manager = Servlets.defaultContainer().addDeployment(info);
        manager.deploy();

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(manager.start())
                .build();

        server.start();

        System.out.println("Undertow Embedded Server Started Successfully!");
    }
}
