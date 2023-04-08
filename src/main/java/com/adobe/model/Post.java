package com.adobe.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@Id
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	private User u;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private Integer likes;

}
