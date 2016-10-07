/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.maping.one.to.one;

//Using the * to make the import list smaller
import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Customer.findAll",
            query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByName",
            query = "SELECT c FROM Customer c WHERE c.name = :name")})
@Table(name = "CUSTOMERS")
@SequenceGenerator(name = "CUSTOMER_SEQUENCE", sequenceName = "CUSTOMER_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQUENCE")
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    //@JoinColumn(name="ID", nullable=false)
    @PrimaryKeyJoinColumn
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
