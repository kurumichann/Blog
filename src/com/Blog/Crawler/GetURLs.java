package com.Blog.Crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

public class GetURLs {
	String url = "http://www.importnew.com/all-posts";
	@Autowired
	JdbcTemplate simplejdbc;
	Document parser;
	int pages;
	int count;
	ArrayList<String> articles = new ArrayList<String>();
			
    public ArrayList<String> getLinks(String startPage){
    	
    	//get article count
    	try {
			parser = Jsoup.connect(startPage)
					      .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) "
			              + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.7 Safari/537.36").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	pages =  Integer.valueOf(parser.getElementsByClass("page-numbers").eq(4).text());
    	System.out.println(pages);
    	//get all links
    	int i;
    	for(i=1;i<pages+1;i++){
    		try {
    			parser = Jsoup.connect(startPage+"/page/"+i)
    					.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) "
    			        + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.7 Safari/537.36").get();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	for( Element temp :  parser.select("div#archive div.post-meta a.meta-title")){
        		articles.add(temp.attr("href"));
        	}
        	System.out.println(articles.size());
    	}	   	
    	
    	return articles;
    }
    
    public static List<Object[]> turntoarray(List<News> artileentitys){
    	String[] a;
    	List<Object[]> rs = new ArrayList<Object[]>();
    	for(News temp : artileentitys){
    		a = new String[5];
    		a[0]  = temp.getTitle();
    		a[1]  = temp.getAuthor();
    		a[2]  = temp.getCreateTime();
    		a[3]  = temp.getContent();
    		a[4]  = temp.getImg();
    		rs.add(a);    		
    	}
    	System.out.println(rs);
    	return rs;
    }
    
    @Scheduled(cron="* 01 00 * * ? ")
    public void cycletask(){
     	
    	GetInfo a = new GetInfo();
    	List<News> allArticles = new ArrayList<News>();
    	allArticles = a.getArti(new GetURLs().getLinks(url));
    	//ȥ���ظ�����
    	String sql1 = "SELECT title FROM news ORDER BY time ASC LIMIT 0,1 ";
    	String latest = (String) simplejdbc.queryForList(sql1).get(0).get("title");
    	if(latest!=null){
    		for(News temp : allArticles){
    			if(temp.getTitle().equals(latest)){
    				allArticles.subList(0, allArticles.indexOf(temp));
    			}
    		}
    	}
    	String sql2 = "INSERT INTO news(title,author,time,content,img) VALUES(?,?,?,?,?)";
        simplejdbc.batchUpdate(sql2, turntoarray(allArticles));
    }
}
