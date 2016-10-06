/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest.client.restclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author jjagadee
 */
public class RESTClient {

    public static void main(String[] args) throws JsonProcessingException {

        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget service = client.target(getBaseURI());

        //Create a Todo
        /*Form form = new Form();
         form.param("id", "4");
         form.param("name", "Nabi");
         form.param("lastName", "Zamani");
         form.param("dob", "09/07/1989");

         Response response = service.path("person").path("form").request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), Response.class);
         System.out.println("Form response " + response.getStatus());
         System.out.println("Returned Response = " + response.readEntity(String.class));*/
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("firstName", "Jay");
        messageMap.put("lastName", "Jay");
        ObjectMapper mapper = new ObjectMapper();

        Response response = service.path("message").path("post").request().post(Entity.entity(mapper.writeValueAsString(messageMap),
                MediaType.APPLICATION_JSON), Response.class);
        System.out.println("Form response " + response.getStatus());
        //System.out.println("Returned Response = " + response.readEntity(String.class));

    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/RESTProject-1.0-SNAPSHOT/service").build();
    }
}
