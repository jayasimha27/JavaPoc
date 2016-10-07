/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.app;

import com.example.spring.java.confiiguration.HelloWorldConfig;
import com.example.spring.java.confiiguration.TextEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author jjagadee
 */
public class JavaConfig {

    public static void main(String[] args) {

        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(HelloWorldConfig.class);

        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);

        helloWorld.setMessage("Hello World!");
        System.out.println("########## Message ######### " + helloWorld.getMessage());

        TextEditor te = ctx.getBean(TextEditor.class);
        te.spellCheck();
    }

}
