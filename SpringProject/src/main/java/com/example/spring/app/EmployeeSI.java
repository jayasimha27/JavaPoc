/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.app;

import com.example.spring.si.object.Employee;
import com.example.spring.util.SpringBeanFactory;

/**
 *
 * @author jjagadee
 */
public class EmployeeSI {
    
    public static void main(String[] args) {
     Employee emp=(Employee)SpringBeanFactory.getInstance().getBean("employeeSI");
     emp.show();
    }
    
}
