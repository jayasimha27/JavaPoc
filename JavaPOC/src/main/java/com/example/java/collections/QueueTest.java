/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.collections;

import java.util.LinkedList;
import java.util.Queue;

// This program shows the key characteristics of Queue interface
import java.util.*;

class QueueTest {

    public static void main(String[] args) {
        Queue<String> loginSequence = new LinkedList<String>();

        loginSequence.add("Harrison");
        loginSequence.add("McCartney");
        loginSequence.add("Starr");
        loginSequence.add("Lennon");
        System.out.println("The login sequence is: " + loginSequence);
        while (!loginSequence.isEmpty()) {
            System.out.println("Removing " + loginSequence.remove());
        }
    }
}
