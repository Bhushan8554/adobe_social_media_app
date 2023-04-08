package com.adobe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adobe.model.Post;
import com.adobe.model.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Query("select p from Post p order by p.likes desc limit 5")
	List<Post> getTop5();
}
