/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.collections;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jjagadee
 */
public class Question {

    private int id;
    private String name;
    private List<String> answers;

    public Question() {
    }

    public Question(int id, String name, List<String> answers) {
        super();
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public void displayInfo() {
        System.out.println(id + " " + name);
        System.out.println("answers are:");
        Iterator<String> itr = answers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
    
}
