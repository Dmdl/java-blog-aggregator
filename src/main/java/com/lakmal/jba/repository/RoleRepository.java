package com.lakmal.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakmal.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

}
