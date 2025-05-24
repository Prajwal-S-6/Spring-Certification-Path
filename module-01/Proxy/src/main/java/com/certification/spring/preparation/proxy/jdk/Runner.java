package com.certification.spring.preparation.proxy.jdk;


import com.certification.spring.preparation.dao.PersonDao;
import com.certification.spring.preparation.dao.PersonDaoImpl;
import com.certification.spring.preparation.ds.Person;

import java.lang.reflect.Proxy;

public class Runner {
    public static void main(String[] args) {
        PersonDao personDao = (PersonDao) Proxy.newProxyInstance(
                PersonDao.class.getClassLoader(), PersonDaoImpl.class.getInterfaces(),
                new PersonDaoInvocationHandler(
                        new PersonDaoImpl()
                )
        );

        Person person = personDao.findById(5);
        personDao.save(person);
    }
}
