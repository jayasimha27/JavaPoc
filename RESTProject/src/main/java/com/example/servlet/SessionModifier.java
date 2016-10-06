/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet;

import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jjagadee
 */
public class SessionModifier extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, java.io.IOException {

        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Simple Session Tracker</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Session Info</h2>");

        out.println("session ID: " + session.getId() + "<br><br>");

        out.println("The SESSION TIMEOUT period is "
                + session.getMaxInactiveInterval() + " seconds.<br><br>");

        out.println("Now changing it to 20 minutes.<br><br>");

        session.setMaxInactiveInterval(20 * 60);

        out.println("The SESSION TIMEOUT period is now "
                + session.getMaxInactiveInterval() + " seconds.");

        session.setAttribute(session.getId(), "30");
        out.println("</body>");
        out.println("</html>");

    }
}
