/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jjagadee
 *
 * Request attributes available to servlet error pages
 * javax.servlet.error.status_code - java.lang.Integer
 * javax.servlet.error.exception_type - java.lang.Class
 * javax.servlet.error.message - java.lang.String javax.servlet.error.exception
 * - java.lang.Throwable javax.servlet.error.request_uri - java.lang.String
 * javax.servlet.error.request_uri - java.lang.String
 * javax.servlet.error.servlet_name - java.lang.String
 *
 */
public class ErrorGen extends HttpServlet {

    protected void processError(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //check the servlet exception
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");

        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Error page</title>");
        out.println("</head>");
        out.println("<body>");

        if (throwable == null) {
            out.println("<h2>The error information is not available</h2>");
            out.println("Please return to the <a href=\""
                    + response.encodeURL("http://localhost:8080/home")
                    + "\">home page</a>.");
        } else {
            out.println("<h2>Here is the error information</h2>");

            out.println(
                    "The servlet name associated with throwing the exception: "
                    + servletName + "<br><br>");

            out.println("The type of exception: "
                    + throwable.getClass().getName() + "<br><br>");

            out.println("The request URI: " + requestUri + "<br><br>");
            out.println("The exception message: " + throwable.getMessage() + "<br>");
            //out.println("The exception message: " + Arrays.toString(throwable.getStackTrace()) + "<br>");
            out.println("Contact Administrator :" + getServletContext().getInitParameter("name") + "<br>");
            out.println("Email :" + getServletContext().getInitParameter("email"));
        }
        out.println("</body>");
        out.println("</html>");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
