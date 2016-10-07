/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.boot.model;

import com.example.spring.boot.entity.User;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

/**
 *
 * @author jjagadee
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    /**
     * Return the user having the passed Id or null if no user is found.
     *
     * @param id
     */
    public User findById(long id);

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param email the user email.
     */
    public User findByEmail(String email);

}
