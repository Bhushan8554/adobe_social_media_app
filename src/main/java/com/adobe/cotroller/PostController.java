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

import com.adobe.model.PostDTO;
import com.adobe.service.PostService;

@RestController
public class PostController {

	@Autowired
	PostService postService;
	
	@PostMapping("/posts")
	public ResponseEntity<PostDTO> addPostMapping(@RequestBody PostDTO p) {
		return null;
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<PostDTO> getPostMapping(@PathVariable Integer id) {
		return null;
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<PostDTO> updatePostMapping(@PathVariable Integer id,@RequestBody PostDTO p) {
		return null;
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<PostDTO> deletePostMapping(@PathVariable Integer id) {
		return null;
	}
	
	@PostMapping("/posts/{id}/like")
	public ResponseEntity<PostDTO> likePostMapping(@PathVariable Integer id) {
		return null;
	}
	@PostMapping("/posts/{id}/like")
	public ResponseEntity<PostDTO> unlikePostMapping(@PathVariable Integer id) {
		return null;
	}
	@GetMapping("/analytics/posts")
	public ResponseEntity<Integer> getTotalPostMapping(@PathVariable Integer id) {
		return null;
	}
	@GetMapping("/analytics/posts/top-liked")
	public ResponseEntity<List<PostDTO>> getTopPostMapping(@PathVariable Integer id) {
		return null;
	}
	
}
