package com.certification.spring.preparation.dao;


import com.certification.spring.preparation.ds.Person;

public class PersonDaoImpl implements PersonDao {
    @Override
    public Person findById(int id) {
        System.out.println(getClass().getSimpleName());
        System.out.println("Searching for person...");
        return new Person();
    }

    @Override
    public void save(Person person) {
        System.out.println(getClass().getSimpleName());
        System.out.println("Saving person...");
    }
}
