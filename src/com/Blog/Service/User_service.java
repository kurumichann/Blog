package com.Blog.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.Blog.persistence.User;
import com.Blog.persistence.user_dao;

public class User_service {
	private user_dao userDao;
    
	public void registerUser(User user)
	{
		userDao.register(user);
	}
	public user_dao getUserDao() {
		return userDao;
	}
    @Autowired
	public void setUserDao(user_dao userDao) {
		this.userDao = userDao;
	}
	public List<Map<String,Object>> getUsers(){
		return userDao.getAllUsers();
	}
    public int checkUser(String username){
    	return userDao.checkUser(username);
    }

}
