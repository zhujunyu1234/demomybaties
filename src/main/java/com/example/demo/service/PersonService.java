package com.example.demo.service;

import com.example.demo.mapper.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chai on 17/8/1.
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    public List<Person> get(Person person) {
        return personDao.get(person);
    }

    public Long add(Person person) {
        return personDao.add(person);
    }

    public int put(Person person) {
        return personDao.put(person);
    }

    public int delete(Long id) {
        return personDao.delete(id);
    }

}
