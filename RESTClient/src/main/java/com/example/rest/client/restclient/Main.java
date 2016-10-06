/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest.client.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jjagadee
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Message msg = new Message();
        msg.setAge(38);
        msg.setFirstName("jayasimha");
        msg.setLastName("bangalore");

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        ObjectMapper mapper = new ObjectMapper();
        String str=mapper.writeValueAsString(map);
    }

}
