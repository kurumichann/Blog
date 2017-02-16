<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登陆</title>
</head>
<body>
          
     <form method="post" action="<%= request.getContextPath() %>/j_spring_security_check">
           <p>
              <label>用户名：</label>
              <input type="text"  name="j_username" placeholder =  "用户名"/>
           </p>
           <p>
              <label>&nbsp;密码：</label>
              <input type="password" name="j_password" placeholder =  "密码" />
           </p>

              <input  name = "commit" type = "submit" value="登陆" >
              <a href="register"><span>注册</span></a>
              
     </form>
</body>
</html>