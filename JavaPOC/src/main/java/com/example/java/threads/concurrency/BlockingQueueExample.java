/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author jjagadee
 */
public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        /**
         * ************ Array Blocking Queue Start ******************
         */
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
        queue.put("1");
        String string = queue.take();
        /**
         * ************ Array Blocking Queue End *******************
         */

        /**
         * ************ DelayQueue Start ******************
         */
        DelayQueue dQueue = new DelayQueue();
        Delayed element1 = new DelayElement("Element1", 1000);
        dQueue.put(element1);

        Delayed element2 = new DelayElement("Element2", 1000);
        dQueue.put(element2);

        System.out.println("Compare Delay" + element2.compareTo(element1));
        Delayed element = dQueue.take();
        /**
         * ************ DelayQueue End ******************
         */

        /**
         * ************ LinkedBlockingQueue Start ******************
         */
        BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
        BlockingQueue<String> bounded = new LinkedBlockingQueue<String>(1024);

        bounded.put("Value");

        String value = bounded.take();
        /**
         * ************ LinkedBlockingQueue End ******************
         */

        /**
         * ConcurrentHashMap Start
         */
        ConcurrentMap concurrentMap = new ConcurrentHashMap();
        concurrentMap.put("key", "value");
        Object value1 = concurrentMap.get("key");
        /**
         * ConcurrentHashMap End
         */
    }

}
