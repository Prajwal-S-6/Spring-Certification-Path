package com.spring.data.example1.checked;

import com.spring.data.example1.checked.dao.PersonDao;
import com.spring.data.example1.checked.ds.Person;
import com.spring.data.example1.checked.exception.DaoFilesystemException;
import com.spring.data.example1.checked.exception.PersonInvalidException;
import com.spring.data.example1.checked.exception.PersonStoreException;

public class Runner {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        try {
            personDao.save(new Person());
        } catch (PersonInvalidException e) {
            throw new RuntimeException(e);
        } catch (DaoFilesystemException e) {
            throw new RuntimeException(e);
        } catch (PersonStoreException e) {
            throw new RuntimeException(e);
        }
    }
}
