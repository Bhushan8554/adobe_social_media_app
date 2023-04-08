package com.adobe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adobe.exceptions.PostException;
import com.adobe.exceptions.UserException;
import com.adobe.model.UserDTO;
import com.adobe.repository.UserRepository;

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO addUser(UserDTO p) throws PostException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO deleteUser(Integer id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO updateUser(Integer id, UserDTO u) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUser(Integer id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer TotalUser() throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> Top5User() throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
