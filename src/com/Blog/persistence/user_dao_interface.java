package com.Blog.persistence;

import java.util.List;
import java.util.Map;

public interface user_dao_interface {
	public void register(User user);
    public List<Map<String,Object>> getAllUsers();
    public int checkUser(String username);
}
