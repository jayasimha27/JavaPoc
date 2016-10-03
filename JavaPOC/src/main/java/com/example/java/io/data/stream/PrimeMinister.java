/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.io.data.stream;

import java.io.Serializable;

/**
 *
 * @author jjagadee
 */
public class PrimeMinister implements Serializable{

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "PrimeMinister [name=" + name + ", period=" + period + ", term=" + term + "]";
    }

    public PrimeMinister(String name, String period, String term) {
        this.name = name;
        this.period = period;
        this.term = term;
    }
    private String name;
    private String period;
    private transient String term;

}
