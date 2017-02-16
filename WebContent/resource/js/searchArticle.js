/**
 * 
 */
$(function(){
    $("#search_keyword").focus(function() {
        //animate()
        $(this).attr("placeholder","").animate({width:"200px"}, 400);                   
       }
       )
        $("#search_keyword").bind('keyup', function(event){           
            if(event.which=="13"&&$(this).val()!="")
            {
            	 console.log($("#search_keyword").val())
               if(window.location.href.indexOf("index")!=-1){      
                 $.get("searcharticle="+$("#search_keyword").val(),
                       function(data,textStatus){ //callback                       
                           $("article").remove();
                           $("#pages_ul").remove();
                           var returnHome = "<h id = returnHome><a href = 'index'>返回</a></h>";
                           for(var i = 0 ; i < data.length ; i++){
                               generateArticle(data[i]);
                           }
                           if(!$("#returnHome").is(':visible')){
                           $("#articles").append(returnHome);
                           }
                           $("#returnHome").css("margin-left",($("#con").width()-$("#returnHome").width())/2);
                       },"json"
                
                 )
                }else if(window.location.href.indexOf("news")!=-1){
                      $.get("searchnews="+$("#search_keyword").val(),
                       function(data,textStatus){ //callback                       
                           $("article").remove();
                           $("#pages_ul").remove();
                           var returnHome = "<h id = returnHome><a href = 'index'>返回</a></h>";
                           for(var i = 0 ; i < data.length ; i++){
                               generateArticle(data[i]);
                           }
                           if(!$("#returnHome").is(':visible')){
                           $("#articles").append(returnHome);
                           }
                           $("#returnHome").css("margin-left",($("#con").width()-$("#returnHome").width())/2);
                       },"json"
                       )
               }
            }         
                 
        });
        
        $("#search_keyword").blur(function() {     
        $(this).animate({width:"100px"}, 400).attr("placeholder","搜索");
        });

}

)
function generateArticle(data){
　　　　 if(data.img　!= null){   
           var article = 
            "<article class='article'>"+"<a class='arti_h'>"+data.title+"</a>"+"<div class='arti_info'>"+                           
              "由<h>"+data.author+"在"+getLocalTime(data.time)+"</h>"+
             "<div class='arti_img'>"+"<img src='resource/article_img/"+data.img+"'/><h1>"+data.content+"</h1></div><footer><hr></hr></footer></article>";
           }else{
              var article = 
            "<article class='article'>"+"<h2 class='arti_h'>"+data.title+"</h2>"+"<div class='arti_info'>"+                           
             "由<a class='author' >"+data.author+"</a>在<a>"+getLocalTime(data.time)+"</a>"+
             "<div class='arti_img'><h1>"+data.content+"</h1></div><footer><hr></hr></footer></article>";
           }
         $("#articles").append(article);
         $("#articles").css({
             "width":"731px",
         })
}
function getLocalTime(unixTime) {
        var time = new Date(unixTime);
        var ymdhis = "";
        ymdhis += time.getUTCFullYear() + "-";
        ymdhis += (time.getUTCMonth()+1) + "-";
        ymdhis += time.getUTCDate();
        ymdhis += " " + time.getHours() + ":";
        ymdhis += time.getUTCMinutes() + ":";
        ymdhis += time.getUTCSeconds();
        return ymdhis;
 }   