/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.java.confiiguration;

import com.example.spring.app.HelloWorld;
import org.springframework.context.annotation.*;

@Configuration
public class HelloWorldConfig {

    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

    @Bean
    public TextEditor textEditor() {
        return new TextEditor(spellChecker());
    }

    //@Bean(initMethod = "init", destroyMethod = "cleanup")
    @Scope("prototype")
    public SpellChecker spellChecker() {
        return new SpellChecker();
    }
}
