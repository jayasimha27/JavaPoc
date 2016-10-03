/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.string;

import java.util.regex.Pattern;

/**
 *
 * @author jjagadee
 */
public class IPAddress {

    void validateIP(String ipStr) {
        String regex = "\\b((25[0–5]|2[0–4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0–5]|2[0–4]\\d|[01]?\\d\\d?)\\b";
        System.out.println(ipStr + " is valid? " + Pattern.matches(regex, ipStr));
    }

    public static void main(String[] args) {
        String ipStr1 = "255.245.188.123";       // valid IP address
        String ipStr2 = "255.245.188.273";       // invalid IP address - 273 is greater than 255
        IPAddress validator = new IPAddress();
        validator.validateIP(ipStr1);
        validator.validateIP(ipStr2);
    }

}
