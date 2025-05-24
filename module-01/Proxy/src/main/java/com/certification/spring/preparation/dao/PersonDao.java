package com.certification.spring.preparation.dao;


import com.certification.spring.preparation.ds.Person;

public interface PersonDao {
    Person findById(int id);

    void save(Person person);
}
