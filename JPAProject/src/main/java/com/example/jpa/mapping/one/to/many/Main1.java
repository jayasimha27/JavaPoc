/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.mapping.one.to.many;

import com.example.jpa.maping.one.to.one.Customer;
import com.example.jpa.maping.one.to.one.User;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2_JPA_ECLIPSE");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            List<CarColumnMapping> cars = new ArrayList();
            cars.add(new CarColumnMapping("Terminator"));
            cars.add(new CarColumnMapping("Fluffy"));
            cars.add(new CarColumnMapping("Bacon"));

            CustomerColumnMapping customer = new CustomerColumnMapping();
            customer.setName("Arnold");
            customer.setCars(cars);

            em.persist(customer);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            emf.close();
        }

        System.out.println("It is over");
    }

}
