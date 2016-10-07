/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.ci.object;

/**
 *
 * @author jjagadee
 */
public class AddressCIObject {

    private String city;
    private String state;
    private String country;

    public AddressCIObject(String city, String state, String country) {

        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String toString() {
        return city + " " + state + " " + country;
    }

}
