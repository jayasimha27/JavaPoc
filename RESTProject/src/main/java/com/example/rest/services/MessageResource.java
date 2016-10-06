package com.example.rest.services;

import com.example.rest.model.Message;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/message")
public class MessageResource {

    @GET
    @Path("/ping")
    public String getServerTime() {
        System.out.println("RESTful Service 'MessageService' is running ==> ping");
        return "received ping on " + new Date().toString();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})  //add MediaType.APPLICATION_XML if you want XML as well (don't forget @XmlRootElement)
    public List<Message> getAllMessages() throws Exception {

        List<Message> messages = new ArrayList<>();

        Message m = new Message();
        m.setDate(new Date());
        m.setFirstName("Nabi");
        //m.setLastName("Zamani");
        m.setAge(30);
        m.setText("Hello World!");
        messages.add(m);

        System.out.println("getAllMessages(): found " + messages.size() + " message(s) on DB");

        throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
        //return messages; //do not use Response object because this causes issues when generating XML automatically
    }

    /**
     * http://localhost:8080/RESTProject-1.0-SNAPSHOT/service/message/query?from=100&to=200&orderBy=age&orderBy=name
     *
     * @param from
     * @param to
     * @param orderBy
     * @return
     */
    @GET
    @Path("/query")
    public Response getUsers(
            @QueryParam("from") int from,
            @QueryParam("to") int to,
            @QueryParam("orderBy") List<String> orderBy) {

        return Response
                .status(200)
                .entity("getUsers is called, from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();

    }

    @GET
    @Path("/qcontext")
    public Response getUsers(@Context UriInfo info) {

        String from = info.getQueryParameters().getFirst("from");
        String to = info.getQueryParameters().getFirst("to");
        List<String> orderBy = info.getQueryParameters().get("orderBy");

        return Response
                .status(200)
                .entity("getUsers is called, from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();

    }

    /**
     * http://localhost:8080/RESTProject-1.0-SNAPSHOT/service/message/2011;author=jayasimha;country=india
     *
     * @param year
     * @param author
     * @param country
     * @return
     */
    @GET
    @Path("{year}")
    public Response getAuthor(@PathParam("year") String year,
            @MatrixParam("author") String author,
            @MatrixParam("country") String country) {

        return Response
                .status(200)
                .entity("getBooks is called, year : " + year
                        + ", author : " + author + ", country : " + country)
                .build();

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/post")
    public String postMessage(Message msg) throws Exception {

        System.out.println("First Name = " + msg.getFirstName());
        System.out.println("Last Name  = " + msg.getLastName());

        return "ok";
    }

}
