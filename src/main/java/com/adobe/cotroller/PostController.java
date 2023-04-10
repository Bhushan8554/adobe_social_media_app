package com.adobe.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.exceptions.PostException;
import com.adobe.exceptions.UserException;
import com.adobe.model.PostDTO;
import com.adobe.service.PostService;
@CrossOrigin(origins = "https://adobesocialmediaapp-production.up.railway.app")
@RestController
public class PostController {

	@Autowired
	PostService postService;
	
	@PostMapping("/posts")
	public ResponseEntity<PostDTO> addPostMapping(@RequestBody PostDTO p,@RequestParam Integer u_id) throws PostException, UserException {
		System.out.println(u_id);
		return new ResponseEntity<PostDTO>(postService.addPost(p, u_id),HttpStatus.CREATED);
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<PostDTO> getPostMapping(@PathVariable Integer id) throws PostException {
		return new ResponseEntity<PostDTO>(postService.getPost(id),HttpStatus.OK);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<PostDTO> updatePostMapping(@PathVariable Integer id,@RequestBody PostDTO p) throws PostException {
		return new ResponseEntity<PostDTO>(postService.updatePost(id,p),HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<PostDTO> deletePostMapping(@PathVariable Integer id) throws PostException {
		return new ResponseEntity<PostDTO>(postService.deletePost(id),HttpStatus.OK);
	}
	
	@PostMapping("/posts/{id}/like")
	public ResponseEntity<PostDTO> likePostMapping(@PathVariable Integer id) throws PostException {
		return new ResponseEntity<PostDTO>(postService.likePost(id),HttpStatus.OK);
	}
	@PostMapping("/posts/{id}/unlike")
	public ResponseEntity<PostDTO> unlikePostMapping(@PathVariable Integer id) throws PostException {
		return new ResponseEntity<PostDTO>(postService.unlikePost(id),HttpStatus.OK);
	}
	@GetMapping("/analytics/posts")
	public ResponseEntity<Integer> getTotalPostMapping() throws PostException {
		return new ResponseEntity<Integer>(postService.TotalPost(),HttpStatus.OK);
	}
	@GetMapping("/analytics/posts/top-liked")
	public ResponseEntity<List<PostDTO>> getTopPostMapping() throws PostException {
		return new ResponseEntity<List<PostDTO>>(postService.Top5Post(),HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDTO>> getAllPostsMapping() throws PostException {
		return new ResponseEntity<List<PostDTO>>(postService.getAllPosts(),HttpStatus.OK);
	}
	
}
