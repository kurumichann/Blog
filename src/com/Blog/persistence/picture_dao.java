package com.Blog.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class picture_dao implements Picture_interface{
	
	@Autowired
	JdbcTemplate jdbcTemplate = null;
	@Autowired
	public void setjdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public List<Map<String,Object>> getInfo() {
		String sql = "select img,user,content,createTime,good,id from picture";
		return jdbcTemplate.queryForList(sql);	
	}
	
	@Override
	public void setPicture(Picture picture) {
		String sql1 = "SELECT MAX(id) FROM picture";

		int maxId = jdbcTemplate.queryForObject(sql1, Integer.class)+1;

		String sql2 = "insert into picture set img = ?,content = ?,user = ?,createTime = ?,good = ?,id = ?";
		jdbcTemplate.update(sql2, picture.getImg(),picture.getContent(),picture.getUser(),
				picture.getCreateTime(),picture.getGood(),maxId);
	}

	@Override
	public int likePicture(String authorName,String imageName) {
		String sql1 = "insert into pic_good(id,author) values(?,?)";
		try {
			jdbcTemplate.update(sql1, imageName,authorName);
		} catch (Exception e) {
			return -1;
		}
		String sql2 = "update picture set good = good+1 where id = ?";
		jdbcTemplate.update(sql2,imageName);
		String sql3 = "select good from picture where id = ?";

		return jdbcTemplate.queryForObject(sql3, Integer.class, imageName);
	}
}
