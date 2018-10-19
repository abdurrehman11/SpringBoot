package com.infotech.exceptionhandlerdemo.repository;

import com.infotech.exceptionhandlerdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
