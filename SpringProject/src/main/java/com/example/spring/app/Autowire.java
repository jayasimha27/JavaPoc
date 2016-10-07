/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.app;

import com.example.spring.auto.wire.Company;
import com.example.spring.util.SpringBeanFactory;

/**
 *
 * @author jjagadee
 */
public class Autowire {

    public static void main(String[] args) {

        Company company = (Company) SpringBeanFactory.getInstance().getBean("company");
        System.out.println("Company Details" + company.toString());
    }

}
