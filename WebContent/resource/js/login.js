$(function(){
        //替换login按键,检查登出路径
        if($("#login_user").length>0)
        {
           $("#login_h").remove();
           $("#login_user li").eq(0).children("a").attr("href","/Blog/logout");
        }
        //模态窗口，cover，锁定滚动条
	    $("#login_h").click(function(e){
         var cover = "<div id='dialogbg'></div>";
         $("body").prepend(cover);
         $("#dialogbg")
         .css({
            "width":"100%",
            "height":"100%",
            "background-color":"rgba(0,0,0,0.5)",
            "z-index":"98",
            "position":"absolute",
            "display":"block",
            "filter": "url(blur.svg#blur)",      
            "position":"fixed",
         })  ;
         $(document.body).css("overflow","hidden");
       
         var logindialog = "<div id='modaldialog'>"+"<div id = 'login-register-header'>"+
            "<div id = 'x'></div></div>"+
            "<div id = 'mainform'>"+
            "<form method = 'post' action='/Blog/login'>"+
            "<div id = username><input type='text' name='username' placeholder='Username' /><span id=warn></span></div>"+
            "<div id = password><input type='password' name='password' placeholder='Password'/></div>"+
//            "<input type='hidden' name='${_csrf.parameterName}' value='${_csrf.token}' />"+
            "<button  type='submit' name='submit' value='Login'>登陆</button></form></div><a id = register>注册</a></div>"
         $(document.body).prepend(logindialog)
         //相对浏览器居中
            var browserleft =  ($(window).width()-500)/2;
            var browsertop = ($(window).height()-300)/2;
            var tleft = e.screenX - e.clientX;
            var ttop = e.screenY - e.clientY;
         //模态窗口
            $("#modaldialog").css({
                "position":"fixed",
                "width":"500px",
                "height":"300px", 
                "border-radius":"3px",
                "display":"block",
                "left":browserleft,
                "top":browsertop,
                "background-image":"url(http://otnatze91.bkt.clouddn.com/img/login.jpg)",
                "z-index":"99"});
            $("#modaldialog input [type!=radio]").css({
                "width":"150",
                "height":"30",
            })
            $("#login-register-header").css({
                "background": "rgba(241, 244, 247,0.5)",
            })
            $("#x").css({
              "background-image":"url(resource/img/x.png)",
              "float":"right",
              "width":"20px",
              "height":"20px",
              "margin-top":"7.5px"
            }).click(function(){
                //取消cover，模态窗口，滚动条锁定
                $("#dialogbg").remove();
                $("#modaldialog").remove();
                $(document.body).css("overflow","visible");
                })
            $("#modaldialog span").css({
                "margin":"-5px 0px -5px 100px",
                "color":"#aa001a",
             })
                 
          //获得焦点动画，失去焦点ajax检查用户名存在性
           checkUser();
            
           $("#register")
           .css({
              "position":"absolute",
              "right":"10px",
              "bottom":"5px",
           })
           .click(function(){
               $("#mainform").remove();
               $("#register").remove();
               registerForm();
               
           })
     })
 function registerForm(){
          var registerdialog = "<form method=post action = register>"+
              "<div id=username><input name=username type=text id=username placeholder=Username /><span id=warn></span></div>"+
              "<div id=password><input name=password type=password id=password placeholder=Password /></div>"+
              "<div id=mailadress><input name=mailaddress type=text id=mailaddress placeholder=Mailadress /></div>"+
              "<input type=radio name=gender value=male /><h>male</h>"+
              "<input type=radio name=gender value=female /><h>female</h>"+
              "<input type=radio name=gender value=xiuji /><h>xiuji</h><br />"+
              "<button type=submit>提交</button>"+
            "</form>"

          $("#login-register-header").after(registerdialog);
          checkUser();


 }
 function checkUser(){
           $("#modaldialog input[type=radio]").css({
                "width":"13px",
            })
           $("username").text("");
           $("password").text("");
           $("#modaldialog input[type!=radio]")
            .focus(function(){
                $("#modaldialog span").text("");    
            })
            .blur(function(){
                 if($("#username input").val()!= ""){
                    $.get("username="+$("#username input").val(), 
                       function(data,textStatus){ //callback     
                          if(data == 0&&$("#mainform input").length==2){
                              $("#modaldialog span").text("用户名不存在");
                          }
                          if(data != 0&&$("#mainform input").length!=2){
                              $("#warn").text("用户已存在");
                          }

                       },"json"
                
                  )
                 }
            })
 }
 }

 
)
