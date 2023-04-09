package com.adobe.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Post.findAllOrderByLikesDesc",
query = "select p from Post p order by p.likes desc")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	private User u;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private Integer likes;

	public Post(PostDTO p) {
		super();
		this.id = p.getId();
		this.content = p.getContent();
		this.created_at = p.getCreated_at();
		this.updated_at = p.getUpdated_at();
		this.likes = p.getLikes();
	}
}
