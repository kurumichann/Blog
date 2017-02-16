/**
 */
$(function(){
	var sort = $("#navi_ul li").first();
	$("#navi_ul").css({"margin-top":"5px"});
	$(sort).siblings().css({"display":"none"});
	$("#navi_ul").hover( function(){
		$(sort).siblings().is(':visible')?$(sort).siblings().css({ "display":"none"}):
			$(sort).siblings().css({ "display":"block"});
	});

	$("#navi_ul>li").hover(function() {
		$(this).css({"background":"#eee"}).siblings().css({"background":""});
		
	})

	$(sort).eq(0).mouseout(function() {
		$(this).css({"background":""});
	});
	
	//add href to li
	$("#navi_ul li").eq(0).click(function() {
	    if(window.location.href.indexOf("index/")!= -1){
	        window.location.href = "page=1timeasc";
	    }else{
	        window.location.href = "index/page=1timeasc";
	    }
		
	});
	$("#navi_ul li").eq(1).click(function() {
        window.location.href = "index_byclick";
    });   
	
})