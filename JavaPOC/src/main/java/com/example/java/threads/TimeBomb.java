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
public class TimeBomb extends Thread {

    String[] timeStr = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    public void run() {
        for (int i = 9; i >= 0; i--) {
            try {
                System.out.println(timeStr[i]);
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("Boom!!!");
        
    }

    public static void main(String[] s) {
        TimeBomb timer = new TimeBomb();
        timer.start();;
        System.out.println("Starting 10 second count down. . . ");
        
    }

}
