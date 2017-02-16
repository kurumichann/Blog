package com.Blog.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Blog.Service.User_service;

@Controller
@RequestMapping(value = {"/management"})
public class ManagmentController {
	
	@Autowired
	User_service userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String AllUsers(Map<String,Object> model){
		System.out.println(userService.getUsers());
		model.put("users", userService.getUsers());
		
		return "management";
	}

}
