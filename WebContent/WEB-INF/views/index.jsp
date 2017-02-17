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
<meta name="_csrf" content="${_csrf.token}"/>  
<meta name="_csrf_header" content="${_csrf.headerName}"/>  
<link type="text/css" rel="stylesheet" href="resource/css/blogsheet.css">
<link type="text/css" rel="stylesheet" href="resource/css/article.css">
<link type="text/css" rel="stylesheet" href="resource/css/login&register.css">
<script src="resource/jquery-1.11.3.js" type="text/javascript"></script>
<script type="text/javascript" src="resource/js/sort.js"></script>
<script type="text/javascript" src="resource/js/loop.js"></script>
<script type="text/javascript" src="resource/js/turnTopage.js"></script>
<script type="text/javascript" src="resource/js/login.js"></script>
<script type="text/javascript" src="resource/js/loadTop3.js"></script>
<script type="text/javascript" src="resource/js/navigation.js"></script>
<script type="text/javascript" src="resource/js/searchArticle.js"></script>
<script type="text/javascript" src="resource/js/roleBasedList.js"></script>
<script type="text/javascript" src="resource/js/length_restrict.js"></script>
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
						<!-- hasRole('manager') or hasRole('general') -->
						<security:authorize access="hasAnyRole('manager','general')">
						    <ul id="login_user">
							   <li ><a  href="springWEB/logout">
							     <security:authentication property="name"></security:authentication>&nbsp;
							       </a>
							   </li>
							   <security:authorize access="principal.username=='kurumi'">
							   <li id="management">Manage</li>
							   </security:authorize>
							</ul>
						</security:authorize>
					</div>
					<div id="articles">
						<article class="article"> <header>
						<a class="arti_h=">杯子</a>
						<div class="arti_info">
							<span>由</span> <h class="author" title="">zby</h> <span>在</span>
							<h class="" title="">2015-06-10 21:20:50</h>
						</div>
						</header>
						<div class="arti_img">
							<img src="">
							<h1>阿斯利康飞机ask了放假撒离开房间ask了飞机 啊沙发沙发沙发</h1>
						</div>
						<footer>
						<hr></hr>
						</footer></article>
						<c:forEach   var="data" items="${datas}" end="8">
							<article class="article">
							<a id=${data.id} href = article/id=${data.id}>${data.title}</a>
							<div class="arti_info">
								<h>由${data.author}在${data.time}</h>
							</div>
							</header>
							<div class="arti_img">
								<c:if test="${data.img!='null'}" var="rs">
									<img src="resource/article_img/${data.img}">
								</c:if>
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
							<span>图片</span>
							<input type="file" id="arti_img" name="arti_img" />
							<br />
							<br />
							<span>内容：</span>
							<sf:textarea path="content" rows="10" cols="45" id="arti_content" />
							<br />
							<input id="arti_submit" type="submit" />
						</sf:form>
					</security:authorize>
					<ul id="pages_ul">
						<li id="Page_number">Page <a id="nowPage" onclick="turnTopage(1)">1</a>of<a id="totalPage" onclick="turnTopage()"></a>
						</li>
					</ul>
				</div>
			</div>

			<div id="footer"></div>



		</div>
</body>
</html>