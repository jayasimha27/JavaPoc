/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.collections;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author jjagadee
 */
public class ArrayExample {

    public static void main(String[] args) {

        /* ########################################################### */
        // Initializing an Array
        String[] creatures = {"goldfish", "oscar", "guppy", "minnow"};
        int[] numbers = new int[10];
        int counter = 0;
        while (counter < numbers.length) {
            numbers[counter] = counter;
            System.out.println("number[" + counter + "]: " + counter);
            counter++;
        }
        for (int theInt : numbers) {
            System.out.println(theInt);
        }
        //System.out.println(numbers[numbers.length]);
        /* ########################################################### */

        /* ########################################################### */
        // Using Charecter Array
        String name = "Michael";
        // Charecter Array
        char[] charName = name.toCharArray();
        System.out.println(charName);

        // Array Fuctions
        char[] html = new char[]{'M', 'i', 'c', 'h', 'a', 'e', 'l'};
        char[] lastFour = new char[4];
        System.arraycopy(html, 3, lastFour, 0, lastFour.length);
        System.out.println(lastFour);
        /* ########################################################### */

        /* ########################################################### */
        // Using Arrays of Other Types
        Object[] person = new Object[]{"Michael", new Integer(94),
            new Integer(1), new Date()};

        String fname = (String) person[0];  //ok
        Integer age = (Integer) person[1]; //ok
        Date start = (Date) person[2];     //oops!
        /* ########################################################### */

        /* ########################################################### */
        // Muti Dimestional Array
        String[][] bits
                = {{"Michael", "Ernest", "MFE"},
                {"Ernest", "Friedman-Hill", "EFH"},
                {"Kathi", "Duggan", "KD"},
                {"Jeff", "Kellum", "JK"}};

        bits[0] = new String[]{"Rudy", "Polanski", "RP"};
        bits[1] = new String[]{"Rudy", "Washington", "RW"};
        bits[2] = new String[]{"Rudy", "O'Reilly", "RO"};
        /* ########################################################### */

        /* ########################################################### */
        //Create ArrayList from array
        String[] stringArray = {"a", "b", "c", "d", "e"};
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        System.out.println(arrayList);
        // [a, b, c, d, e]
         /* ########################################################### */

        /* ########################################################### */
        //Check if an array contains a certain value
        String[] stringArray1 = {"a", "b", "c", "d", "e"};
        boolean b = Arrays.asList(stringArray).contains("a");
        System.out.println(b);
        // true
        /* ########################################################### */

        /* ########################################################### */
        //Concatenate two arrays
        int[] intArray = {1, 2, 3, 4, 5};
        int[] intArray2 = {6, 7, 8, 9, 10};
        // Apache Commons Lang library
        int[] combinedIntArray = ArrayUtils.addAll(intArray, intArray2);
        /* ########################################################### */

        /* ########################################################### */
        //Joins the elements of the provided array into a single String
        // Apache common lang
        String j = StringUtils.join(new String[]{"a", "b", "c"}, ", ");
        System.out.println(j);
        // a, b, c
        /* ########################################################### */

        /* ########################################################### */
        //Covnert ArrayList to Array
        String[] stringArray3 = {"a", "b", "c", "d", "e"};
        ArrayList<String> arrayList1 = new ArrayList<String>(Arrays.asList(stringArray));
        String[] stringArr = new String[arrayList.size()];
        arrayList.toArray(stringArr);
        for (String s : stringArr) {
            System.out.println(s);
        }
        /* ########################################################### */

        /* ########################################################### */
        //Convert Array to Set
        Set<String> set = new HashSet<String>(Arrays.asList(stringArray));
        System.out.println(set);
        //[d, e, b, c, a]
        /* ########################################################### */

        /* ########################################################### */
        //Reverse an array
        int[] intArray1 = {1, 2, 3, 4, 5};
        ArrayUtils.reverse(intArray1);
        System.out.println(Arrays.toString(intArray1));
        //[5, 4, 3, 2, 1]
        /* ########################################################### */

        /* ########################################################### */
        // Remove element of an array
        int[] intArray3 = {1, 2, 3, 4, 5};
        int[] removed = ArrayUtils.removeElement(intArray3, 3);//create a new array
        System.out.println(Arrays.toString(removed));
        /* ########################################################### */

        
        /* ########################################################### */
        byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();
        for (byte t : bytes) {
            System.out.format("0x%x ", t);
        }
        /* ########################################################### */

    }
}
