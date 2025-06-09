package com.spring.data.example1.unchecked;

import com.spring.data.example1.unchecked.dao.PersonDao;
import com.spring.data.example1.unchecked.ds.Person;
import com.spring.data.example1.unchecked.exception.DaoFilesystemException;
import com.spring.data.example1.unchecked.exception.PersonInvalidException;
import com.spring.data.example1.unchecked.exception.PersonStoreException;

public class Runner {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        personDao.save(new Person());
    }
}
