package com.adobe.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.model.UserDTO;
import com.adobe.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService UserService;
	
	public ResponseEntity<UserDTO> addUserMapping(@RequestBody UserDTO u) {
		return null;
	}
	public ResponseEntity<UserDTO> getUserMapping(@PathVariable Integer id) {
		return null;
	}
	public ResponseEntity<UserDTO> updateUserMapping(@PathVariable Integer id,@RequestBody UserDTO u) {
		return null;
	}
	public ResponseEntity<UserDTO> deleteUserMapping(@PathVariable Integer id) {
		return null;
	}
	
	public ResponseEntity<Integer> getTotalUserMapping(@PathVariable Integer id) {
		return null;
	}
	
	public ResponseEntity<List<UserDTO>> getTopUserMapping(@PathVariable Integer id) {
		return null;
	}
	
}
