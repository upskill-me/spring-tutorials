package me.upskill.springtutorials.sklmgmt;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import me.upskill.springtutorials.sklmgmt.servlets.AttendanceServlet;

/**
 * A dummy main class
 */
public class Main {

    private static DeploymentInfo fetchDeploymentInfo() {
        return Servlets.deployment()
                .setClassLoader(Main.class.getClassLoader())
                .setContextPath("/school")
                .setDeploymentName("school.war")
                .addServlet(Servlets.servlet("AttendanceServlet", AttendanceServlet.class)
                        .addMapping("/classes/x/attendance"));
    }


    /**
     * Main method invoked by jvm
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // need to configure the servlet
        DeploymentInfo info = fetchDeploymentInfo();

        DeploymentManager manager = Servlets.defaultContainer().addDeployment(info);
        manager.deploy();

        PathHandler path = Handlers.path(Handlers.redirect("/school"))
                .addPrefixPath("/school", manager.start());

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(path)
                .build();

        server.start();
    }
}
