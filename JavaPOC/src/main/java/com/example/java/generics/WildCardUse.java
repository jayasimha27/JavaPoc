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
// This program demonstrates the usage of wild card parameters
class WildCardUse {

    static void printList(List<?> list) {
        for (Object l : list) {
            System.out.println("[" + l + "]");
        }
    }

    public static void main(String[] args) {
        
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(100);
        printList(integerList);
        
        List<String> strList = new ArrayList<>();
        strList.add("10");
        strList.add("100");
        printList(strList);       

    }
}
