package com.Blog.persistence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class user_dao implements user_dao_interface{
    @Autowired
	
    User user = null;
    
	@Autowired
	private JdbcTemplate simplejdbc = null;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	public JdbcTemplate getSimplejdbc() {
		return simplejdbc;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setSimplejdbc(JdbcTemplate simplejdbc) {
		this.simplejdbc = simplejdbc;
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		 user.setCreatetime(format.format(new Date()));
		 String sql =  "insert into user(username,password,gender,mailaddress,registertime,authority,status) values(?,?,?,?,?,?,?)";
         simplejdbc.update(sql,user.getUsername(),user.getPassword(),user.getGender(),user.getMailaddress(),user.getCreatetime(),user.getAuthority(),user.getStatus());
	}
	@Override
	public List<Map<String, Object>> getAllUsers() {
		String sql = "select username,password,gender,mailaddress,registertime,authority,status from user";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		return simplejdbc.queryForList(sql,paramSource);
	}
	@Override
	public int checkUser(String username) {
		String sql = "select count(1) from user where username = ?";		
		return simplejdbc.queryForObject(sql, Integer.class, username);
	}
}
