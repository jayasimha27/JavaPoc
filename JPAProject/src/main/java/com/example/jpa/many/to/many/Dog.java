/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.many.to.many;

import java.util.List;
 
import javax.persistence.*;
 
@Entity
public class Dog {
 
    @Id
    @GeneratedValue
    private int dog_id;
 
    private String name;
 
    @ManyToMany(mappedBy="dogs")
    private List<Person> persons;

    public int getId() {
        return dog_id;
    }

    public void setId(int id) {
        this.dog_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    
    
    
    
}
