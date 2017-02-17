package com.Blog.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.Blog.persistence.news_dao;

public class News_service {

	@Autowired
	news_dao dao;
	
	public List<Map<String, Object>> loadNews() {
		return dao.loadNews();
	}
	
	public int getTotalCount(){		
		return dao.getTotalCount();
	}
	
	public List<Map<String, Object>> loadNewsbyPage(int page) {	
	    return dao.changePage(page);
	}
	public List<Map<String, Object>> searchArticle(String keyword) {	
	    return dao.searchNews(keyword);
	}
}
