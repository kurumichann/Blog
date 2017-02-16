package com.Blog.persistence;

import java.io.File;
<<<<<<< .merge_file_F72Grb
import java.sql.ResultSet;
import java.sql.SQLException;
=======
>>>>>>> .merge_file_IALi98
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
<<<<<<< .merge_file_F72Grb
import org.springframework.jdbc.core.RowMapper;
=======
>>>>>>> .merge_file_IALi98
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class Blog_dao implements Blog_dao_interface {

<<<<<<< .merge_file_F72Grb
	@Autowired
=======
	
>>>>>>> .merge_file_IALi98
	JdbcTemplate jdbctemp = null;
	
	@Autowired
	private article article = null;	
	
<<<<<<< .merge_file_F72Grb
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
=======
	@Autowired
	public JdbcTemplate getjdbctemp() {
		return jdbctemp;
	}
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
    @Autowired
	public void setjdbctemp(JdbcTemplate jdbctemp) {
		this.jdbctemp = jdbctemp;
	}
>>>>>>> .merge_file_IALi98
    
	@Override
	public List<Map<String, Object>> loadHomeArticle() {
		String sql  = "select title,content,img,author,time,id from article order by time desc limit 0,9";
<<<<<<< .merge_file_F72Grb
		return jdbctemp.queryForList(sql);
=======
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(article);
		return jdbctemp.queryForList(sql, paramSource);
>>>>>>> .merge_file_IALi98

	}

	@Override
	public  List<Map<String, Object>> changePage(int page,String sort) {
		// TODO Auto-generated method stub
		if(!(sort.equals("asc")||sort.equals("desc")))
				return null;
		String sql  = "select title,content,img,author,time,id from article order by time "
				+sort+" LIMIT "+((page-1)*9)+",9";
<<<<<<< .merge_file_F72Grb
		List<Map<String, Object>> temp  = jdbctemp.queryForList(sql);
=======
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(article);
		List<Map<String, Object>> temp  = jdbctemp.queryForList(sql, paramSource);
>>>>>>> .merge_file_IALi98
		
		return temp ;
	}

	@Override
	public void newArticle(article article) {
		// TODO Auto-generated method stub
		String sql = "insert into article(title,content,img,author,time,id) values(?,?,?,?,?,?)";
		String sql2 = "select MAX(id) from article";
		article.setTime(format.format(new Date()));
		article.setId(jdbctemp.queryForObject(sql2, Integer.class)+1);
		jdbctemp.update(sql,article.getTitle(),article.getContent()
				,article.getImg(),article.getAuthor(),article.getTime(),article.getId() );
		
	}
 
	@Override
	public void deleteArticle(String id , String imgName) {
		String sql = "delete  from article where id = ?";
		String sql2 = "delete  from article_comment where id = ??";
		
		File img = new File("/eclipse/workspace/springweb/WebContent/resource/article_img/"+imgName);
		img.delete();
		jdbctemp.update(sql,id);
		
		
	}
	@Override
	public synchronized int getTotalCount() {
		String sql = "SELECT COUNT('id') FROM article";
		return jdbctemp.queryForObject(sql, Integer.class)+1;
	}
	@Override
	public List<Map<String, Object>> searchArticle(String keyword) {
		// TODO Auto-generated method stub
		String sql = "select title,content,img,author,time,id from article  where title = ? order by time desc";
		List<Map<String, Object>> article  = jdbctemp.queryForList(sql, keyword);
<<<<<<< .merge_file_F72Grb
=======
		System.out.println(article);
>>>>>>> .merge_file_IALi98
		return article;
		
	}

	@Override
	public List<Map<String, Object>> GetArticleByTime() {
		// TODO Auto-generated method stub
		String sql = "select title,content,img,author,time,id from article order by time asc";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(article);
		return jdbctemp.queryForList(sql, paramSource);
	}

	@Override
	public List<Map<String, Object>> getTop3() {
		String sql  = "select title,id from article order by time desc limit 0,3";
		return jdbctemp.queryForList(sql);

	}

	@Override
	public List<Map<String, Object>> getComments(int id) {
		String sql = "select author,comment,time from article_comment where id = ?";
		return jdbctemp.queryForList(sql, id);
	}

	@Override
	public List<Map<String, Object>> Comments(comment comment) {
		comment.setTime(format.format(new Date()));
		String sql = "insert into article_comment(author,id,time,comment) values(?,?,?,?)";
		String sql2 = "select author,comment,time from article_comment where id = ? and author = ? and time = ?";
		jdbctemp.update(sql, comment.getAuthor(),comment.getId(),comment.getTime(),comment.getComment());
<<<<<<< .merge_file_F72Grb
=======
		System.out.println(jdbctemp.queryForList(sql2, comment.getId(),comment.getAuthor(),comment.getTime()));
>>>>>>> .merge_file_IALi98
		return jdbctemp.queryForList(sql2, comment.getId(),comment.getAuthor(),comment.getTime());
	}

	@Override
	public List<Map<String, Object>> searchArticleById(int id) {
		String sql = "select author,time,content,img,id,title from article where id = ?";
		return jdbctemp.queryForList(sql, id);
	}
	
}

