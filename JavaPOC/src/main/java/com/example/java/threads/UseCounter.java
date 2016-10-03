/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads;

// This class implements Runnable interface
// Its run method increments the counter three times
class UseCounter implements Runnable {

    public void increment() {
        // increments the counter and prints the value
        // of the counter shared between threads
        synchronized (this) {
            Counter.count++;
            System.out.print(Counter.count + "  ");
        }

    }

    public void run() {
        increment();
        increment();
        increment();
    }
}
