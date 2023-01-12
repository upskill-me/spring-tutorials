package me.upskill.springtutorials.sklmgmt.webservers;

/**
 * Define apis to interact with multiple web servers
 */
public interface WebServer {

    /**
     * Configure and start a web server
     *
     * @throws Exception if any error occurs
     */
    void start() throws Exception;
}
