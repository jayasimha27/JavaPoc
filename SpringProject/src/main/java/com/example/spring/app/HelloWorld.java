/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.app;

import com.example.spring.util.SpringBeanFactory;

public class HelloWorld {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {

        HelloWorld helloWorld = (HelloWorld) SpringBeanFactory.getInstance().getBean("helloWorld");
        System.out.println("Message ## :" + helloWorld.getMessage());
    }
}
