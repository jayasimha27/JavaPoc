/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.mapping.one.to.many;

//Using the * to make the import list smaller
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CAR_OWNER")
@SequenceGenerator(name = "CAR_SEQUENCE", sequenceName = "CAR_SEQUENCE", allocationSize = 1, initialValue = 0)
public class CarColumnMapping implements Serializable {

    public CarColumnMapping() {

    }

    public CarColumnMapping(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_SEQUENCE")
    private int id;

    @Column(name = "NAME")
    private String name;

    /**
     * http://docs.doctrine-project.org/projects/doctrine-orm/en/latest/reference/annotations-reference.html#annref-manytoone
     */
    @ManyToOne
    private CustomerColumnMapping owner;

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

    public CustomerColumnMapping getOwner() {
        return owner;
    }

    public void setOwner(CustomerColumnMapping owner) {
        this.owner = owner;
    }

}
