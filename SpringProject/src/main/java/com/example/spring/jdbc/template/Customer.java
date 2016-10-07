/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.jdbc.template;

import jdk.nashorn.internal.runtime.Debug;

/**
 *
 * @author jjagadee
 */
public class Customer {

    private String customerId;
    private String name;
    private String email;

    public Customer() {
    }

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public String getCutomerId() {
        return customerId;
    }

    public void setCutomerId(String CutomerId) {
        this.customerId = CutomerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer [Id =" + customerId + "Name=" + name + ", email="
                + email + "]";
    }

}
