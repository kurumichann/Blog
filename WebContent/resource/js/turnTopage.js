/**
 * 
 */
$(document).ready(function(){
    if(window.location.href.indexOf("index")!=-1){
      $.get("index_page=",
          function(data,textStatus){
            setPagenavigation(data);
        })
    }else{
      $.get("news_page=",
          function(data,textStatus){
            setPagenavigation(data);
        })
    }
    setNowPage(window.location.href);
})
function turnTopage(page)
{

    var url = window.location.href.toString();
        if (url.indexOf("index")!=-1) {
           if (url.indexOf("timeasc") != -1) {
               window.location.href = "/springWEB/index/page=" + page + "timeasc";
              } else {
               window.location.href = "/springWEB/index/page=" + page + "timedesc";
             }
         }else {
        if(url.indexOf("news")!=-1){
            window.location.href = "/springWEB/news/page=" + page;
        }
    }
    
		
}
function setPagenavigation(page){
    var maxPage = Math.ceil(page/9);
    $("#totalPage")
    .text(maxPage)
    .attr("onclick","turnTopage("+maxPage+")");
    //小于6页全部显示，否则只显示前部分和后部分页数
    if(maxPage<6){       
        for(var i = 1 ; i < maxPage+1 ; i++){
            var li = "<li><a onclick=turnTopage("+i+")>"+i+"</a></li>";
            $("#pages_ul").append(li);
           }
    }else{
        for(var i = 1 ; i < 5 ; i++){
            var li = "<li><a onclick=turnTopage("+i+")>"+i+"</a></li>";
            $("#pages_ul").append(li);
           }
           $("#pages_ul").append("<li>...</li>");
        for(var i = maxPage-4 ; i < maxPage+1 ; i++){
            var li = "<li><a onclick=turnTopage("+i+")>"+i+"</a></li>";
            $("#pages_ul").append(li);
           }
    }
}
/*
 * set current page according to url
 */
function setNowPage(str){
    var length = str.length;
    var begin = str.indexOf("page=");
    if(begin == -1){
    	return;
    }
    var temp = "";
    for( var i = begin ; i < length ; i++){
      if(str.charCodeAt(i) >= 49 && str.charCodeAt(i) <= 57){
        temp += str.charAt(i);
      }
    }
    $("#nowPage").text(temp);
}
