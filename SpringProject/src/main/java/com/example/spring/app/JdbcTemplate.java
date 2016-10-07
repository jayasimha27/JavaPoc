/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.app;

import com.example.spring.jdbc.template.Customer;
import com.example.spring.jdbc.template.CustomerDao;
import com.example.spring.util.SpringBeanFactory;
import java.util.List;

/**
 *
 * @author jjagadee
 */
public class JdbcTemplate {

    public static void main(String[] args) {
        CustomerDao customer = (CustomerDao) SpringBeanFactory.getInstance().getBean("custDao");
        //customer.createTable();
        //customer.saveEmployee(new Customer("320377", "jayasimha", "jayasimha27@gmail.com"));
        //customer.saveCustomereByPreparedStatement(new Customer("4024", "Jay", "jay@example.com"));

        List<Customer> list = customer.getAllCustomers();;

        for (Customer e : list) {
            System.out.println(e.toString());
        }

        List<Customer> list1 = customer.getAllCustomersRowMapper();;

        for (Customer e : list1) {
            System.out.println(e.toString());
        }

    }
}
