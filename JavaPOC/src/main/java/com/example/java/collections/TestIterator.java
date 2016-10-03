/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.collections;

// This program shows the usage of Iterator
import java.util.*;

class TestIterator {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            nums.add(i);
        }
        System.out.println("Original list " + nums);
        Iterator<Integer> numsIter = nums.iterator();
        while (numsIter.hasNext()) {
            numsIter.remove();
        }
        System.out.println("List after removing all elements" + nums);
    }
}
