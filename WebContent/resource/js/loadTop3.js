/**
 * 
 */
$(document).ready(function(){
    var url = window.location.href;
    if(url.indexOf("index/")!=-1||url.indexOf("news/")!=-1||url.indexOf("article/")!=-1||
        url.indexOf("picture/")!=-1||url.indexOf("music/")!=-1){
          $.get("/springWEB/index/topThreeArticle",
            function(data,satus){
            for(var i = 0 ; i < data.length ; i++){
                var temp = "<a href=/springWEB/article/id="+data[i].id+">"+data[i].title+"</a><br />";
                $(".titledown").eq(1).append(temp);
            }
          })
     }else{
          $.get("index/topThreeArticle",
            function(data,satus){
            for(var i = 0 ; i < data.length ; i++){
                console.log(data[i].id)
                var temp = "<a href=article/id="+data[i].id+">"+data[i].title+"</a><br />";
                $(".titledown").eq(1).append(temp);
             }})
     
 }

})