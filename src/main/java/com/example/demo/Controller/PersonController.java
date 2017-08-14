package com.example.demo.Controller;

import com.example.demo.mapper.PersonDao;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by chai on 17/8/1.
 */
@RestController
public class PersonController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PersonService personService;
    @RequestMapping("/")
    public String getHolle(){
        System.out.println("-sadasdasd-");
        logger.info("this is debug");
        return "HolleWord";
    }

    @RequestMapping("/p")
    public List<Person> getP(Person person){
        return personService.get(person);
    }

    @RequestMapping("/add")
    public  Person add(Person person){
        System.out.println(person);
        personService.add(person);
        return person;
    }

    @RequestMapping("/put")
    public int put(Person person){
        System.out.println(person);
      int count=  personService.put(person);
        return count;
    }

    @RequestMapping("/delete")
        public int delete(Long id){
            return personService.delete(id);
    }

    @RequestMapping("/find/mybatis/page")
    public List<Person> findUserPageFromMybatis(  Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Person> list = personService.get(new Person());
        PageInfo pageInfo = new PageInfo(list);
        Page page = (Page) list;
        return list;
    }


}
