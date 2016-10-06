/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet.listener;

import javax.servlet.http.*;

public class SessionAttribListener implements HttpSessionAttributeListener {

    //Creates new SessionAttribListen 
    public SessionAttribListener() {

        System.out.println(getClass().getName());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

        HttpSession session = se.getSession();
        String id = session.getId();
        String name = se.getName();
        String value = (String) se.getValue();
        String source = se.getSource().getClass().getName();
        String message = new StringBuffer(
                "Attribute bound to session in ").append(source).
                append("\nThe attribute name: ").append(name).
                append("\n").append("The attribute value:").
                append(value).append("\n").
                append("The session ID: ").
                append(id).toString();

        System.out.println(message);
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {

        HttpSession session = se.getSession();
        String id = session.getId();
        String name = se.getName();
        if (name == null) {
            name = "Unknown";
        }
        String value = (String) se.getValue();
        String source = se.getSource().getClass().getName();
        String message = new StringBuffer(
                "Attribute unbound from session in ").append(source).
                append("\nThe attribute name: ").append(name).
                append("\n").append("The attribute value: ").
                append(value).append("\n").append(
                        "The session ID: ").append(id).toString();

        System.out.println(message);
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {

        String source = se.getSource().getClass().getName();
        String message = new StringBuffer(
                "Attribute replaced in session  ").
                append(source).toString();
        System.out.println(message);
    }
}
