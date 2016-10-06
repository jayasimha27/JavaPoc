/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet.listener;

import javax.servlet.*;
import javax.servlet.http.*;

public class RequestListener implements ServletRequestListener {

    private static long reqCount;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        //used for logging purposes
        ServletContext context = sre.getServletContext();

        //Used to get information about a new request
        ServletRequest request = sre.getServletRequest();

        //The static class variable reqCount is incremented in this block;
        //the incrementing of the variable is synchronized so that one
        // thread is not reading the variable while another increments it
        synchronized (context) {

            context.log(
                    "Request for "
                    + (request instanceof HttpServletRequest
                            ? ((HttpServletRequest) request).getRequestURI()
                            : "Unknown") + "; Count=" + ++reqCount);
            System.out.println("########### Total Servlet Request Count ##########  " + reqCount);

        }//synchronized

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        //Called when the servlet request is going oout of scope.
    }//requestDestroyed

}
