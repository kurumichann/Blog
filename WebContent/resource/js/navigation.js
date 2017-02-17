$(document).ready(function(){
	$("#mainList li").eq(0).click(function(){
		window.location.href="/Blog/index";		
	})
	$("#mainList li").eq(1).click(function(){
        window.location.href="/Blog/picture";     
    })
	$("#mainList li").eq(2).click(function(){
        window.location.href="/Blog/music";     
    })
    $("#mainList li").eq(3).click(function(){
        window.location.href="/Blog/news";    
    })
	$("#mainList li").hover(
	    function(){
	    $(this).css({"backgroundColor":"white","fontWeight":"bolder"});
	    },
	    function(){
	        $(this).css({"backgroundColor":"transparent","fontWeight":"normal"});
	    })
	})
	
