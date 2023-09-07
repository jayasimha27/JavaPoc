/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jjagadee
 */
public class GenericMethod {

    public static <T> void fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, val);
        }
    }

    public static void main(String[] args) {
        
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        System.out.println("The original list is: " + intList);
        GenericMethod.fill(intList,100);
        System.out.println("The list after calling Utilities.fill() is: " + intList);
        
        List<String> stringList = new ArrayList<>();
        stringList.add("10");
        stringList.add("20");
        System.out.println("The original list is: " + stringList);
        GenericMethod.fill(stringList,"100");
        System.out.println("The list after calling Utilities.fill() is: " + intList);
    }

}
