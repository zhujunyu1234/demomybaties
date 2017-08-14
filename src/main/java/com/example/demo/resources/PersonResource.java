package com.example.demo.resources;

import com.example.demo.mapper.PersonDao;
import com.example.demo.model.Person;
import com.example.demo.service.AccessTokenService;
import com.example.demo.service.NonceTicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by chai on 17/8/1.
 */
@Component
@Path("/persons")
public class PersonResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonDao personDao;

    @Autowired
    NonceTicketService nonceTicketService;


    @Path("/a")
    @GET
    public String aa(){
        return AccessTokenService.ACCESS_TOKEN;
    }
    @Path("/t")
    @GET
    public String t(){

        return nonceTicketService.getNonceTicket();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getP(){
        Person person = new Person();
        logger.info("this is debug");
        return personDao.get(person);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getP(@PathParam("id") Long id){

        return personDao.getByID(id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id){
        personDao.delete(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})
    @Produces(MediaType.APPLICATION_JSON)
    public Person save( Person person){
//       Person person =new Person();
//        person.setId(id);
//        person.setName(name);
//        person.setAge(age);
//        person.setAddress(address);
//        hashMap.get("name");
//        System.out.println("haha"+hashMap.get("name"));
        personDao.add(person);
        return person;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person put(@PathParam("id") Long id,Person person){
        person.setId(id);
        personDao.put(person);
        person= personDao.getByID(id);
        return person;
    }

}
