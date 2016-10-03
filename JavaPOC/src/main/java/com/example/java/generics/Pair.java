/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.generics;

/**
 *
 * @author jjagadee
 */
// This program shows the usage of the diamond syntax while using generics
class Pair<T1, T2> {

    T1 object1;
    T2 object2;

    Pair(T1 one, T2 two) {
        object1 = one;
        object2 = two;
    }

    public T1 getFirst() {
        return object1;
    }

    public T2 getSecond() {
        return object2;
    }

    public static void main(String[] args) {
        Pair<Integer, String> worldCup = new Pair<>(2010, "South Africa");
        System.out.println("World cup " + worldCup.getFirst()
                + " in " + worldCup.getSecond());
    }
}
