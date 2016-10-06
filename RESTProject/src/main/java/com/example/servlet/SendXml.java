/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class SendXml extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {

        //get the filename from the "file" parameter
        String fileName = "sample.xml";

        // add the .xml suffix if it doesn't already exist
        if (fileName.indexOf(".xml") == -1) {
            fileName = fileName + ".xml";
        }

        //where are XML files kept
        String xmlDir = getServletContext().getInitParameter("xml-dir");
        if (xmlDir == null || xmlDir.equals("")) {
            throw new ServletException(
                    "Invalid or non-existent xmlDir context-param.");
        }

        ServletOutputStream stream = null;
        BufferedInputStream buf = null;

        try {

            stream = response.getOutputStream();
            File xml = new File(xmlDir + fileName);
            //set response headers
            response.setContentType("text/xml");

            response.addHeader(
                    "Content-Disposition", "attachment; filename=" + fileName);

            response.setContentLength((int) xml.length());

            FileInputStream input = new FileInputStream(xml);
            buf = new BufferedInputStream(input);
            int readBytes = 0;

            //read from the file; write to the ServletOutputStream
            while ((readBytes = buf.read()) != -1) {
                stream.write(readBytes);
            }

        } catch (IOException ioe) {

            throw new ServletException(ioe.getMessage());

        } finally {

            //close the input/output streams
            if (stream != null) {
                stream.close();
            }

            if (buf != null) {
                buf.close();
            }

        }//finally

    } //end doGet

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
