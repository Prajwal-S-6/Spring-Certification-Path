package com.spring.test.repository;


import com.spring.test.ds.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GuestRepository extends CrudRepository<Guest, UUID> {
}
