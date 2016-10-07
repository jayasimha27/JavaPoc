/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.auto.wire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author jjagadee
 */
public class Company {

    String companyName;
    String companyCEO;

    @Autowired
    @Qualifier("postalAddress")
    PostalAddress postalAddress;


    /*
     * Below constructor will be used for Autowiring with COnstructor.
     */
    /*public Company(String companyName, String companyCEO, PostalAddress postalAddress) {
     super();
     this.companyName = companyName;
     this.companyCEO = companyCEO;
     this.postalAddress = postalAddress;
     }*/
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCEO() {
        return companyCEO;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Override
    public String toString() {
        return "Company [companyName=" + companyName + ", companyCEO="
                + companyCEO + ", address=" + postalAddress.toString() + "]";
    }

}
