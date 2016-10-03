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
public class AsyncThread extends Thread {

    public void run() {
        System.out.println("Starting the thread " + getName());
        for (int i = 0; i < 3; i++) {
            System.out.println("In thread " + getName() + "; iteration " + i);
            try {
                // sleep for sometime before the next iteration
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                // we're not interrupting any threads
                // – so safe to ignore this exeception
                ie.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        AsyncThread asyncThread1 = new AsyncThread();
        AsyncThread asyncThread2 = new AsyncThread();
        // start both the threads around the same time
        asyncThread1.start();
        asyncThread2.start();
    }

}
