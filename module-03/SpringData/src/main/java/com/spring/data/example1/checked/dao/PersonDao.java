package com.spring.data.example1.checked.dao;


import com.spring.data.example1.checked.ds.Person;
import com.spring.data.example1.checked.exception.DaoFilesystemException;
import com.spring.data.example1.checked.exception.PersonInvalidException;
import com.spring.data.example1.checked.exception.PersonStoreException;

public class PersonDao {
    public void save(Person person) throws PersonInvalidException, PersonStoreException, DaoFilesystemException {
        if (!valid(person))
            throw new PersonInvalidException();

        if (!filesystemActive(person))
            throw new DaoFilesystemException();

        if (!store(person))
            throw new PersonStoreException();
    }

    private boolean valid(Person person) {
        return false;
    }

    private boolean store(Person person) {
        return false;
    }

    private boolean filesystemActive(Person person) {
        return false;
    }
}
