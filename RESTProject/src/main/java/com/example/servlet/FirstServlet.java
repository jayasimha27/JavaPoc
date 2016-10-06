/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jjagadee
 */
//@WebServlet(name = "FirstServlet", urlPatterns = {"/firstservlet"})
public class FirstServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FirstServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        //set the MIME type of the response, "text/html"
        response.setContentType("text/html");

        //use a PrintWriter to send text data to the client who has requested the
        //servlet
        java.io.PrintWriter out = response.getWriter();

        //Begin assembling the HTML content
        out.println("<html><head>");

        out.println("<title>Help Page</title></head><body>");
        out.println("<h2>Please submit your information</h2>");

        //make sure method="post" so that the servlet service method
        //calls doPost in the response to this form submit
        out.println(
                "<form method=\"post\" action =\"" + request.getContextPath()
                + "/firstservlet\" >");

        out.println("<table border=\"0\"><tr><td valign=\"top\">");
        out.println("Your first name: </td>  <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"firstname\" size=\"20\">");
        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("Your last name: </td>  <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"lastname\" size=\"20\">");
        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("Your email: </td>  <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"email\" size=\"20\">");
        out.println("</td></tr><tr><td valign=\"top\">");

        out.println("<input type=\"submit\" value=\"Submit Info\"></td></tr>");
        out.println("</table></form>");
        out.println("</body></html>");
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

        //display the parameter names and values
        Enumeration paramNames = request.getParameterNames();

        String parName;//this will hold the name of the parameter

        boolean emptyEnum = false;

        if (!paramNames.hasMoreElements()) {
            emptyEnum = true;
        }

        //set the MIME type of the response, "text/html"
        response.setContentType("text/html");

        //use a PrintWriter to send text data to the client 
        java.io.PrintWriter out = response.getWriter();

        //Begin assembling the HTML content
        out.println("<html><head>");
        out.println("<title>Submitted Parameters</title></head><body>");

        if (emptyEnum) {
            out.println(
                    "<h2>Sorry, the request does not contain any parameters</h2>");
        } else {
            out.println(
                    "<h2>Here are the submitted parameter values</h2>");
        }

        while (paramNames.hasMoreElements()) {

            parName = (String) paramNames.nextElement();

            out.println(
                    "<strong>" + parName + "</strong> : "
                    + request.getParameter(parName));

            out.println("<br />");

        }//while

        out.println("</body></html>");

    }// doPost

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
