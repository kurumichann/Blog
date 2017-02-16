/**
 * 
 */
$(document).ready(function(){ 
    $(".ha").css({
        "width":"246px",
        "height":"80px",
        "position":"absolute",
        "display":"none",
        "top":"20px",
        "z-index":"2",
    })
	$(".good").css({
	    "background-image":"url(resource/img/good.png)",
	    "width":"37px",
	    "height":"30px",
	    "margin-top":"5px",
	    "margin-left":"5px",
	}).click(function(){
	     var father = $(this).parent().parent();
	     var id = father.attr("pic_id")
	     var good = father.find("span");	   
	    $.get("picture/good_"+id,	    
	        function(data,textStatus){
	            if(data.toString() == '-1'){
                   alert("重复点赞");
                }else if(data.toString().indexOf("html")==-1){                  
                    good.text(data);
                }else{
                    alert("请登录");
                }

	         })
	})
	
	$(".con3").css({
	    "background-image":"url(resource/img/comment.png)",
	    "width":"37px",
        "height":"30px",
        "margin-top":"5px",
        "margin-left":"5px",

	})
    $(".pic").children().css({
        "margin-top":"0px",
    })
	$(".box").mouseover(function(){
	    $(this).find(".ha").fadeIn(400);
	}).mouseleave(function(){
	    $(this).find(".ha").fadeOut(400);
	})

	$(".d").css({
	    "position":"relative",
	})
	$(".con2").css({
	})

})