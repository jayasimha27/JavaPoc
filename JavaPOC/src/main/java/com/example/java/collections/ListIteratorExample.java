/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author jjagadee
 */
public class ListIteratorExample {

    public static void main(String[] args) {
        String palStr = "abcba";
        List<Character> palindrome = new LinkedList<Character>();

        for (char ch : palStr.toCharArray()) {
            palindrome.add(ch);
        }

        System.out.println("Input string is: " + palStr);
        ListIterator<Character> iterator = palindrome.listIterator();
        ListIterator<Character> revIterator = palindrome.listIterator(palindrome.size());

        boolean result = true;
        while (revIterator.hasPrevious() && iterator.hasNext()) {
            if (iterator.next() != revIterator.previous()) {
                result = false;
                break;
            }
        }
        if (result) {
            System.out.print("Input string is a palindrome");
        } else {
            System.out.print("Input string is not a palindrome");
        }
    }

}
