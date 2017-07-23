package com.Blog.persistence;

public class article {
      private String title;
      private String content;
      private String img;
      private String author;
      private String category;
      private String time;
      private int id;
      private int totalCount;
      
      
    public String getCategory() {
		return category;
	}
    public void setCategory(String category) {
		this.category = category;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public article(){
		
	}
	public article(String title, String content, String img, String author, String time, int id) {
		super();
		this.title = title;
		this.content = content;
		this.img = img;
		this.author = author;
		this.time = time;
		this.id = id;
	}
	

}
