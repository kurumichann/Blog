<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="java.security.Principal"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<% request.setCharacterEncoding("utf-8");%>
<% response.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link type="text/css" rel="stylesheet" href="resource/css/blogsheet.css">
<link type="text/css" rel="stylesheet" href="resource/css/article.css">
<link type="text/css" rel="stylesheet" href="resource/css/login&register.css">
<script src="resource/jquery-1.11.3.js" type="text/javascript"></script>
<script src="resource/jquery.animate-colors.js" type="text/javascript"></script>
<script type="text/javascript" src="resource/js/sort.js"></script>
<script type="text/javascript" src="resource/js/turnTopage.js"></script>
<script type="text/javascript" src="resource/js/edit.js"></script>
<script type="text/javascript" src="resource/js/login.js"></script>
<script type="text/javascript" src="resource/js/navigation.js"></script>
<script type="text/javascript" src="resource/js/searchArticle.js"></script>
<script type="text/javascript" src="resource/js/roleBasedList.js"></script>
<head>
<title>KURUMI NO jiken</title>
</head>

<body background="resource/img/background.png">

	<div id="main">
		<div id="toptag">
			<img src="resource/img/rwby_fixed.jpg">			
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
					<input id="search_keyword" placeholder="搜索"  type="text" title="在此输入关键字">
				</div>
				<div id="navi_sort" >					
					<ul id="navi_ul">					   
						<li ><h>时间</h></li>
						<li><h>点击</h></li>
						<li><h>热度</h></li>
						<li><h>节操</h></li>
					</ul>
				</div>

			</div>
			<br>
			<div id="parameter">
				<div class="obj_name">
					<div class="title">
					</div>
					<div class="titledown">
						<div id="impression">
							<img src="resource/img/code.png">
						</div>
						<br><span>THX</span>
					</div>
				</div>
				<br> <br>
				<div class="obj_name">
					<div class="title">
						<h>&nbsp;最新文章</h>
					</div>
					<div class="titledown">
						<div id="latestarticle">
							<ul>

							</ul>
						</div>
					</div>
				</div>
				<br> <br>
				<div class="obj_name">
					<div class="title">
						<h>&nbsp;最新图片</h>
					</div>
				</div>
				<br>			
			</div>
			<div id="con">

					<div id="login">
						<a id="login_h"><h%>登陆&nbsp;</h></a>
						<security:authorize access="hasRole('manager') or hasRole('general')">
						    <ul id="login_user">
							   <li ><a  href="j_spring_security_logout">
							     <security:authentication property="name"></security:authentication>&nbsp;
							       </a>
							   </li>
							   <security:authorize access="hasRole('manager')">
							   <li id="management">Manage</li>
							   </security:authorize>
							</ul>
						</security:authorize>
					</div>
					<div id="articles">
						<article class="article"> <header>
						<h2 class="arti_h">杯子</h2>
						<div class="arti_info">
							<span>由</span> <a class="author" title="">zby</a> <span>在</span>
							<a class="" title="">2015-06-10 21:20:50</a>
						</div>
						</header>
						<div class="arti_img">
							<img src="">
							<h1>阿斯利康飞机ask了放假撒离开房间ask了飞机 啊沙发沙发沙发</h1>
						</div>
						<footer>
						<hr></hr>
						</footer></article>

						<%-- 					 <% System.out.println(request.getAttribute("limiteddatas"));%>
					 <%  List<Map<String, String>> articles = (ArrayList<Map<String,String>>)request.getAttribute("limiteddatas"); 
					 System.out.println(articles.get(0)); %> --%>
						<%!int i2 = (int)(Math.random()*10);%>
						<c:forEach   var="data" items="${limiteddatas}" end="8">
							<article class="article">
							<h2  class="arti_h">${data.title}</h2>
							<div class="arti_info">
								<span>由</span> <a class="author" title="">${data.author}</a> <span>在</span>
								<a class="" title="">${data.time }</a>
							</div>
							</header>
							<div class="arti_img">
								<img src="resource/article_img/${data.img}">
								<h1>${data.content}</h1>
							</div>
							<footer>
							<hr></hr>
							</footer> </article>
						</c:forEach>
					</div>
					<security:authorize
						access="hasRole('manager') or hasRole('general')">
						<security:authentication property="principal.username"
							var="authorName" scope="session" />
						<sf:form modelAttribute="article" method="post" id="arti"
							enctype="multipart/form-data">
							<span>标题：</span>
							<sf:input path="title" type="text" id="arti_title" />
							<!-- <span>图片</span>
							<input type="file" id="arti_img" name="arti_img" /> -->
							<br />
							<br />
							<span>内容：</span>
							<sf:textarea path="content" rows="10" cols="45" id="arti_content" />
							<br />
							<input id="arti_submit" type="submit" />
						</sf:form>
					</security:authorize>
					<% int numberOfArticles = request.getAttribute("alldatas").toString().split("title").length-1;%>
					<% int maxPage = (int)Math.ceil(numberOfArticles/9.0); %>
					<ul id="pages_ul">
						<li id="Page_number">Page <a id="nowPage" onclick="turnTopage(1)">1</a>of
						<a id="totalPage" onclick="turnTopage(<%=maxPage%>)"><%=maxPage%></a>
						</li>
						<%!int i; %>
						<% for (i = 1 ;i<=maxPage;i++){ %>
						<li><a onclick="turnTopage(<%=i%>)"><%=i%></a></li>
						<%}%>
					</ul>
				</div>
			</div>

			<div id="footer"></div>



		</div>
</body>
</html>