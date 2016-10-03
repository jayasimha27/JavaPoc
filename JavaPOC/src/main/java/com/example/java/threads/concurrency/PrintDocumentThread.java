/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads.concurrency;

import java.util.concurrent.BlockingQueue;

public class PrintDocumentThread implements Runnable {

    BlockingQueue<Document> bqueue;

    public PrintDocumentThread(BlockingQueue<Document> bqueue) {
        this.bqueue = bqueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Document doc = bqueue.take();
                System.out.println(doc.getDocName() + " with id:" + doc.getDocId() + " printed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
