package com.example.rest.services;

import com.example.rest.model.Person;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    @Path("/get")
    @GET
    @Produces({MediaType.APPLICATION_JSON})  //add MediaType.APPLICATION_XML if you want XML as well (don't forget @XmlRootElement)
    public Person getPerson() {

        Person p = new Person();
        p.setFirstName("Nabi");
        p.setLastName("Zamani");
        //p.setDateOfBirth("01.01.2012");

        p.setCitizenships(new String[]{"German", "Persian"});

        Map<String, Object> creditCards = new HashMap<String, Object>();
        creditCards.put("MasterCard", "1234 1234 1234 1234");
        creditCards.put("Visa", "1234 1234 1234 1234");
        creditCards.put("dummy", true);
        p.setCreditCards(creditCards);

        System.out.println("REST call...");

        //return Response.ok().entity(p).build();
        return p;
    }

    @Path("/get/{person_id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})  //add MediaType.APPLICATION_XML if you want XML as well (don't forget @XmlRootElement)
    public Person getPerson(@PathParam("person_id") String personID) {

        Person p = new Person();
        p.setId(personID);
        p.setFirstName("Nabi");
        p.setLastName("Zamani");
        //p.setDateOfBirth("01.01.2012");

        p.setCitizenships(new String[]{"German", "Persian"});

        Map<String, Object> creditCards = new HashMap<String, Object>();
        creditCards.put("MasterCard", "1234 1234 1234 1234");
        creditCards.put("Visa", "1234 1234 1234 1234");
        creditCards.put("dummy", true);
        p.setCreditCards(creditCards);

        System.out.println("REST call...");

        //return Response.ok().entity(p).build();
        return p;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/post")
    public String postPerson(Person pers) throws Exception {

        System.out.println("First Name = " + pers.getFirstName());
        System.out.println("Last Name  = " + pers.getLastName());

        return "ok";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/form")
    public String newTodo(@FormParam("id") String id,
            @FormParam("name") String name,
            @FormParam("lastName") String lastName,
            @FormParam("dob") String dob,
            @Context HttpServletResponse servletResponse) throws IOException {
        System.out.println(" ID = " + id);
        System.out.println("Last Name  = " + lastName);
        System.out.println("First Name = " + name);
        System.out.println("Date of Birth  = " + dob);
        return "ok";
    }

}
