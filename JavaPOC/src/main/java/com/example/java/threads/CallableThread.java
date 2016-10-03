/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads;

import java.util.concurrent.Callable;

/**
 *
 * @author jjagadee
 */
public class CallableThread implements Callable<String> {

    private String threadName;

    public CallableThread() {
    }

    public CallableThread(String threadName) {
        this.threadName = threadName;

    }

    @Override
    public String call() throws Exception {
        Thread.currentThread().setName(threadName);
        return "Im An Executed Thread With Name : " + threadName;
    }

}
