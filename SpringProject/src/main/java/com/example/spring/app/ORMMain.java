/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.app;

import com.example.spring.orm.Product;
import com.example.spring.orm.ProductService;
import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author jjagadee
 */
public class ORMMain {

    public static void main(String[] args) {

        //Create Spring application context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/application-context.xml");

        //Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
        ProductService productService = ctx.getBean(ProductService.class);

        //Do some data operation
        productService.add(new Product(1, "Bulb"));
        productService.add(new Product(2, "Dijone mustard"));

        System.out.println("listAll: " + productService.listAll());

        //Test transaction rollback (duplicated key)
        try {
            productService.addAll(Arrays.asList(new Product(3, "Book"), new Product(4, "Soap"), new Product(1, "Computer")));
        } catch (DataAccessException dataAccessException) {
        }

        //Test element list after rollback
        System.out.println("listAll: " + productService.listAll().size());

        ctx.close();

    }

}
