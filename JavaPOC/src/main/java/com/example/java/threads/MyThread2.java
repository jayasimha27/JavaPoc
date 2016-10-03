/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads;

/**
 *
 * @author Jayasimha<jayasimha.jagadeesha@oracle.com>
 */
public class MyThread2 implements Runnable {

    private String threadName;

    public MyThread2() {
    }

    public MyThread2(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        Thread.currentThread().setName(threadName);
        System.out.println("In run method; thread name is: " + Thread.currentThread().getName());
    }

    public static void main(String args[]) throws Exception {
        Thread myThread = new Thread(new MyThread2());
        myThread.start();
        //myThread.run();
        System.out.println("In main method; thread name is: " + Thread.currentThread().getName());
    }
}
