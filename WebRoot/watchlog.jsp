<%@ page import="org.springframework.http.HttpRequest"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>观看记录</title>
<base href=" <%=basePath%>"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Easy Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<!-- chart -->
<script src="js/Chart.js"></script>
<!-- //chart -->
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
 <!-- Meters graphs -->
<script src="js/jquery-1.10.2.min.js"></script>
<!-- Placed js at the end of the document so the pages load faster -->

</head> 
   
 <body class="sticky-header left-side-collapsed"  onload="initMap()">
    <section>
    <!-- left side start-->
		<div class="left-side sticky-left-side">

			<!--logo and iconic logo start-->
			<div class="logo">
				<h1><a href="student/start!Start">翻转<span>课堂</span></a></h1>
			</div>
			<div class="logo-icon text-center">
				<a href="student/start!Start"><i class="lnr lnr-home"></i> </a>
			</div>

			<!--logo and iconic logo end-->
			<div class="left-side-inner">

				<!--sidebar nav start-->
					<ul class="nav nav-pills nav-stacked custom-nav">
						<li class="active"><a href="student/start!Start"><i class="lnr lnr-power-switch"></i><span>主页</span></a></li>
						<li class="menu-list">
							<a href="#"><i class="lnr lnr-cog"></i>
								<span>设置</span></a>
								<ul class="sub-menu-list">
									<li><a href="student/update.action">个人信息设置</a> </li>
									<li><a href="student/updatePW.action">密码修改</a></li>
								</ul>
						</li>
						<li><a href="knowledge/listStuKnowledge!listStuKnowledge"><i class="lnr lnr-menu"></i> <span>知识点列表</span></a></li>              
						<li class="menu-list"><a href="#"><i class="lnr lnr-envelope"></i> <span>消息中心</span></a>
							<ul class="sub-menu-list">
								<li><a href="student/chat.action">我的讨论</a> </li>
							</ul>
						</li>      
						<li><a href="student/listWatchLog!listWatchLog"><i class="lnr lnr-select"></i> <span>观看记录</span></a></li>
						<li class="menu-list"><a href="#"><i class="lnr lnr-book"></i>  <span>用户中心</span></a> 
							<ul class="sub-menu-list">
								<li><a href="index.action">登录</a> </li>
								<li><a href="student/register.action">注册</a></li>
							</ul>
						</li>
					</ul>
				<!--sidebar nav end-->
			</div>
		</div>
    <!-- left side end-->
    
    <!-- main content start-->
		<div class="main-content main-content4">
			<!-- header-starts -->
			<div class="header-section">
			 
			<!--toggle button start-->
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<!--toggle button end-->

			<!--notification menu start -->
			<div class="menu-right">
				<div class="user-panel-top">  	
					<div class="profile_details_left">
						<ul class="nofitications-dropdown">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">3</span></a>
									
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>You have 3 new messages</h3>
												</div>
											</li>
											<li><a href="#">
											   <div class="notification_desc">
												<p>Lorem ipsum dolor sit amet </p>
												<p><span>1 hour ago</span></p>
												</div>
											   <div class="clearfix"></div>	
											</a></li>
											<li>
												<div class="notification_bottom">
													<a href="#">查看所有消息</a>
												</div> 
											</li>
										</ul>
							</li>
							<li class="login_box" id="loginContainer">
									<div class="search-box">
										<div id="sb-search" class="sb-search">
											<form>
												<input class="sb-search-input" placeholder="Enter your search term..." type="search" id="search">
												<input class="sb-search-submit" type="submit" value="">
												<span class="sb-icon-search"> </span>
											</form>
										</div>
									</div>
										<!-- search-scripts -->
										<script src="js/classie.js"></script>
										<script src="js/uisearch.js"></script>
											<script>
												new UISearch( document.getElementById( 'sb-search' ) );
											</script>
										<!-- //search-scripts -->
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">3</span></a>
									<ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>你有三个课程提醒</h3>
											</div>
										</li>
										 <li><a href="#">
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet </p>
											<p><span>1 hour ago</span></p>
											</div>
										   <div class="clearfix"></div>	
										 </a></li>
										 <li>
											<div class="notification_bottom">
												<a href="#">查看所有提醒</a>
											</div> 
										</li>
									</ul>
							</li>							   		
							<div class="clearfix"></div>	
						</ul>
					</div>
					<div class="profile_details">		
						<ul>
							<li class="dropdown profile_details_drop">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<div class="profile_img">	
										 <div class="user-name">
											<p><s:property value="#session.user.sname"/><span>学生</span></p>
										 </div>
										 <i class="lnr lnr-chevron-down"></i>
										 <i class="lnr lnr-chevron-up"></i>
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									<li> <a href="student/showInfo.action"><i class="fa fa-user"></i>个人信息查看</a> </li> 
									<li> <a href="index.action"><i class="fa fa-sign-out"></i>退出</a> </li>
								</ul>
							</li>
							<div class="clearfix"> </div>
						</ul>
					</div>		
				</div>
			  </div>
			<!--notification menu end -->
           
			</div>
	<!-- //header-ends -->
			<div id="page-wrapper">
				<div class="graphs">
					<h3 class="blank1">观看记录</h3>
					 <div class="xs tabls">
						<div class="bs-example4" data-example-id="contextual-table">
						<table class="table">
						  <thead>
							<tr>
							  <th>知识点ID</th>
							  <th>观看进度</th>
							  <th>观看时间</th>
							  <th>完成状态</th>
							</tr>
						  </thead>
						  <tbody>
						  	<s:iterator var="obj" value="list" >
						  		<s:if test="#obj.status == 1">
						  			<tr class="success">
						  				<th scope="row"><s:property value="#obj.kno"/></th>
						  				<th><s:property value="#obj.progress"/></th>
						  				<th><s:property value="#obj.watch_time"/></th>
						  				<td>已完成</td>
						  			</tr>
						  		</s:if>
						  		<s:else>
						  			<tr class="danger">
						  				<th scope="row"><s:property value="#obj.kno"/></th>
						  				<th><s:property value="#obj.progress"/></th>
						  				<th><s:property value="#obj.watch_time"/></th>
						  				<td>未完成</td>
						  			</tr>
						  		</s:else>
						  	</s:iterator>
						  </tbody>
						</table>
					   </div>
					</div>
				</div>
			</div>
		</div>
		<!--footer section start-->
			<footer>
			   <p>Copyright &copy; 2017.黑龙江省哈尔滨市香坊区和兴路26号东北林业大学 <a href="http://127.0.0.1:8080/bishe/index.jsp" target="_blank" title="Java语言翻转课堂式教学模式系统"> Java语言翻转课堂教学模式系统</a>
</p>
			</footer>
        <!--footer section end-->
	</section>
	
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>