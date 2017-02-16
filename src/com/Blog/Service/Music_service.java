package com.Blog.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.Blog.persistence.music;
import com.Blog.persistence.music_dao;

public class Music_service {
	
	@Autowired
    music_dao dao;
	public List<Map<String, Object>> getInfo(){
		return dao.getMusic();
	}
	public void saveMusic(music music){
		 dao.saveMusic(music);
	}
}
