/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jjagadee
 */
public class ControllerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, java.io.IOException {

        RequestDispatcher dispatcher = null;
        String param = request.getParameter("go");

        if (param == null) {
            throw new ServletException("Missing parameter in Controller.");
        } else if (param.equals("firstservlet")) {
            dispatcher = getServletContext().
                    getNamedDispatcher("FirstServlet");
        } else if (param.equals("SessionMod")) {
            dispatcher = getServletContext().
                    getNamedDispatcher("SessionMod");
        } else if (param.equals("SessionView")) {
            dispatcher = getServletContext().
                    getNamedDispatcher("SessionView");

        } else if (param.equals("SendFile")) {
            dispatcher = getServletContext().
                    getNamedDispatcher("SendFile");
        } else if (param.equals("Header")) {
            dispatcher = getServletContext().
                    getNamedDispatcher("RequestHeaderView");
        } else {
            throw new ServletException(
                    "Improper parameter passed to Controller.");
        }

        /*check for a null dispatcher, then 
         dispatch the request to the correct URL*/
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        } else {
            throw new ServletException("Controller received a null dispatcher.");
        }

    }
}
