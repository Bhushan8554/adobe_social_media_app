package com.adobe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adobe.exceptions.PostException;
import com.adobe.exceptions.UserException;
import com.adobe.model.Post;
import com.adobe.model.PostDTO;
import com.adobe.model.User;
import com.adobe.model.UserDTO;
import com.adobe.repository.PostRepository;
import com.adobe.repository.UserRepository;

public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Override
	public PostDTO addPost(PostDTO p, Integer u_id) throws PostException, UserException {

		User user=userRepository.findById(u_id).orElse(null);
		if(user==null) {
			throw new UserException("User not exist with id "+u_id);
		}
		
		Post post=postRepository.findById(p.getId()).orElse(null);
		if(post!=null) {
			throw new PostException("post already exist");
		}
		return new PostDTO( postRepository.save(new Post(p)));
		
	}

	@Override
	public PostDTO deletePost(Integer id) throws PostException {
		Post post=postRepository.findById(id).orElse(null);
		if(post==null) {
			throw new PostException("post not exist with id "+id);
		}
		 postRepository.delete(post);
		return new PostDTO(post);
	}

	@Override
	public PostDTO updatePost(Integer id, PostDTO p) throws PostException {
		Post post=postRepository.findById(id).orElse(null);
		if(post==null) {
			throw new PostException("post not exist with id "+id);
		}
		Post ps=new Post(p);
		 ps.setU(post.getU());
		return new PostDTO(postRepository.save(ps));
	}

	@Override
	public PostDTO getPost(Integer id) throws PostException {
		Post post=postRepository.findById(id).orElse(null);
		if(post==null) {
			throw new PostException("post not exist with id "+id);
		}
		
		return new PostDTO(post);
	}

	@Override
	public PostDTO likePost(Integer id) throws PostException {
		Post post=postRepository.findById(id).orElse(null);
		if(post==null) {
			throw new PostException("post not exist with id "+id);
		}
		post.setLikes(post.getLikes()+1);
		return new PostDTO(postRepository.save(post));
	}

	@Override
	public PostDTO unlikePost(Integer id) throws PostException {
		Post post=postRepository.findById(id).orElse(null);
		if(post==null) {
			throw new PostException("post not exist with id "+id);
		}
		post.setLikes(post.getLikes()-1);
		return new PostDTO(postRepository.save(post));
	}

	@Override
	public Integer TotalPost() throws PostException {
		Integer n=(int) postRepository.count();
		if(n==0) {
			throw new PostException("No posts found");
		}
		return n;
	}

	@Override
	public List<PostDTO> Top5Post() throws PostException {
		List<Post> posts=postRepository.getTop5();
		if(posts.isEmpty()) {
			throw new PostException("no posts found");
		}
		List<PostDTO> u=posts.stream().map(s-> new PostDTO(s)).toList();
		
		return u;
	}

}
