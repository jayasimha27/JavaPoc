/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.ci.object;

import com.example.spring.util.SpringBeanFactory;

/**
 *
 * @author jjagadee
 */
public class EmployeeCIObject {

    private int id;
    private String name;
    private AddressCIObject address;//Aggregation  

    public EmployeeCIObject() {
        System.out.println("def cons");
    }

    public EmployeeCIObject(int id, String name, AddressCIObject address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void show() {
        System.out.println(id + " " + name);
        System.out.println(address.toString());
    }
    
    public static void main(String[] args) {
        
        EmployeeCIObject employee=(EmployeeCIObject)SpringBeanFactory.getInstance().getBean("emp");
        employee.show();
    }

}
