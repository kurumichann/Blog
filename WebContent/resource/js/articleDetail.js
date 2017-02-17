  /**
   * 
   */
window.onload = function(){
    console.log($("#con").width()+" "+$(".arti_img").children("img").width())
    var commentfeild = "<input id = commentfield placeholder = 点击回复 />"
    var comments = "<div class = comments>";

    $.get("getcomment_id="+$("#articles h[id]").attr("id"),
      function(data,status){
       for(var i = 0 ; i < data.length ; i++){              
        comments += "<div class = comment><div class = info><h>"
        +data[i].author+"在"+getLocalTime(data[i].time)+"评论：</h></div>"+
        "<div class = content><h>&nbsp;"+data[i].comment+"</h></div></div>"; 

      }
      comments += "</div>";
      console.log(comments)
      $("#articles")
      .css({
        "width":"500px",
        "margin-right": "150px",
      })
      .append(comments)
      .append(commentfeild);
      style();
      shareToQQzone()
    }
    )       


  }
   function style(){
    $("h[id]").css({
      "font-size":"25px",
      "color":"white",
    })
    $("#commentfield")
    .css({
      "background-color": "rgba(97,97,97,0.5)",
      "border-width": "1px",
      "border-color": "rgb(169, 169, 169)",
      "border-style": "solid",
      "width":"150px",
    })
    .focus(function() {
      $(this).attr("placeholder","").animate({width:"230px"}, 400);                   
    }
    )
    .blur(function() {     
      $(this).attr("placeholder","点击回复").animate({width:"150px"}, 400);
    })
    .bind('keyup', function(event){           
      if(event.which=="13"&&$(this).val()!="")
      {
       $.get("comment="+$(this).val()+"&&id="+$("#articles h[id]").attr("id"),
        function(data,status){          
          if(typeof(data[0].author)!="undefined"){  
           $("#commentfield")
           .val("")
           .animate({width:"150px"}, 400)
           .before("<div class = comment><div class = info><h>"
            +data[0].author+"在"+getLocalTime(data[0].time)+"评论：</h></div>"+
            "<div class = content><h>&nbsp;"+data[0].comment+"</h></div></div>");
         }else{
          alert("请登录")
        }
      })
     }
   })
  }
  function getLocalTime(unixTime) {
    var time = new Date(unixTime);
    var ymdhis = "";
    ymdhis += time.getUTCFullYear() + "-";
    ymdhis += (time.getUTCMonth()+1) + "-";
    ymdhis += time.getUTCDate();
    ymdhis += " " + time.getUTCHours() + ":";
    ymdhis += time.getUTCMinutes() + ":";
    ymdhis += time.getUTCSeconds();
    return ymdhis;
  }
  function shareToQQzone(){
    var p = {
      url:location.href,
      showcount:'1',/*是否显示分享总数,显示：'1'，不显示：'0' */
      desc:'',/*默认分享理由(可选)*/
      summary:$("#arti_img h1").text(),/*分享摘要(可选)*/
      title:$("#articles h1").text(),/*分享标题(可选)*/
      site:'',/*分享来源 如：腾讯网(可选)*/
      pics:'Blog/'+$(".arti_img img").attr("src"), /*分享图片的路径(可选)*/
      style:'202',
      width:105,
      height:31
    };
    var s = [];
    for(var i in p){
      s.push(i + '=' + encodeURIComponent(p[i]||''));
    }
    $(".arti_img").append(['<a version="1.0" class="qzOpenerDiv" href="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?',s.join('&'),'" target="_blank">分享到空间</a>'].join(''));
  };

    
