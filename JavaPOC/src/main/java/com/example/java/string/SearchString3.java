/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.string;

// This example demonstrates how to search multiple occurences of a search string
public class SearchString3 {
        public static void main(String[] s) {
                String str = "I am a software porfessional. I am in Java Training Program";
                int fromIndex = 0;
                while(str.indexOf("am", fromIndex) > -1) {
                        fromIndex = str.indexOf("am", fromIndex);
                        System.out.println("Substring \"am\" occurs at index: " + fromIndex);
                        fromIndex++;
                }
        }
}
