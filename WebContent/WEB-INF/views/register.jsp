<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "sf" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/register.css">
<title>登陆</title>
</head>
<body>


           
     <sf:form modelAttribute="user" name = "login_form" method="post" enctype="multipart/form-data">
           <p>
              <label>用户名：</label>
              <sf:input path="username" type="text"  placeholder =  "用户名"/>
              <sf:errors path = "username"/>
           </p>
           <p>
              <label>&nbsp;密码：</label>
              <sf:input type="text" path = "password" placeholder =  "密码" />
              <sf:errors path = "password"/>
           </p>
           <p>
              <div id="mail">
              <label>&nbsp;mail：</label>
              <sf:input  type="text" path = "mailAddress" placeholder =  "mail" />
              <sf:errors path = "mailAddress"/>
              </div>
            </p>
            <p>
              <div id = "gender">
              <label>&nbsp;性别：</label>
              <sf:radiobutton path="gender" value="male"/>男
              <sf:radiobutton path="gender" value="female"/>女	
              <sf:radiobutton path="gender" value="xiuji"/>秀吉
              </div>
              <input name = "file" type = "file" />
           </p>
              <input  id =  "register" type = "submit" value="注册" >
     </sf:form>
</body>
</html>