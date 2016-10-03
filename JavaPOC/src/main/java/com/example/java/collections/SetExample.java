/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jjagadee
 */
public class SetExample {

    public static void main(String[] args) {
        treeSet();
    }

    private static void hashSet() {

        String tongueTwister = "I feel, a feel, a funny feel, a funny feel I feel,if you feel the feel  I feel, I feel the feel you feel";
        Set<String> words = new HashSet<>();

        // split the sentence into words and try putting them in the set
        for (String word : tongueTwister.split("\\W+")) {
            words.add(word);
        }

        System.out.println("The tongue twister is: " + tongueTwister);
        System.out.print("The words used were: ");
        System.out.println(words);

    }

    private static void treeSet() {
        String pangram = "the quick brown fox jumps over the lazy dog";
        Set<Character> aToZee = new TreeSet<Character>();
        for (char gram : pangram.toCharArray()) {
            aToZee.add(gram);
        }
        System.out.println("The pangram is: " + pangram);
        System.out.print("Sorted pangram characters are: " + aToZee);
    }

}
