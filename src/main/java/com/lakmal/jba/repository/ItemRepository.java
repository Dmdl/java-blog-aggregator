package com.lakmal.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakmal.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
