package com.adobe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adobe.exceptions.PostException;
import com.adobe.exceptions.UserException;
import com.adobe.model.PostDTO;
import com.adobe.model.UserDTO;

@Service
public interface PostService {

	public PostDTO addPost(PostDTO p,Integer u_id)throws PostException,UserException;
	
	public PostDTO deletePost(Integer id)throws PostException;
	
	public PostDTO updatePost(Integer id)throws PostException;
	
	public PostDTO getPost(Integer id)throws PostException;
	
	public PostDTO likePost(Integer id)throws PostException;
	
	public PostDTO unlikePost(Integer id)throws PostException;
	
	public Integer TotalPost()throws PostException;
	
	public List<UserDTO> Top5Post()throws PostException;
	
}
