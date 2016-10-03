/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// This program shows the usage of Deque interface

import java.util.*;

class DQueueTest {

    private Deque<String> splQ = new ArrayDeque<>();

    void addInQueue(String customer) {
        splQ.addLast(customer);
    }

    void removeFront() {
        splQ.removeFirst();
    }

    void removeBack() {
        splQ.removeLast();
    }

    void printQueue() {
        System.out.println("Special queue contains: " + splQ);
    }
}

class SplQueueTest {

    public static void main(String[] args) {
        DQueueTest splQ = new DQueueTest();
        splQ.addInQueue("Harrison");
        splQ.addInQueue("McCartney");
        splQ.addInQueue("Starr");
        splQ.addInQueue("Lennon");

        splQ.printQueue();
        splQ.removeFront();
        splQ.removeBack();
        splQ.printQueue();
    }
}
