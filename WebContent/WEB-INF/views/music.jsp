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
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link type="text/css" rel="stylesheet" href="resource/css/blogsheet.css">
<link type="text/css" rel="stylesheet" href="resource/css/article.css">
<link type="text/css" rel="stylesheet" href="resource/css/music.css">
<script src="resource/jquery-1.11.3.js" type="text/javascript"></script>
<script type="text/javascript" src="resource/js/sort.js"></script>
<script type="text/javascript" src="resource/js/turnTopage.js"></script>
<script type="text/javascript" src="resource/js/loop.js"></script>
<script type="text/javascript" src="resource/js/login.js"></script>
<script type="text/javascript" src="resource/js/loadTop3.js"></script>
<script type="text/javascript" src="resource/js/navigation.js"></script>
<script type="text/javascript" src="resource/js/searchArticle.js"></script>
<script type="text/javascript" src="resource/js/roleBasedList.js"></script>
<head>
<title>KURUMI NO jiken</title>
</head>

<body background="resource/img/background.png">

	<div id="main">
	    <div id="toptag">
		  <div id = "img">
			<img src="resource/img/loop.jpg">	
		  </div>			
		</div>

		<div id="content">

			<security:authorize access="hasRole('manager')">
				<!-- <EMBED autoplay="true" loop="1" hidden="true"
					src="resource/onload/Kongo02_Valentine.mp3" type=audio/mpeg
					autostart="true"></EMBED> -->
			</security:authorize>
			<div id="navigation">
				<div id="mainList">
					<ul>
						<li>&nbsp;论坛</li>
						<li>&nbsp;图片</li>
						<li>&nbsp;音乐</li>
						<li>&nbsp;新闻</li>
					</ul>
				</div>
				<div id="navi_search">
					<input id="search_keyword" placeholder="搜索" type="text"
						title="在此输入关键字">
				</div>
				<div id="navi_sort">
					<ul id="navi_ul">
						<li><h>时间</h></li>
						<li><h>点击</h></li>
						<li><h>热度</h></li>
						<li><h>节操</h></li>
					</ul>
				</div>

			</div>
			<br>
		<div id="parameter">
				<div class="obj_name">
					<div class="titledown">
						<br><span>THX</span>
					</div>
				</div>
				<br> <br>
				<div class="obj_name">
					<div class="titledown">
						<div id="latestarticle">
							<ul>

							</ul>
						</div>
					</div>
				</div>
				<br> <br>
				<div class="obj_name">
				</div>
				<br>			
			</div>
			<div id="con">
				<div id="login">
					<a id="login_h"><h%>登陆&nbsp;</h></a>
					<security:authorize
						access="hasRole('manager') or hasRole('general')">
						<ul id="login_user">
							<li><a href="j_spring_security_logout"> <security:authentication
										property="name"></security:authentication>&nbsp;
							</a></li>
							<security:authorize access="hasRole('manager')">
								<li id="management">Manage</li>
							</security:authorize>
						</ul>
					</security:authorize>
				</div>
				<div id="articles">
					<c:forEach var="music" items="${musics}" end="8">
						<article class="article">
						<div class="arti_info">
							<span>由${music.author}在${music.createtime}</span>
						</div>
						<a class="arti_h">${music.title}</a>
						</header>
						<div class="arti_img">
							<img src="/Blog/resource/music_img/${music.img}">
							<h1>${music.description}</h1>
							<video controls="" name="media"> <source
								src="${music.src}" type="audio/mpeg"></video>
						</div>
						<footer>
						<hr></hr>
						</footer> </article>
					</c:forEach>
					<security:authorize
						access="hasRole('manager') or hasRole('general')">
						<security:authentication property="principal.username"
							var="authorName" scope="session" />
						<sf:form modelAttribute="music" method="post" id="arti"
							enctype="multipart/form-data">
							<div id = "input_title">
							   <label>标题：</label>
							   <sf:input path="title" type="text" id="arti_title" />
							</div>
							<div id = "input_pic">
							   <label>图片&nbsp;</label>
							   <input type="file" id="arti_img" name="arti_img" />
							</div>
							<div id = "input_src">							
							   <label>资源&nbsp;</label>
							   <sf:input type="text" path="src" id="arti_img" name="arti_src" />
							</div>   
							<span>内容：</span>
							<sf:textarea path="description" rows="10" cols="45"
								id="arti_content" />
							<br />
							<input id="arti_submit" type="submit" />
						</sf:form>
					</security:authorize>
				</div>
			</div>

			<div id="footer"></div>



		</div>
</body>
</html>
