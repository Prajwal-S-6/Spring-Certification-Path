package com.spring.security.example9;

import com.spring.security.example9.dao.UsersDao;
import com.spring.security.example9.ds.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        usersDao.save(new Users(1, "admin", passwordEncoder.encode("password")));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
