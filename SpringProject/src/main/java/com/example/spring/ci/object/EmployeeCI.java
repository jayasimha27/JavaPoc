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
public class EmployeeCI {

    private int id;
    private String name;

    public EmployeeCI() {
        System.out.println("def cons");
    }

    public EmployeeCI(int id) {
        this.id = id;
    }

    public EmployeeCI(String name) {
        this.name = name;
    }

    public EmployeeCI(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void show() {
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {
        System.out.println("######################");
        EmployeeCI employee1 = (EmployeeCI) SpringBeanFactory.getInstance().getBean("emp1");
        employee1.show();
        EmployeeCI employee2 = (EmployeeCI) SpringBeanFactory.getInstance().getBean("emp2");
        employee2.show();
        EmployeeCI employee3 = (EmployeeCI) SpringBeanFactory.getInstance().getBean("emp3");
        employee3.show();
        System.out.println("######################");
    }

}
