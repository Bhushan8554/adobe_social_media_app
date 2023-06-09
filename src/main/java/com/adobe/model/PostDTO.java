package com.adobe.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

	
	private Integer id;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private Integer likes;
	public PostDTO(Post p) {
		super();
		this.id = p.getId();
		this.content = p.getContent();
		this.created_at = p.getCreated_at();
		this.updated_at = p.getUpdated_at();
		this.likes = p.getLikes();
	}

	
}
