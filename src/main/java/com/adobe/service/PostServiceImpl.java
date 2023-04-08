package com.adobe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adobe.exceptions.PostException;
import com.adobe.exceptions.UserException;
import com.adobe.model.PostDTO;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO deletePost(Integer id) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO updatePost(Integer id) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO getPost(Integer id) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO likePost(Integer id) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO unlikePost(Integer id) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer TotalPost() throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> Top5Post() throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

}
