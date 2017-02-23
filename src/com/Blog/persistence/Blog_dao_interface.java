package com.Blog.persistence;

import java.util.List;
import java.util.Map;


public interface blog_dao_interface{

	public int getTotalCount();
    public List<Map<String, Object>> loadHomeArticle();
    public List<Map<String, Object>> loadHomeArticle(int page,String sort);
    public List<Map<String, Object>> GetArticleByTime(); 
    public List<Map<String, Object>> changePage(int page,String sort);
    public void newArticle(article article);
    public void deleteArticle(String id);
    public void deleteComment(String id);
    public List<Object> searchArticle(String keyword);	
    public List<Object> getTop3();
    public List<Object> getComments(int id);
    public void Comments(comment comment);
    public List<Map<String, Object>> searchArticleById(int id);
    
}
    

