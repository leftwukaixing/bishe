<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>主页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="hc" />
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"/> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<!-- chart -->
<script src="js/Chart.js"></script>
<!-- //chart -->
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all"/>
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>

<link href="css/video-js.min.css" rel="stylesheet"/>
<script src="js/video.min.js"></script>	
	
<!--//end-animate-->
<!----webfonts--->
<link href='http://fonts.useso.com/css?family=Cabin:400,400italic,500,500italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'/>
<!---//webfonts---> 
 <!-- Meters graphs -->
<script src="js/jquery-1.10.2.min.js"></script>
</head>


<body class="sticky-header left-side-collapsed">
<div class="left-side sticky-left-side">

			<!--logo and iconic logo start-->
			<div class="logo">
				<h1><a href="index.jsp">翻转<span>课堂</span></a></h1>
			</div>
			<div class="logo-icon text-center">
				<a href="index.jsp"><i class="lnr lnr-home"></i> </a>
			</div>

			<!--logo and iconic logo end-->
			<div class="left-side-inner">

				<!--sidebar nav start-->
					<ul class="nav nav-pills nav-stacked custom-nav">
						<li class="active"><a href="index.jsp"><i class="lnr lnr-power-switch"></i><span>主页</span></a></li>
						<li class="menu-list">
							<a href="#"><i class="lnr lnr-cog"></i>
								<span>设置</span></a>
								<ul class="sub-menu-list">
									<li><a href="setinfo.jsp">个人信息设置</a> </li>
									<li><a href="setpw.jsp">密码修改</a></li>
								</ul>
						</li>
						<li><a href="tables.jsp"><i class="lnr lnr-menu"></i> <span>知识点列表</span></a></li>              
						<li class="menu-list"><a href="#"><i class="lnr lnr-envelope"></i> <span>消息中心</span></a>
							<ul class="sub-menu-list">
								<li><a href="chat.jsp">我的讨论</a> </li>
							</ul>
						</li>      
						<li><a href="codes.jsp"><i class="lnr lnr-pencil"></i> <span>我的笔记</span></a></li>
						<li><a href="media.jsp"><i class="lnr lnr-select"></i> <span>观看记录</span></a></li>
						<li class="menu-list"><a href="#"><i class="lnr lnr-book"></i>  <span>用户中心</span></a> 
							<ul class="sub-menu-list">
								<li><a href="login.jsp">登录</a> </li>
								<li><a href="register.jsp">注册</a></li>
								<li><a href="blank_page.jsp">404</a></li>
							</ul>
						</li>
					</ul>
				<!--sidebar nav end-->
			</div>
		</div>
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
