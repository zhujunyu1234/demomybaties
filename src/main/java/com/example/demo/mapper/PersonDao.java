package com.example.demo.mapper;

import com.example.demo.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chai on 17/8/1.
 */
@Component
public interface PersonDao {
    public List<Person> get(Person person);

    public Long add(Person person);

    public int put(Person person);

    public int delete(Long id);

    public Person getByID(Long id);
}
