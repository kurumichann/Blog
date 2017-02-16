package com.Blog.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Blog.Crawler.News;
import com.Blog.Service.News_service;

import sun.print.resources.serviceui;

@Controller
public class NewsController {
	
	@Autowired
    News_service service;	
	
	@RequestMapping({"news"})
	public String showNews(Map<String,Object> newsmodel  , Map<String,Object> newmodel){
		newsmodel.put("datas",service.loadNews()); 
		newmodel.put("news", new News());
		return "news";
	}
	
	@RequestMapping({"news/page={page}"})
	public String showNewsbyPage(@PathVariable int page, Map<String,Object> newsmodel  , Map<String,Object> newmodel){
		newsmodel.put("datas",service.loadNewsbyPage(page)); 
		newmodel.put("news", new News());
		return "news";
	}
	
	@RequestMapping(value = { "news/news_page=", "news_page=" })
	@ResponseBody
	public int countOfPage() {
		return service.getTotalCount();
	}

	@RequestMapping(value = { "searchnews={keyword}"})
	@ResponseBody
	public List<Map<String, Object>> searchArticle(@PathVariable String keyword) {
		System.out.println("search for article " + keyword);
		return service.searchArticle(keyword);
	}
}
