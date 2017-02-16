package com.Blog.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.Blog.persistence.Picture;
import com.Blog.persistence.picture_dao;

public class Picture_service {
	
	@Autowired
	private picture_dao dao;
	public List<Map<String,Object>> getInfo(){
		return  dao.getInfo();
	}
	public void AddPicture(Picture picture){
		dao.setPicture(picture);
		
	}
	public int likePicture(String authorName,String image){
		return dao.likePicture(authorName,image);
	}

}
