/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

class Main {

    public static void main(String[] args) {
        final ExecutorService service = Executors.newFixedThreadPool(2);
        final BlockingQueue<Document> bqueue = new PriorityBlockingQueue<Document>();
        service.execute(new AddDocumentThread(bqueue));
        service.execute(new PrintDocumentThread(bqueue));
        service.shutdown();
    }
}
