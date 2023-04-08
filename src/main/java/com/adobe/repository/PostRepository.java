package com.adobe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.model.Post;
import com.adobe.model.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	//List<Post> findTop5OrderByLikesList();
}
