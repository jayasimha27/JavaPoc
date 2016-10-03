/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.collections;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jjagadee
 */
public class SpellChecker {

    public static void main(String[] args) {
        Map<String, String> misspeltWords = new HashMap<String, String>();
        misspeltWords.put("calender", "calendar");
        misspeltWords.put("tomatos", "tomatoes");
        misspeltWords.put("existance", "existence");
        misspeltWords.put("aquaintance", "acquaintance");
        String sentence = "Buy a calender for the year 2013";
        System.out.println("The given sentence is: " + sentence);
        for (String word : sentence.split("\\W+")) {
            if (misspeltWords.containsKey(word)) {
                System.out.println("The correct spelling for " + word
                        + " is: " + misspeltWords.get(word));
            }
        }
    }

}
