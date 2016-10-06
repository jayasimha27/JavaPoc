package com.example.rest.model;

import java.util.Map;

//@XmlRootElement       //only needed if we also want to generate XML
public class Person {
    
    private String Id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String[] citizenships;
    private Map<String, Object> creditCards;
    private int age;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
         
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
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String[] getCitizenships() {
        return citizenships;
    }
    public void setCitizenships(String[] citizenships) {
        this.citizenships = citizenships;
    }
    
    public Map<String, Object> getCreditCards() {
        return creditCards;
    }
    public void setCreditCards(Map<String, Object> creditCards) {
        this.creditCards = creditCards;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }    
       
}