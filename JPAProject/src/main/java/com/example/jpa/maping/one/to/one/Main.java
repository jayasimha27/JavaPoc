/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.maping.one.to.one;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CustomerDAO dao = new CustomerDAO();
        dao.addCustomer(buildCustomerList());

        List<Customer> customerList = dao.getCustomers();
        System.out.println("Total Available Customers  : " + customerList.size());

        Customer customer = dao.getCustomer("Prakash Raj");
        System.out.println("Customer Name = " + customer.getName());
        System.out.println("User Name = " + customer.getUser().getLogin());

    }

    public static List<Customer> buildCustomerList() {

        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setName("Prakash Raj");

        User user1 = new User();
        user1.setLogin("pRaj");
        user1.setPassword("123change");

        //Bidirectional Mapping
        user1.setCustomer(customer1);
        customer1.setUser(user1);

        customerList.add(customer1);

        Customer customer2 = new Customer();
        customer1.setId(2);
        customer2.setName("Arvind Sharma");

        User user2 = new User();
        user2.setLogin("aSharma");
        user2.setPassword("password");

        //Bidirectional Mapping
        user2.setCustomer(customer2);
        customer2.setUser(user2);

        customerList.add(customer2);

        return customerList;

    }
}
