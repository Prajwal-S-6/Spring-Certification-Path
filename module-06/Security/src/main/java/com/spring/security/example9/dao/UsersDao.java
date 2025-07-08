package com.spring.security.example9.dao;

import com.spring.security.example9.ds.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersDao extends JpaRepository<Users, Integer> {
    Optional<Users> findByUserName(String username);
}
