package org.gs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@Path("/api")
public class GreetingResource {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfo(@QueryParam("name") String name, @QueryParam("age") int age){
        return "{\"name\":\"" + name + "\",\"age\":" + age + ",\"id\":\"" + UUID.randomUUID() + "\"}";
    }
    
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public String createUser(Person person){
        person.setName(person.getName().toUpperCase());

        return "{\"name\":\"" + person.getName() + "\",\"age\":" + person.getAge() + ",\"id\":\"" + UUID.randomUUID() + "\"}";
    }

    @JsonPropertyOrder({"name", "age"})
    public static class Person{
        private String name;
        private int age;

        public String getName(){return this.name;}
        public void setName(String name){this.name = name;}
        public int getAge(){return this.age;};
        public void setAge(int age){ this.age = age;}
    }

}