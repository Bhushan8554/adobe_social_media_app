package com.adobe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.catalina.startup.AddPortOffsetRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adobe.exceptions.PostException;
import com.adobe.exceptions.UserException;
import com.adobe.model.Post;
import com.adobe.model.PostDTO;
import com.adobe.repository.PostRepository;
import com.adobe.repository.UserRepository;
import com.adobe.service.PostService;
import com.adobe.service.UserService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SocialMediaAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	PostService postService;
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;

}
