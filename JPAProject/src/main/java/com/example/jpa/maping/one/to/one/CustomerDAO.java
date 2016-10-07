/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.maping.one.to.one;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author jayasimha
 */
public class CustomerDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2_JPA_ECLIPSE");
    EntityManager em = emf.createEntityManager();

    public void addCustomer(List<Customer> customerList) {
        try {
            em.getTransaction().begin();
            for (Customer customer : customerList) {
                em.persist(customer);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public List<Customer> getCustomers() {
        try {
            TypedQuery<Customer> query
                    = em.createNamedQuery("Customer.findAll", Customer.class);
            return (query.getResultList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Customer getCustomer(String name) {
        try {
            TypedQuery<Customer> query
                    = em.createNamedQuery("Customer.findByName", Customer.class);
            query.setParameter("name", name);
            return (query.getSingleResult());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
