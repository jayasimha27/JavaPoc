/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.many.to.many;

import java.util.List;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int person_iid;

    private String name;

    @ManyToMany
    @JoinTable(name = "person_dog", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "dog_id"))
    private List<Dog> dogs;

    // get and set
    public int getId() {
        return person_iid;
    }

    public void setId(int id) {
        this.person_iid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

}
