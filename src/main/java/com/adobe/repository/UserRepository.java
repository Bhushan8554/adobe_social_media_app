package com.adobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
