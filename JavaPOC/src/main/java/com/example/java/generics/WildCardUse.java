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
        
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        printList(list);
        List<String> strList = new ArrayList<>();
        strList.add("10");
        strList.add("100");
        printList(strList);

        /*List<?> wildCardList = new ArrayList<Integer>();
        wildCardList.add(new Integer(10));
        System.out.println(wildCardList);*/

    }
}
