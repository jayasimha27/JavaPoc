/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet.listener;

import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author jjagadee
 */
public class MyAppSessionListener implements HttpSessionListener {

    private int sessionCount;

    public MyAppSessionListener() {
        this.sessionCount = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(60);

        //increment the session count
        sessionCount++;
        String id = session.getId();
        Date now = new Date();
        String message = new StringBuffer(
                "New Session created on ").
                append(now.toString()).append("\nID: ").
                append(id).append("\n").append("There are now ").
                append("" + sessionCount).append(
                        " live sessions in the application.").toString();

        System.out.println(message);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        HttpSession session = se.getSession();
        String id = session.getId();
        --sessionCount;//decrement the session count variable
        String message = new StringBuffer("Session destroyed"
                + "\nValue of destroyed session ID is").
                append("" + id).append("\n").append(
                        "There are now ").append("" + sessionCount).append(
                        " live sessions in the application.").toString();
        System.out.println(message);
    }

}
