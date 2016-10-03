/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.io.charecter.stream;

import java.io.FileReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 *
 * @author jjagadee
 */
public class PipedReadWrite extends Thread {

    private final PipedReader pr;
    private final PipedWriter pw;

    PipedReadWrite(String name, PipedReader pr, PipedWriter pw) {
        super(name);
        this.pr = pr;
        this.pw = pw;
    }

    @Override
    public void run() {
        try {
            if (getName().equals("Thread 1")) {
                for (int cnt = 0; cnt < 15; cnt++) {
                    pw.write("Thread 1" + cnt + "\n");
                }
                pw.close();

            } else {
                int item;
                while ((item = pr.read()) != -1) {
                    System.out.print((char) item);

                }
                pr.close();

            }

        } catch (IOException e) {

        }

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        
        PipedWriter pw = new PipedWriter();
        PipedReader pr = new PipedReader(pw);
        
        PipedReadWrite prw1=new PipedReadWrite("Thread 1", pr, pw);
        
        PipedReadWrite prw2=new PipedReadWrite("Thread 2", pr, pw);
        
        prw1.start();
        Thread.sleep(2000);
        prw2.start();
        
    }
}
