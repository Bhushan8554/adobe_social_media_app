package com.adobe.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.exceptions.PostException;
import com.adobe.exceptions.UserException;
import com.adobe.model.UserDTO;
import com.adobe.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService UserService;
	
	@PostMapping("/users")
	public ResponseEntity<UserDTO> addUserMapping(@RequestBody UserDTO u) throws PostException, UserException {
		return new ResponseEntity<UserDTO>(UserService.addUser(u),HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> getUserMapping(@PathVariable Integer id) throws UserException {
		return new ResponseEntity<UserDTO>(UserService.getUser(id),HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDTO> updateUserMapping(@PathVariable Integer id,@RequestBody UserDTO u)throws UserException {
		return new ResponseEntity<UserDTO>(UserService.updateUser(id,u),HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserDTO> deleteUserMapping(@PathVariable Integer id) throws UserException{
		return new ResponseEntity<UserDTO>(UserService.deleteUser(id),HttpStatus.OK);
	}
	
	@GetMapping("/analytics/users")
	public ResponseEntity<Integer> getTotalUserMapping() throws UserException{
		return new ResponseEntity<Integer>(UserService.TotalUser(),HttpStatus.OK);
	}
	
	@GetMapping("/analytics/users/top-active")
	public ResponseEntity<List<UserDTO>> getTopUserMapping() throws UserException {
		return new ResponseEntity<List<UserDTO>>(UserService.Top5User(),HttpStatus.OK);
	}
	
}
