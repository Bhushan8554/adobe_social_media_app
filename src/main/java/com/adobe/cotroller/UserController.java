package com.adobe.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.model.UserDTO;
import com.adobe.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService UserService;
	
	@PostMapping("/users")
	public ResponseEntity<UserDTO> addUserMapping(@RequestBody UserDTO u) {
		return null;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> getUserMapping(@PathVariable Integer id) {
		return null;
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDTO> updateUserMapping(@PathVariable Integer id,@RequestBody UserDTO u) {
		return null;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserDTO> deleteUserMapping(@PathVariable Integer id) {
		return null;
	}
	
	@GetMapping("/analytics/users")
	public ResponseEntity<Integer> getTotalUserMapping() {
		return null;
	}
	
	@GetMapping("/analytics/users/top-active")
	public ResponseEntity<List<UserDTO>> getTopUserMapping() {
		return null;
	}
	
}
