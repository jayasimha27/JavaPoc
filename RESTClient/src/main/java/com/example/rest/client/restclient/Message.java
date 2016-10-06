package com.example.rest.client.restclient;

import java.io.Serializable;
import java.util.Date;

//@XmlRootElement       //only needed if we also want to generate XML
public class Message implements Serializable {

    private String firstName;

    private String lastName;

    private int age;

    private String text;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
