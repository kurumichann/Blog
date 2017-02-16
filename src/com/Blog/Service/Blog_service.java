package com.Blog.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.Blog.persistence.Blog_dao;
import com.Blog.persistence.article;
import com.Blog.persistence.comment;
@Service
public class Blog_service {
	private Blog_dao dao = null;
@Autowired
	public void setDao(Blog_dao dao) {
		this.dao = dao;
	}
    @Transactional(readOnly = true)
    public List<Map<String, Object>>  turnTopage(int page,String sort)
    {
   
    	return dao.changePage(page,sort);
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getLatestArticle()
    {
    	return dao.loadHomeArticle();
    }
    public List<Map<String, Object>> GetArticleByTime()
    {
    	return dao.GetArticleByTime();
    }
    @Transactional()
    public void createArticle(article article)
    {
    	dao.newArticle(article);
    }
    public void deleteArticle(String id , String imgName) {
		dao.deleteArticle(id , imgName);
	}
    public List<Map<String, Object>>  searchArticle(String keyword)
    {
   
    	return dao.searchArticle(keyword);
    }
    public int getTotalCount(){
    	return dao.getTotalCount();
    }
    public List<Map<String, Object>> getTop3(){
    	return dao.getTop3();
    }
    public List<Map<String, Object>> getComment(int id){
    	return dao.getComments(id);
    }
    public List<Map<String, Object>> Comment(comment comment){
    	return dao.Comments(comment);
    }
    public List<Map<String, Object>> getInfoById(int id){
    	return dao.searchArticleById(id);
    }

}
