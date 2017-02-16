$(document).ready(function(){
	$("#mainList li").eq(0).click(function(){
		window.location.href="/springWEB/index";		
	})
	$("#mainList li").eq(1).click(function(){
        window.location.href="/springWEB/picture";     
    })
	$("#mainList li").eq(2).click(function(){
        window.location.href="/springWEB/music";     
    })
    $("#mainList li").eq(3).click(function(){
        window.location.href="/springWEB/news";    
    })
	$("#mainList li").hover(
	    function(){
	    $(this).css({"backgroundColor":"white","fontWeight":"bolder"});
	    },
	    function(){
	        $(this).css({"backgroundColor":"transparent","fontWeight":"normal"});
	    })
	})
	
