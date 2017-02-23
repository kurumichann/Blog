package com.Blog.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.Blog.persistence.picture;
import com.Blog.persistence.picture_dao_interface;

public class Picture_service {
	
	@Autowired
	private picture_dao_interface dao;
	public List<Map<String,Object>> getInfo(){
		return  dao.getPicture();
	}
	public void AddPicture(picture picture){
		dao.addPicture(picture);
		
	}
	public int likePicture(@Param("id") int id,@Param("user") String user){
		 try{
			 dao.likePicture(id,user);
			 }catch (Exception e) {
			return -1;
		  }
		 dao.setGood(id);
		 return dao.getGood(id);
	}

}
