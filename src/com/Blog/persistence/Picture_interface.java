package com.Blog.persistence;

import java.util.List;
import java.util.Map;

public interface Picture_interface {

	public List<Map<String, Object>> getInfo();
    public void setPicture(Picture picture);
    public int likePicture(String userName,String imageName);

}
