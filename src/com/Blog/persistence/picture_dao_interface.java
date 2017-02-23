package com.Blog.persistence;

import java.util.List;
import java.util.Map;

public interface picture_dao_interface {

	public List<Map<String, Object>> getPicture();
    public void addPicture(picture picture);
    public int likePicture(int id,String user);
    public void setGood(int id);
    public int getGood(int id);

}
