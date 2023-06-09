package com.adobe.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private Integer id;
	private String name;
	private String email;
	private String bio;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	@OneToMany
	private List<Post> post=new ArrayList<>();
	
	
	public User(UserDTO u) {
		super();
		this.id = u.getId();
		this.name = u.getName();
		this.email = u.getEmail();
		this.bio = u.getBio();
		this.created_at = u.getCreated_at();
		this.updated_at = u.getUpdated_at();
	}
	
}
