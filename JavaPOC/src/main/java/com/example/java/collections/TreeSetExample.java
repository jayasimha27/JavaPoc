/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jjagadee
 */
public class TreeSetExample {

    public static void main(String[] args) {
        String pangram = "the quick brown fox jumps over the lazy dog";
        Set<Character> aToZee = new TreeSet<Character>();
        for (char gram : pangram.toCharArray()) {
            aToZee.add(gram);
        }
        System.out.println("The pangram is: " + pangram);
        System.out.print("Sorted pangram characters are: " + aToZee);
    }

}
