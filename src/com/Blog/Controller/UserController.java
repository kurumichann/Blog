package com.Blog.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.Blog.Service.User_service;
import com.Blog.persistence.User;

@Controller
public class UserController {

	private User_service userService;
	@Autowired
    User user;
	@Autowired
	public UserController(User_service userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.POST,value = {"register","index/register","article/register"})
	public String addUserFromForm(HttpServletRequest request) {
		System.out.println(request.getParameter("username")+
				request.getParameter("password")+request.getParameter("gender")+request.getParameter("mailaddress"));
		user = new User();	
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		user.setMailaddress(request.getParameter("mailaddress"));
		user.setAuthority("ROLE_general");
		user.setStatus("T");
		userService.registerUser(user);
		
		return "redirect:/index";
	}

	public static void saveImage(String fileName, MultipartFile image) {

		try {
			File file = new File("/resource/user_img/" + fileName);
			System.out.println(file.exists());
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			System.out.println(file.exists() + file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/username={username}")
	@ResponseBody
	public int checkuser(@PathVariable String username) {
		System.out.println(username);
		return userService.checkUser(username);
	}

}