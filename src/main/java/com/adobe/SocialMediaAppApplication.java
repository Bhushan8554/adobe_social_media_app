package com.adobe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adobe.service.PostService;
import com.adobe.service.PostServiceImpl;
import com.adobe.service.UserService;
import com.adobe.service.UserServiceImpl;

@SpringBootApplication
public class SocialMediaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaAppApplication.class, args);
	}


    @Bean
    UserService getUserService() {
        return new UserServiceImpl();
    }
    
    @Bean
    PostService getPostService() {
    	return new PostServiceImpl();
    }
}
