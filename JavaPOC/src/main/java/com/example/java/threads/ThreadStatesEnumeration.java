/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads;

/**
 *
 * @author jjagadee
 */
public class ThreadStatesEnumeration {

    public static void main(String[] s) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }

}
