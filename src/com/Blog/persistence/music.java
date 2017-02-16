package com.Blog.persistence;

import java.util.ArrayList;

public class music {
	
	private String title;
	private int id;
	private String createtime;
	private String author;
	private ArrayList<String> src;
	private String comment;
	private String img;
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String desciption) {
		this.description = desciption;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String pic) {
		this.img = pic;
	}
	public void setSrc(ArrayList<String> src) {
		this.src = src;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public ArrayList<String> getSrc() {
		return src;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
