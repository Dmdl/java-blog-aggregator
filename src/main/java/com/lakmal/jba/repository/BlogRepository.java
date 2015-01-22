package com.lakmal.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakmal.jba.entity.Blog;
import com.lakmal.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
}
