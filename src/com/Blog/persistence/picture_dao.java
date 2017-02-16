package com.Blog.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class picture_dao implements Picture_interface{
	
<<<<<<< .merge_file_YqTT9f
	JdbcTemplate jdbcTemplate = null;
	@Autowired
	public void setjdbcTemplate(JdbcTemplate jdbcTemplate)
=======
	JdbcTemplate simplejdbc = null;
	@Autowired
	public void setSimplejdbc(JdbcTemplate simplejdbc)
>>>>>>> .merge_file_Mbk3fV
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Map<String,Object>> getInfo() {
		// TODO Auto-generated method stub
		String sql = "select img,user,content,createTime,good,id from picture";
		return jdbcTemplate.queryForList(sql);	
	}
	
	@Override
	public void setPicture(Picture picture) {
		// TODO Auto-generated method stub
		String sql1 = "SELECT MAX(id) FROM picture";
<<<<<<< .merge_file_YqTT9f
		int maxId = jdbcTemplate.queryForObject(sql1, Integer.class)+1; 
=======
		int maxId = simplejdbc.queryForObject(sql1, Integer.class)+1; 
>>>>>>> .merge_file_Mbk3fV
		String sql2 = "insert into picture set img = ?,content = ?,user = ?,createTime = ?,good = ?,id = ?";
		jdbcTemplate.update(sql2, picture.getImg(),picture.getContent(),picture.getUser(),
				picture.getCreateTime(),picture.getGood(),maxId);
	}

	@Override
	public int likePicture(String authorName,String imageName) {
		// TODO Auto-generated method stub
		String sql1 = "insert into pic_good(id,author) values(?,?)";
		try {
			jdbcTemplate.update(sql1, imageName,authorName);
		} catch (Exception e) {
			return -1;
		}
		String sql2 = "update picture set good = good+1 where id = ?";
		jdbcTemplate.update(sql2,imageName);
		String sql3 = "select good from picture where id = ?";
<<<<<<< .merge_file_YqTT9f
		return jdbcTemplate.queryForObject(sql3, Integer.class, imageName);
=======
		return simplejdbc.queryForObject(sql3, Integer.class, imageName);
>>>>>>> .merge_file_Mbk3fV
	}
}
