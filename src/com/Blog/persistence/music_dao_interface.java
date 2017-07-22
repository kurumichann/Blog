package com.Blog.persistence;

import java.util.List;
import java.util.Map;

public interface music_dao_interface{
    
	
	 public List<Map<String, Object>> getMusic();
	 public int genertateKey();	 
	 public void addMusic(music music);
}
