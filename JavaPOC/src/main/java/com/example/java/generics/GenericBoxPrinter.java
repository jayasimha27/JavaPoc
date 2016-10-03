/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.generics;

/**
 *
 * @author jjagadee
 */
public class GenericBoxPrinter<T> {

    private T val;

    public GenericBoxPrinter(T arg) {
        val = arg;
    }

    public String toString() {
        return "[" + val + "]";
    }

    public T getValue() {
        return val;
    }

    public static void main(String[] args) {
        GenericBoxPrinter<Integer> value1 = new GenericBoxPrinter<Integer>(new Integer(10));
        System.out.println(value1);
        Integer intValue1 = value1.getValue();

        GenericBoxPrinter<String> value2 = new GenericBoxPrinter<String>("Hello world");
        System.out.println(value2);
        // OOPs! by mistake, we did put String in an Integer
        //Integer intValue2 = value2.getValue();
    }

}
