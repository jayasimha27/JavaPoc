/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.design.patterns.singleton;

public class BSingleton {

    private static volatile BSingleton instance;
    private static Object mutex = new Object();

    private BSingleton() {
    }

    public static BSingleton getInstance() {
        BSingleton result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new BSingleton();
                }
            }
        }
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("");
    }

}
