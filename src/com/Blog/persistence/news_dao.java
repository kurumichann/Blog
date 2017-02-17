package com.Blog.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Blog.Crawler.News;

public class news_dao implements news_dao_interface{

	@Autowired
	JdbcTemplate jdbcTemp;
	@Autowired
	private News news;
	@Override
	public int getTotalCount() {
		String sql = "SELECT count(title) from news";
		return jdbcTemp.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Map<String, Object>> loadNews() {
		String sql = "SELECT title,img,time,content,author FROM news";	
		return jdbcTemp.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> changePage(int page) {
		String sql = "SELECT title,time,img,content,author FROM news LIMIT "+((page-1)*9)+",9";
		return jdbcTemp.queryForList(sql);
	}

	@Override
	public void newNews(article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNews(String authorName, String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> searchNews(String keyword) {
		String sql = "SELECT title,time,content,author,img FROM news where title = ?";		
		return jdbcTemp.queryForList(sql, keyword);
	}

	@Override
	public void addNews(News news) {
		String sql = "INSERT INTO news title,time,content,author,img FROM news where title = ?";
		
	}

}
