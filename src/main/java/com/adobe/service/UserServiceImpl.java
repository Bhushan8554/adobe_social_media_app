package com.adobe.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adobe.exceptions.PostException;
import com.adobe.exceptions.UserException;
import com.adobe.model.User;
import com.adobe.model.UserDTO;
import com.adobe.repository.UserRepository;

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO addUser(UserDTO p) throws PostException, UserException {
		
		User user=userRepository.findById(p.getId()).orElse(null);
		if(user!=null) {
			throw new UserException("User already exist");
		}
		p.setCreated_at(LocalDateTime.now());
		p.setUpdated_at(null);
		userRepository.save(new User(p));
		return p;
	}

	@Override
	public UserDTO deleteUser(Integer id) throws UserException {

		User user=userRepository.findById(id).orElse(null);
		if(user==null) {
			throw new UserException("User not exist with id "+id);
		}
		userRepository.delete(user);
		return new UserDTO(user);
	}

	@Override
	public UserDTO updateUser(Integer id, UserDTO u) throws UserException {
		User user=userRepository.findById(id).orElse(null);
		if(user==null) {
			throw new UserException("User not exist with id "+id);
		}
		
		user.setBio(u.getBio()!=null?u.getBio():user.getBio());
		user.setName(u.getName()!=null?u.getName():user.getName());
		user.setUpdated_at(LocalDateTime.now());
		
		return new UserDTO(userRepository.save(user));
	}

	@Override
	public UserDTO getUser(Integer id) throws UserException {

		User user=userRepository.findById(id).orElse(null);
		if(user==null) {
			throw new UserException("User not exist with id "+id);
		}
		return new UserDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() throws UserException {

		List<User> users=userRepository.findAll();
		if(users==null) {
			throw new UserException("User not exist");
		}
		return users.stream().map(s-> new UserDTO(s)).toList();
		
	}
	@Override
	public Integer TotalUser() throws UserException {
		// TODO Auto-generated method stub
		Integer n=(int) userRepository.count();
		if(n==0) {
			throw new UserException("No user found");
		}
		return n;
	}

	@Override
	public List<UserDTO> Top5User() throws UserException {
		// TODO Auto-generated method stub
		List<User> users=userRepository.getTop5();
		if(users.isEmpty()) {
			throw new UserException("no user found");
		}
		List<UserDTO> u=users.stream().map(s-> new UserDTO(s)).toList();
		
		return u;
		
	}

}
