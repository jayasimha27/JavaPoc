/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.mapping.one.to.many;

import java.io.Serializable;
import java.util.List;

//Using the * to make the import list smaller
import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_OWNER")
@SequenceGenerator(name = "CUSTOMER_OWNER_SEQUENCE", sequenceName = "CUSTOMER_OWNER_SEQUENCE", allocationSize = 1, initialValue = 0)
public class CustomerColumnMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_OWNER_SEQUENCE")
    private int id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private List<CarColumnMapping> cars;

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getCars() {
        return cars;
    }

    public void setCars(List<CarColumnMapping> cars) {
        this.cars = cars;
    }

}
