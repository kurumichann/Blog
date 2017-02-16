<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="java.security.Principal"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     
     <security:authorize access="hasRole('manager')"/>
     <table border="1px" cellpadding="10px" cellspacing="0px">
		<tr>
			<th><h>username</h></th>
			<th><h>gender</h></th>
			<th><h>mailaddress</h></th>
			<th><h>registertime</h></th>
			<th><h>authority</h></th>
			<th><h>status</h></th>
			<th><h>operation</h></th>
		</tr>
		<c:forEach var="user" items="${users}" >
             <tr>
                 <th>${user.username}</th>
                 <th>${user.gender}</th>
                 <th>${user.mailaddress}</th>
                 <th>${user.registertime}</th>
                 <th>${user.authority}</th>
                 <th>${user.status}</th>
                 <th><div></div></th>
             </tr>
          </c:forEach>
     </table>
     </security：authorize>
</body>
</html>