package com.Blog.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blog.persistence.article;
import com.Blog.persistence.blog_dao_interface;
import com.Blog.persistence.comment;
@Service
public class Blog_service {
	private blog_dao_interface dao = null;
@Autowired
	public void setDao(blog_dao_interface dao) {
		this.dao = dao;
	}
    @Transactional(readOnly = true)
    public List<Map<String, Object>>  turnTopage( @Param("page") int page,@Param("sort") String sort)
    {
   
    	return dao.loadHomeArticle(page,sort);
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
    public void deleteArticle(String id,String filename) {
    	
    	if(filename!=null){
			File img = new File("/eclipse/workspace/Blog/WebContent/resource/article_img/"+filename);
			img.delete();
		}
		dao.deleteArticle(id);
		dao.deleteComment(id);
		
	}
    public List<Object>  searchArticle(String keyword)
    {
   
    	return dao.searchArticle(keyword);
    }
    public int getTotalCount(){
    	return dao.getTotalCount();
    }
    public List<Object> getTop3(){
    	return dao.getTop3();
    }
    public List<Object> getComment(int id){
    	return dao.getComments(id);
    }
    public List<Object> Comments(comment comment){
    	dao.Comments(comment);
    	int id = comment.getId();
    	return dao.getComments(id);
    }
    public List<Map<String, Object>> getInfoById(int id){
    	return dao.searchArticleById(id);
    }

}
