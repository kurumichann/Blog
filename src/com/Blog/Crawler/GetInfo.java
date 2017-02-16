package com.Blog.Crawler;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetInfo {
	
	ArrayList<News> articleArray = new ArrayList<>();
	News article;
	Document parser;
	
	public ArrayList<News> getArti(ArrayList<String> urls){
		int counter = 0;
		for(String url : urls){
		try {
			parser = Jsoup.connect(url).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			continue;
		}
		Elements temp;
		article = new News();
        //title
		article.setTitle(parser.select("div.entry-header").text().trim());
		System.out.println(++counter+" title: "+article.getTitle());
		//author
		temp = parser.select("div.copyright-area");
		
		if(temp.eq(1).isEmpty()){
			article.setAuthor(temp.eq(0).text().replaceAll("&nbsp;", " ").trim());
		}
		else{
			article.setAuthor((temp.eq(0).text()+"-"+temp.eq(1).text()).replaceAll("&nbsp;", " ").trim());
		}
		System.out.println(counter+" author: "+article.getAuthor());
		//time
		article.setCreateTime(parser.select("p.entry-meta-hide-on-mobile").text().substring(0,11).trim());
		System.out.println(counter+" time: "+article.getCreateTime());
		//content
		article.setContent(parser.select("div.entry:gt(1)").text().replace(article.getAuthor(), "")
				.trim());
		
		System.out.println(counter+" content: "+article.getContent());
		articleArray.add(article);
	}
		return articleArray;
	}

}
