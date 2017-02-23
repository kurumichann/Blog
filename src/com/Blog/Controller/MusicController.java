package com.Blog.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Blog.Service.Music_service;
import com.Blog.imgCompress.imgCompress;
import com.Blog.persistence.music;

@Controller
public class MusicController {
	
	@Autowired
	Music_service service;
	@Autowired
	private imgCompress imgcompress;
	@Autowired
	private  HttpSession session;
	
    @RequestMapping("music")
	public String Music(Map<String,Object> musicmodel,Map<String,Object> musics){
    	
    	musics.put("musics", service.getInfo());
    	musicmodel.put("music", new music());
    	return "music";
    }
    
    @RequestMapping(value={"/music"},method = RequestMethod.POST)
    public String addNewMusicFromform(music music,Map<String,Object> musics , Map<String,Object> musicmodel,
 		   @RequestParam(value="arti_img",required=false) MultipartFile image)
    {
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 	   music.setImg(session.getAttribute("authorName")+"-"+music.getTitle()+"."+
 	   image.getContentType().subSequence(6, image.getContentType().length()));
 	   System.out.println(session.getAttribute("authorName").toString());
 	   music.setAuthor(session.getAttribute("authorName").toString());
 	   music.setCreatetime(format.format(new Date()));
 	   /**�ж�img�Ƿ�Ϊ��**/
 	   /**start upload img**/
 	   if(image.getContentType().subSequence(6, image.getContentType().length())
 			   .equals("ation/octet-stream"))
 	   {
 		   music.setImg("null");
  
 	   }else
 	   {
 		   try{
 		   imgcompress.setImg(image);
 		   imgcompress.resizeFix(500,400, getClass().getResource("/").getFile().toString().replace("WEB-INF/classes/", "resource/music_img")
 				   , music.getImg());
 	     }catch(IOException e)
 	     {
 		  e.printStackTrace();
 	     }
 	     /**end upload img**/
 	   }
 	   service.saveMusic(music);
   	   musics.put("musics", service.getInfo());
   	   musicmodel.put("music", new music());
 	   return "redirect:/music";
    }

}
