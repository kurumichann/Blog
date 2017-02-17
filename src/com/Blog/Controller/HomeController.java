package com.Blog.Controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.Blog.Service.Blog_service;
import com.Blog.imgCompress.imgCompress;
import com.Blog.persistence.User;
import com.Blog.persistence.article;
import com.Blog.persistence.comment;


@Controller
public class HomeController {
   public static final int DEFUALT_BLOG_PER_PAGE = 25;
   private Blog_service blog_service ;
   private imgCompress imgcompress;
   @Autowired
   public HomeController(Blog_service blog_service,imgCompress imgcompress)
   { 
	   this.blog_service = blog_service;
	   this.imgcompress = imgcompress;
   }
   
	@Autowired
	private  HttpSession session;
	
   @RequestMapping(value={"/index"},method = RequestMethod.GET)
   public String showHomePage(Map<String,Object> limitedmodel,
		   Map<String,Object> allmodel,Map<String,Object> articlemodel,Map<String,Object> usermodel)
   {
	   allmodel.put("datas",blog_service.getLatestArticle());
	   usermodel.put("userdata", new User());
	   articlemodel.put("article", new article());
	   return "index";
   }
   @RequestMapping(value = {"index/page={pagenumber}"+"time"+"{sort}","index/page={pagenumber}"+"time"+"{sort}"})
   public String changePage(@PathVariable int pagenumber ,@PathVariable String sort,
		   Map<String,Object> limitedmodel,Map<String,Object> articlemodel)
   {
	   
	   if(!(sort.equals("asc")||sort.equals("desc")))
		   return "index";
	   System.out.println("Change Page to "+pagenumber);
	   limitedmodel.put("datas",blog_service.turnTopage(pagenumber,sort));
	   articlemodel.put("article", new article());
	   return "index";
	   
   }
   
   @RequestMapping(value={"index/page={pagenumber}"+"time"+"{sort}","index"},method = RequestMethod.POST)
   public String addNewArticleFromform(article article,Map<String,Object> limitedmodel,
		   Map<String,Object> articlemodel,
		   @RequestParam(value="arti_img",required=false) MultipartFile image)
   {

	   System.out.println("addNewArticleFromform");
	   article.setImg(session.getAttribute("authorName")+"-"+article.getTitle()+"."+image.getContentType().subSequence(6, image.getContentType().length()));
	   article.setAuthor(session.getAttribute("authorName").toString());
	   if(image.getContentType().subSequence(6, image.getContentType().length()).equals("ation/octet-stream"))
	   {
		   article.setImg("null");
 
	   }else
	   {
		   try{
/*		   File file = new File("/eclipse/workspace/springweb/WebContent/resource/article_img/"+article.getImg());
		   System.out.println(file.getAbsolutePath());
		   FileUtils.writeByteArrayToFile(file,image.getBytes());*/
		   imgcompress.setImg(image);
		   System.out.println(getClass().getResource("/").getFile().toString().replace("WEB-INF/classes/", "resource/article_img"));
		   imgcompress.resizeFix(500,400, getClass().getResource("/").getFile().toString().replace("WEB-INF/classes/", "resource/article_img"), article.getImg());
	     }catch(IOException e)
	     {
		  e.printStackTrace();
	     }
	     /**end upload img**/
	   }
	   blog_service.createArticle(article);
	   limitedmodel.put("datas",blog_service.getLatestArticle());
	   articlemodel.put("article", new article());
	   return "redirect:/index";
   }
   
   @RequestMapping("/deleteArticleid={id}&&img={img}")
   public String deleteArticleFromPage(@PathVariable String id,@PathVariable String img,Map<String,Object> limitedmodel
		   ,Map<String,Object> articlemodel)
   {
	   blog_service.deleteArticle(id , img);
	   return "redirect:/index";
   }   
   
   @RequestMapping(value={"searcharticle={keyword}","index/searcharticle={keyword}"})
   @ResponseBody
   public List<Map<String,Object>> searchArticle(@PathVariable String keyword)
   {
	   System.out.println("search for article "+keyword);
	   return blog_service.searchArticle(keyword);
   }
   
   @RequestMapping(value={"article/getcomment_id={keyword}","index/article/getcomment_id={keyword}"})
   @ResponseBody
   public List<Map<String,Object>> getComments(@PathVariable int keyword)
   { 	  
	   return  blog_service.getComment(keyword) ;
   }  
   
   @RequestMapping(value = {"article/id={keyword}","index/article/id={keyword}"})
   public String getArticleDetail(@PathVariable int keyword , Map<String,Object> model)
   {
	   model.put("datas", blog_service.getInfoById(keyword));
	   return "article";
   }   
   
   @RequestMapping(value = {"index/index_page=","index_page="})
   @ResponseBody
   public int countOfPage(){	   
	   return blog_service.getTotalCount();
   }
   
   @RequestMapping(value = {"index/topThreeArticle",
		   "topThreeArticle","index/article/topThreeArticle","article/topThreeArticle"})
   @ResponseBody
   public List<Map<String,Object>> top3(){	   
	   System.out.println(blog_service.getTop3());
	   return blog_service.getTop3();
   }
   
   @RequestMapping(value = {"index/article/comment={comment}&&id={id}","article/comment={comment}&&id={id}"})
   @ResponseBody
   @PreAuthorize("hasAnyRole({'manager','general'})")
   public List<Map<String,Object>> Setcomment(@PathVariable String comment , @PathVariable int id){	  
	   comment minrui = new comment();
	   minrui.setAuthor(session.getAttribute("authorName").toString());
	   minrui.setId(id);
	   minrui.setComment(comment);
	   return blog_service.Comment(minrui);
   }

   
   
}
