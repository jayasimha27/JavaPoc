/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jjagadee
 */
public class ThreadPooling {

    public static void main(String[] args) {

        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5000;

        // Single Thread Executor Pool Example
        ExecutorService executeSingleThread = Executors.newSingleThreadExecutor();
        executeSingleThread.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        executeSingleThread.shutdown();
        // Single Thread Executor Pool Example End

        // Fixed Number of Thread Executor Pool Example Start
        ExecutorService fixedPoolexecutorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 25; i++) {
            fixedPoolexecutorService.submit(new MyThread2("Thread" + i));
        }

        fixedPoolexecutorService.shutdown();
        // Fixed Number of Thread Executor Pool Example End

        // Fixed Number of Thread Executor Pool Example with Callback Start
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        List<Future> futureList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            CallableThread callableThread = new CallableThread("Thread" + i);
            Future futureTask = threadPoolExecutor.submit(callableThread);
            futureList.add(futureTask);
        }

        for (Future<String> future : futureList) {
            try {
                String thread = future.get();
                System.out.println("Thread Details : " + thread);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadPooling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(ThreadPooling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        threadPoolExecutor.shutdown();
        // Fixed Number of Thread Executor Pool Example with Callback End
    }

}
