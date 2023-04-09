package com.adobe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adobe.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u left join Post p on u.id=p.u.id group by u.id order by count(p.id) desc limit 5")
	List<User> getTop5();
	
}
