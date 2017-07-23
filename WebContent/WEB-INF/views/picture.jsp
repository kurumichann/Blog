<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="java.security.Principal"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link type="text/css" rel="stylesheet" href="resource/css/blogsheet.css">
<link type="text/css" rel="stylesheet" href="resource/css/article.css">
<link type="text/css" rel="stylesheet" href="resource/css/music.css">
<link type="text/css" rel="stylesheet" href="resource/css/picture.css">
<link rel="shortcut icon" type="image/x-icon" href="resource/img/icon.ico" media="screen" />
<script src="resource/jquery-1.11.3.js" type="text/javascript"></script>
<script type="text/javascript" src="resource/js/sort.js"></script>
<script type="text/javascript" src="resource/js/turnTopage.js"></script>
<script type="text/javascript" src="resource/js/login.js"></script>
<script type="text/javascript" src="resource/js/loop.js"></script>
<script type="text/javascript" src="resource/js/loadTop3.js"></script>
<script type="text/javascript" src="resource/js/navigation.js"></script>
<script type="text/javascript" src="resource/js/searchArticle.js"></script>
<script type="text/javascript" src="resource/js/roleBasedList.js"></script>
<script type="text/javascript" src="resource/js/waterfall.js"></script>
<script type="text/javascript" src="resource/js/pic_onload.js"></script>
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
						<br><span>//TODU</span>
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
					<div class="titledown">
					  <div id="picture_form">
						<security:authorize
							access="hasRole('manager') or hasRole('general')">
							<sf:form modelAttribute="picture" method="post"
								enctype="multipart/form-data">
								<input type="file" id="picture" name="picture"><br />
								<label>Profile:</label>
								<sf:textarea id="pictureContent" path="content" rows="5"
									cols="10"></sf:textarea>
								<input type="submit" />
							</sf:form>
						</security:authorize>
			         </div>
			         </div>
				</div>
				<br>			
			</div>

			<div id="con">
				<div id="content_pic">
					<c:forEach items="${pictures}" var="picture">
						<div class="box">
							<div class="pic" pic_id="${picture.id}">

								<div class="ha">
									<div class="good"></div>
									<div class="con3"></div>
								</div>

								<div class="imag">
									<img alt=""
										src="<%=request.getContextPath()%>/resource/picture/${picture.img}">
								</div>
								<div class="d">
									<span class="d1">${picture.good}</span>
								</div>
								<div class="con2">
									<h>${picture.content}</h>
								</div>
								<div id="info">
									<h>by <a>${picture.user}</a>
								</div>

							</div>
						</div>
					</c:forEach>
					
				</div>

			</div>
		</div>

		<div id="footer"></div>



	</div>
</body>
</html>
