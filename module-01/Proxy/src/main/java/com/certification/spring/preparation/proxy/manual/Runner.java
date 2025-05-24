package com.certification.spring.preparation.proxy.manual;


import com.certification.spring.preparation.dao.PersonDao;
import com.certification.spring.preparation.dao.PersonDaoImpl;
import com.certification.spring.preparation.ds.Person;

public class Runner {
    public static void main(String[] args) {
        //PersonDao personDao = new PersonDaoImpl();
        PersonDao personDao = new PersonDaoProxy(
                new PersonDaoImpl()
        );

        Person person = personDao.findById(5);
        personDao.save(person);
    }
}
