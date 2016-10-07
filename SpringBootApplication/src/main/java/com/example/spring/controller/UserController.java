/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.controller;

import com.example.spring.boot.entity.User;
import com.example.spring.boot.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    // Private fields
    // Wire the UserDao used inside this controller.
    @Autowired
    private UserDao userDao;

    /**
     * Create a new user with an auto-generated id and email and name as passed
     * values.
     *
     * @param id
     * @param login
     * @param password
     * @return
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    public String create(int id, String login, String password) {
        try {
            User user = new User();
            user.setId(id);
            user.setLogin(login);
            user.setPassword(password);
            userDao.create(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created!";
    }

    /**
     * Delete the user with the passed id.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(int id) {
        try {
            User user = new User();
            user.setId(id);
            userDao.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * Retrieve the id for the user with the passed email address.
     *
     * @param login
     * @return
     */
    @RequestMapping(value = "/get-login")
    @ResponseBody
    public String getLogin(String login) {
        String userId;
        String loginName;
        String password;
        try {
            User user = userDao.getByLogin(login);
            userId = String.valueOf(user.getId());
            loginName = user.getLogin();
            password = user.getPassword();
        } catch (Exception ex) {
            return "User not found: " + ex.toString();
        }
        StringBuilder builder = new StringBuilder();
        builder.append("User Id :");
        builder.append(userId);
        builder.append("\n");
        builder.append("Login Name :");
        builder.append(loginName);
        builder.append("\n");
        builder.append("Login Password :");
        builder.append(password);
        return builder.toString();
    }

    /**
     * Update the email and the name for the user indentified by the passed id.
     *
     * @param id
     * @param login
     * @param password
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public String updateName(int id, String login, String password) {
        try {
            User user = userDao.getById(id);
            user.setLogin(login);
            user.setPassword(password);
            userDao.update(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

}
