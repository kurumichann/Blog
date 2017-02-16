package com.Blog.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Blog.persistence.Blog_dao;

@Configuration
public class BeanConfig {
	
	@Bean
	public Blog_dao blog_dao(){
		return new Blog_dao();
	}
}
