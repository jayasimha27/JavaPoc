/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jjagadee
 */
public class SchedulerThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService scheduledExecutorService
                = Executors.newScheduledThreadPool(5);
        ScheduledFuture scheduledFuture
                = scheduledExecutorService.schedule(new Callable() {
                    public Object call() throws Exception {
                        System.out.println("Executed!");
                        return "Called!";
                    }
                },
                5,
                TimeUnit.SECONDS);
        System.out.println("result = " + scheduledFuture.get());
        scheduledExecutorService.shutdown();

        ScheduledExecutorService scheduledExecutorService1
                = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService1.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("Executed!");
            }
        }, 5, 5, TimeUnit.SECONDS);
        System.out.println("result = " + scheduledFuture.get());
        scheduledExecutorService1.isShutdown();
    }
}
