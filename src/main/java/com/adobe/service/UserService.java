package com.adobe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adobe.exceptions.UserException;
import com.adobe.exceptions.PostException;
import com.adobe.model.UserDTO;

@Service
public interface UserService {

	public UserDTO addUser(UserDTO p)throws PostException,UserException;
	
	public UserDTO deleteUser(Integer id)throws UserException;
	
	public UserDTO updateUser(Integer id)throws UserException;
	
	public UserDTO getUser(Integer id)throws UserException;
	
	public Integer TotalUser()throws UserException;
	
	public List<UserDTO> Top5User()throws UserException;
	
}
