<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>学生注册</title>
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
   
 <body class="sign-in-up">
    <section>
			<div id="page-wrapper" class="sign-in-wrapper">
				<div class="graphs">
					<div class="sign-up">
						<h3>学生注册</h3>
						<p class="creating">注册到Java语言翻转课堂教学模式系统，即可开启你全新的学习体验或教学方式，快快加入吧！</p>
						<form action="<%=basePath %>addStudent!addStudent" method="post">
						<h5>个人信息</h5>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>学号* :</h4>
							</div>
							<div class="sign-up2">
								<input type="text" placeholder="学生学号" name="student.sno"/>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>姓名* :</h4>
							</div>
							<div class="sign-up2">
								<input type="text" placeholder="学生姓名" name="student.sname"/>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>班级* :</h4>
							</div>
							<div class="sign-up2">
								<input type="text" placeholder="班级信息" name="student.sclass"/>
							</div>
							<div class="clearfix"> </div>
						</div>
						<h6>登录信息</h6>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>密  码* :</h4>
							</div>
							<div class="sign-up2">
								<input type="password" placeholder="登录密码" name="user.password"/>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>确认密码* :</h4>
							</div>
							<div class="sign-up2">
								<input type="password" placeholder="确认密码"/>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="sub_home">
							<div class="sub_home_left">
								<input type="submit" value="确认提交">
							</div>
							<div class="sub_home_right">
								<p>返回<a href="login.jsp">登录页</a></p>
							</div>
							<div class="clearfix"> </div>
						</div>
						</form>
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