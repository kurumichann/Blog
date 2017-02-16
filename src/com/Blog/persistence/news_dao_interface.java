package com.Blog.persistence;

import java.util.List;
import java.util.Map;

import com.Blog.Crawler.News;

public interface news_dao_interface {
	public int getTotalCount();
    public List<Map<String, Object>> loadNews(); 
    public List<Map<String, Object>> changePage(int page);
    public void newNews(article article);
    public void deleteNews(String authorName,String title);
    public List<Map<String, Object>> searchNews(String keyword);
    public void addNews(News news);

}
