package com.Blog.persistence;


public class User {

	private String username = null;
	private String password = null;
	private String createtime = null;
	private String maileaddress = null;
	private String gender = null;
	private String Img = null;
	private String authority = "general";
	private String status = "true";
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getMailaddress() {
		return maileaddress;
	}
	public void setMailaddress(String mailAddress) {
		this.maileaddress = mailAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String Img) {
		this.Img = Img;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
