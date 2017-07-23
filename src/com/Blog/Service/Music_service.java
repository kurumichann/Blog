package com.Blog.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.Blog.persistence.music;
import com.Blog.persistence.music_dao_interface;

public class Music_service {
	
	@Autowired
    music_dao_interface dao;
	public List<Map<String, Object>> getInfo(){
		return dao.getMusic();
	}
	public void saveMusic(music music){
		int id = dao.genertateKey();
		music.setId(id+1);
		dao.addMusic(music);
	}
}
