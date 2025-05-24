package com.certification.spring.preparation.proxy.manual;


import com.certification.spring.preparation.dao.PersonDao;
import com.certification.spring.preparation.ds.Person;

public class PersonDaoProxy implements PersonDao {

    private final PersonDao personDao;

    public PersonDaoProxy(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person findById(int id) {
        System.out.println("before findById");      // boiler plate code
        Person person = personDao.findById(id);
        System.out.println("after findById");       // boiler plate code
        return person;
    }

    @Override
    public void save(Person person) {
        System.out.println("before save");          // boiler plate code
        personDao.save(person);
        System.out.println("after save");           // boiler plate code
    }
}
