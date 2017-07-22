<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0063)file:///G:/u%E7%9B%98/%E7%95%99%E8%A8%80%E6%9D%BF/My_Blog.html# -->
<html >
<link type="text/css" rel="stylesheet" href="css/blogsheet.css">
<link type  = "text/css" rel  = "stylesheet" href = "css/article.css">

<head>
<title>KURUMI NO jiken </title>
</head>

<body >
	<script type="text/javascript" src = "js/sort.js"></script>
	<script type="text/javascript" src = "js/li1_click.js"></script>
	<script type="text/javascript" src = "js/li2_click.js"></script>
	<script type="text/javascript" src = "js/login_click.js"></script>
	<script type="text/javascript" src = "js/newarticle.js"></script>
	<script type="text/javascript" src = "js/onload.js"></script>
	<script type="text/javascript" src = "js/go.js"></script>
	<div id="main">
		<div id="toptag">
			<img src="img/rwby_fixed.jpg">
			<div id="element">
				<ul>
					<li><span>日志</span></li>
					<li><span>图片</span></li>
					<li><span>音乐</span></li>
					<li><span>资源</span></li>
				</ul>
			</div>
		</div>
		<div id="content">

			<div id="navigation">
				<div id="navi_search">
					<input id="search_keyword" type="text" title="在此输入关键字"> <input
						class="button" type="button" value="搜索">
				</div>
				<div id="navi_sort" onclick="sort()">
					<h id="navi_h">排序</h>
					<ul id="navi_ul">
						<li onclick = "li_click()" value="0"><a href="javascript:;">时间正序</a></li> 
						<li onclick = "li_click()" value="1"><a href="javascript:;">时间倒序</a></li>
						<li onclick = "li_click()" value="2"><a href="javascript:;">点击数正序</a></li>
						<li onclick = "li_click()" value="3"><a href="javascript:;">点击数倒序</a></li>
						<li onclick = "li_click()" value="4"><a href="javascript:;">节操值正序</a></li>
						<li onclick = "li_click()" value="5"><a href="javascript:;">节操值倒序</a></li>
					</ul>
				</div>

			</div>
			<br>
			<div id="parameter">
				<div class="obj_name">
					<div class="title">
						<h>impression</h>
					</div>
					<div class="titledown">
						<div id="impression">
							<img src="img/impressing.jpg">
						</div>

						<br>&nbsp;&nbsp;&nbsp;<span>パンーツこん</span>
					</div>
				</div>
				<br> <br>
				<div class="obj_name">
					<div class="title">
						<h>&nbsp;博主信息</h>
					</div>
					<div class="titledown">
						<ul>
							<li>四川成都</li>
							<li>93年2月17日</li>
							<li>水平座</li>
							<li>IT学生狗一枚</li>
							<li>万能血</li>
						</ul>
					</div>
				</div>
				<br> <br>
				<div class="obj_name">
					<div class="title">
						<h>&nbsp;最新博文</h>
					</div>
					<div class="titledown">
						<div id="latestarticle">
							<ul>
								<li><span><a
										href="file:///C|/Users/KURUMI NO KONPUTA/Desktop/KURUMI NO jiken_files/KURUMI NO jiken.html">arkeykun</a></span></li>
								<li><span><a
										href="file:///C|/Users/KURUMI NO KONPUTA/Desktop/KURUMI NO jiken_files/KURUMI NO jiken.html">lolita</a></span></li>
								<li><span><a
										href="file:///C|/Users/KURUMI NO KONPUTA/Desktop/KURUMI NO jiken_files/KURUMI NO jiken.html">html5</a></span></li>
								<li><span><a
										href="file:///C|/Users/KURUMI NO KONPUTA/Desktop/KURUMI NO jiken_files/KURUMI NO jiken.html">javascript</a></span></li>
							</ul>
						</div>
					</div>
				</div>
				<br> <br>
				<div class="obj_name">
					<div class="title">
						<h>&nbsp;相册</h>
					</div>
					<div class="titledown">

						<div>
							<div id="declear">
								<span>这里放相片</span>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="obj_name">
					<div class="title"></div>
					<div class="titledown">
						<div id="comment">
							<span>这里放二维码<span> </span></span>
						</div>
					</div>
				</div>


			</div>
			<div id="con">
				<div id="login" >
				  <h id = "login_h" href = "login">登陆&nbsp;</h>
					<ul id="login_ul">
						<li value = "管理员" onclick="li1_click()"><a href="javascript:;">管理员</a></li>
						<li value = "会员" onclick="li2_click()"><a href="login.jsp">会员&nbsp;</a></li>
						<li value = "注册" ><a href="login.jsp">注册&nbsp;</a></li>
					</ul>
				</div>
				<div id="articles">

					<article class="article"> 
					   <header>
					     <h2 class="arti_h">杯子</h2>
						 <div class="arti_info">
							<span>由</span> <a class="author" title="">zby</a> <span>在</span>
							<a class="" title="">2015-06-10 21:20:50</a>
						 </div>
				       </header>
					   <div class="arti_img">
							<img src="img/miku.jpg">
							<h1>阿斯利康飞机ask了放假撒离开房间ask了飞机 啊沙发沙发沙发</h1>
						</div>
					   <footer>
						<hr></hr>
					   </footer></article>
				</div>
				<form method="post" id="arti">
					<span>标题：</span>
					<input type="text" id = "arti_title">
					<span>图片</span>
					<input type = "text" id = "arti_img" id = "arti_img"></input><br />
					<br /> <span>内容：</span>
					<textarea rows="10" cols="45" id="arti_content" ></textarea><br />
					<input id = "arti_submit" type="button" value="提交" onclick = "new_article()">
				</form>
				<ul id = "pages_ul">
				         <li id = "Page_number">Page <a id = "nowPage" onclick = "go(1)">1</a>of<a id = "totalPage"></a></li>
				         
				</ul>
			</div>
		</div>
		<div id="footer"></div>



	</div>
</body>
</html>