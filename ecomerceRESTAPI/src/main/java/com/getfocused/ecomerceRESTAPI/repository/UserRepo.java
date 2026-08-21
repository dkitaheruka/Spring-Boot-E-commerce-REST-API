package com.getfocused.ecomerceRESTAPI.repository;

import com.getfocused.ecomerceRESTAPI.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
