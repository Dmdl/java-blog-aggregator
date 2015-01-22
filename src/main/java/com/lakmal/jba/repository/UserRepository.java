package com.lakmal.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakmal.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
