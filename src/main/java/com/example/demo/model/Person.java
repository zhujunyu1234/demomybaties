package com.example.demo.model;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import java.io.Serializable;

/**
 * Created by chai on 17/7/13.
 */

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @QueryParam("id")
    @FormParam("id")
    private Long id;
    @QueryParam("name")
    @FormParam("name")
    private String name;

    @QueryParam("age")
    @FormParam("age")
    private Integer age;
    @FormParam("address")
    @QueryParam("address")
    private String address;

    public Person(String name, int age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person() {

    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

}
