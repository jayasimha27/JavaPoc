/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.mapping.one.to.many;

import com.example.jpa.maping.one.to.one.User;
import java.io.Serializable;
import java.util.List;

//Using the * to make the import list smaller
import javax.persistence.*;

//@Entity
@Table(name = "CUSTOMER")
@SequenceGenerator(name = "CUSTOMER_SEQUENCE", sequenceName = "CUSTOMER_SEQUENCE", allocationSize = 1, initialValue = 0)
public class CustomerTableMapping implements Serializable {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQUENCE")
    private int id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn 
    //@JoinColumn(name = "ID", nullable = true)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "CUSTOMER", joinColumns = {
        @JoinColumn(name = "ID", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "ID", referencedColumnName = "id")})
    private List<CarTableMapping> cars;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CarTableMapping> getCars() {
        return cars;
    }

    public void setCars(List<CarTableMapping> cars) {
        this.cars = cars;
    }

   

}
