package com.Blog.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.Blog.Service.Picture_service;
import com.Blog.imgCompress.imgCompress;
import com.Blog.persistence.picture;

@Controller
@RequestMapping("/picture")
public class PictureController {
	
    private Picture_service pictureService;
    private imgCompress imgcompress;
 	@Autowired	
 	private  HttpSession session;
    @Autowired
    public PictureController(Picture_service pictureService,imgCompress imgcompress) {
    	this.pictureService = pictureService;
    	this.imgcompress = imgcompress;
	}
    
    @RequestMapping(method = RequestMethod.GET)
	public String showPicture(Map<String, Object> picturemodel,Map<String, Object> formModel)
	{
	    picturemodel.put("pictures", pictureService.getInfo());
	    formModel.put("picture", new picture());
	    return "picture";
		
	}
        
    @RequestMapping(value = "/good_{imageid}",method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAnyRole({'manager','general'})")
	public int likePicture(@PathVariable int imageid)
	{
	    return  pictureService.likePicture(imageid,session.getAttribute("authorName").toString());
		
	}
     
    @RequestMapping(method = RequestMethod.POST)
	public String savePicture(picture picture,@RequestParam(value="picture") MultipartFile img,
			Map<String, Object> picturemodel,Map<String, Object> formModel)
	{
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		 if(img.getContentType().subSequence(6, img.getContentType().length()).equals("ation/octet-stream")){	
			 
		   }
		 else{
			   picture.setCreateTime(format.format(new Date()));
			   picture.setUser(session.getAttribute("authorName").toString());
			   picture.setImg(session.getAttribute("authorName")+"-"+picture.getCreateTime()+"."
			   +img.getContentType().subSequence(6, img.getContentType().length()));
			   picture.setGood(0);
			   try {
				imgcompress.setImg(img);
				imgcompress.resizeFix(500,400, 
						getClass().getResource("/").getFile().toString().replace("WEB-INF/classes/", "resource/picture"), picture.getImg());
			   } catch (IOException e) {
				e.printStackTrace();
			    }

		       }
		    pictureService.AddPicture(picture);
		    picturemodel.put("pictures", pictureService.getInfo());
		    formModel.put("picture", new picture());
		return "redirect:/picture";
		
	}
}
