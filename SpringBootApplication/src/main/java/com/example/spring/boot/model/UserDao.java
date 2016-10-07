/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.boot.model;

import com.example.spring.boot.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is used to access data for the User entity. Repository annotation
 * allows the component scanning support to find and configure the DAO wihtout
 * any XML configuration and also provide the Spring exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method.
 * If exception occurs it will also call rollback().
 */
@Component
@Repository
@Transactional
public class UserDao {

    public UserDao(){
    }
    // Private fields
    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Save the user in the database.
     * @param user
     */
    public void create(User user) {
        entityManager.persist(user);
    }

    /**
     * Delete the user from the database.
     * @param user
     */
    public void delete(User user) {
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            entityManager.remove(entityManager.merge(user));
        }
    }

    /**
     * Return all the users stored in the database.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public List getAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    /**
     * Return the user having the passed email.
     * @param login
     */
    public User getByLogin(String login) {
        return (User) entityManager.createQuery(
                "from User where login = :login")
                .setParameter("login", login)
                .getSingleResult();
    }

    /**
     * Return the user having the passed id.
     * @param id
     */
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    /**
     * Update the passed user in the database.
     * @param user
     */
    public void update(User user) {
        entityManager.merge(user);
        return;
    }

    
}
