package com.adobe.model;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	
	private Integer id;
	private String name;
	private String email;
	private String bio;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	public UserDTO(User u) {
		super();
		this.id = u.getId();
		this.name = u.getName();
		this.email = u.getEmail();
		this.bio = u.getBio();
		this.created_at = u.getCreated_at();
		this.updated_at = u.getUpdated_at();
	}
	
	
	
	
}
