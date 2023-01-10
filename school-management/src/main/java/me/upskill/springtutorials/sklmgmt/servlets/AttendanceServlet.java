package me.upskill.springtutorials.sklmgmt.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Servlet to handle http requests for attendance records
 * and create attendance records
 * <p>
 * // data structure used is in memory data structure
 * <p>
 * student has properties
 * name, age, class, section, roll no
 * <p>
 * use roll no and present/absent combination
 * <p>
 * roll no --> present/absent
 * <p>
 * map is a good data structure to store key value pairs
 */
public class AttendanceServlet extends HttpServlet {

    private final Map<Integer, Boolean> attendanceRecords;

    /**
     * Default constructor,
     * init data structure
     */
    public AttendanceServlet() {
        this.attendanceRecords = new ConcurrentHashMap<>();
    }

    /**
     * Serialize the passed map as a string
     *
     * @param records the records
     * @return the string value
     */
    private String serializeAttendanceRecords(Map<Integer, Boolean> records) {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<Integer, Boolean> record : records.entrySet()) {
            String keyPart = String.format("\"%d\"", record.getKey());
            String valuePart = String.format("\"%b\"", record.getValue());

            sb.append(keyPart);
            sb.append(":");
            sb.append(valuePart);
            sb.append(",");
        }

        if (!attendanceRecords.isEmpty()) {
            // the last command needs to be removed
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("}");
        return sb.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // first thing to do is serialize the attendanceRecords map
        // either use toString() or custom serialization logic
        String records = serializeAttendanceRecords(this.attendanceRecords);
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(records);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rollNo = req.getParameter("rollNo");

        if (rollNo == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "roll no is mandatory");
            return;
        }

        // roll no must be integer
        try {
            int iRollNo = Integer.parseInt(rollNo);
            boolean att = "true".equalsIgnoreCase(req.getParameter("attendance"));

            // store in map
            this.attendanceRecords.put(iRollNo, att);

            resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
            resp.setContentType("text/html");
            resp.setStatus(HttpServletResponse.SC_OK);

            // write the "success" string
            resp.getWriter().println("success");
        } catch (NumberFormatException nfe) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "roll no must be integer");
        }
    }
}
