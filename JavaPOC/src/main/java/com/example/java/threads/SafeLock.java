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
public class SafeLock {

    public static void main(String args[]) throws InterruptedException {
        Scorer c = new Scorer();
        // create two threads and start them at the same time
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
        System.out.println("Waiting for threads to complete execution. . .");
        t2.join();
        System.out.println("Done.");
    }

}
