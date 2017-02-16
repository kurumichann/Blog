package com.Blog.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class music_dao implements music_dao_interface {

	JdbcTemplate simplejdbc = null;
    
	@Autowired
	public void setSimplejdbc(JdbcTemplate simplejdbc) {
		this.simplejdbc = simplejdbc;
	}

	@Override
	public List<Map<String, Object>> getMusic() {
		List<Map<String, Object>> info;
		String sql1 = "select * from music inner join music_img on music.id = music_img.id "
				+ "inner join music_src on music.id = music_src.id";
/*		String sql2 = "select id"
		info =  simplejdbc.queryForList(sql1);
		info.addAll(simple.)*/
		System.out.println(simplejdbc.queryForList(sql1));
		return simplejdbc.queryForList(sql1);
	}
	
    synchronized
	public int getId(int id){
		return id+1;
	}
    
	public void saveMusic(music music) {

		String sql1 = "SELECT MAX(id) from music";
		String sql2 = "insert into music set id = ?,title = ?,author = ?,createtime = ?," + "description = ?";
		String sql3 = "insert into music_img set id = ?,img = ?";
		String sql4 = "insert into music_src set id = ?,src = ?";
		int id = getId(simplejdbc.queryForObject(sql1,Integer.class));
		simplejdbc.update(sql2, getId(simplejdbc.queryForObject(sql1,Integer.class)), music.getTitle(), music.getAuthor(),
				music.getCreatetime(), music.getDescription());
		simplejdbc.update(sql3, id, music.getImg());
		for (String temp : music.getSrc())
			simplejdbc.update(sql4, id, temp);

	}

}
