package com.spring.data.example1.checked.dao;

import com.spring.data.example1.checked.ds.Person;
import com.spring.data.example1.checked.exception.DaoFilesystemException;
import com.spring.data.example1.checked.exception.PersonInvalidException;
import com.spring.data.example1.checked.exception.PersonStoreException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PersonDaoTest {
    StubPersonDao personDao;

    @BeforeEach
    void setUp() {
        personDao = new StubPersonDao();
    }

    @Test
    void shouldThrowPersonInvalidException() {
        assertThrows(PersonInvalidException.class, () -> personDao.save(new Person()));
    }

    @Test
    void shouldThrowDaoFileSystemException() throws PersonInvalidException, DaoFilesystemException, PersonStoreException {
        personDao.isValid = true;
        assertThrows(DaoFilesystemException.class, () -> personDao.save(new Person()));
    }

    @Test
    void shouldThrowPersonStoreException() throws PersonInvalidException, DaoFilesystemException, PersonStoreException {
        personDao.isValid = true;
        personDao.isFileSystem = true;
        assertThrows(PersonStoreException.class, () -> personDao.save(new Person()));
    }

    @Test
    void shouldNotThrowAnyExceptionWhenAllValid() {
        personDao.isValid = true;
        personDao.isStore = true;
        personDao.isFileSystem = true;

        assertDoesNotThrow(() -> personDao.save(new Person()));
    }

}
class StubPersonDao extends PersonDao {
    boolean isValid;
    boolean isStore;
    boolean isFileSystem;

    @Override
    boolean valid(Person person) {
        return isValid;
    }

    @Override
    boolean store(Person person) {
        return isStore;
    }

    @Override
    boolean filesystemActive(Person person) {
        return isFileSystem;
    }
}