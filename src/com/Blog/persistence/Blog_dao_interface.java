package com.Blog.persistence;

import java.util.List;
import java.util.Map;


public interface Blog_dao_interface {

	public int getTotalCount();
    public List<Map<String, Object>> loadHomeArticle();
    public List<Map<String, Object>> GetArticleByTime(); 
    public List<Map<String, Object>> changePage(int page,String sort);
    public void newArticle(article article);
    public void deleteArticle(String authorName,String title);
    public List<Map<String, Object>> searchArticle(String keyword);	
    public List<Map<String, Object>> getTop3();
    public List<Map<String, Object>> getComments(int id);
    public List<Map<String, Object>> Comments(comment comment);
    public List<Map<String, Object>> searchArticleById(int id);
    
}
    

