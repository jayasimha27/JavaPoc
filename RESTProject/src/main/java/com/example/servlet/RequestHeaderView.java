/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet;

import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestHeaderView extends HttpServlet {

  public void doGet(HttpServletRequest request, 
    HttpServletResponse response) throws ServletException,
      java.io.IOException {
    
      //get an Enumeration of all the request header names
      Enumeration enm = request.getHeaderNames();
    
      response.setContentType("text/html");
      java.io.PrintWriter out = response.getWriter( );
      out.println(
          "<html><head><title>Request Header View</title></head><body>");
      out.println("<h2>Request Headers</h2>");

      String header = null;

      //display each request header name and value  
      while (enm.hasMoreElements( )){
          header = (String) enm.nextElement( );

      //getHeader returns null if a request header of that name does not
      //exist in the request
      out.println("<strong>"+header+"</strong>"+": "+
          request.getHeader(header)+"<br>" );
      }
    
      out.println("</body></html>");
  } //doGet
}