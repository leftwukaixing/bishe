<%@page import="org.springframework.http.HttpRequest"%>
<%@ page language="java" import="java.util.*" 
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>主页</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
<!-- Placed js at the end of the document so the pages load faster -->
</head>

<body class="sticky-header left-side-collapsed">
	<session>
		<div id="teacherleft" class="sticky-header left-side-collapsed">
			<iframe name="left"  id="left" frameborder="1"  scrolling="yes" src="teacherleft.jsp" class="sticky-header left-side-collapsed" allowtransparency="false"></iframe>
		</div>
		<div class="main-content">
			<div id="header" class="header-section">
				<iframe id="top" src="top.jsp" frameborder="1" scrolling="no" allowtransparency="false"></iframe>
			</div>
			<div id="page-wrapper">
				<div class="graphs">
					<div id="start">
						<iframe name="right" id="right" frameborder="1"  scrolling="yes" src="start.jsp" class="right" allowtransparency="false"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!--footer section start-->
		<footer>
			<p>Copyright &copy; 2017.黑龙江省哈尔滨市香坊区和兴路26号东北林业大学 <a href="http://127.0.0.1:8080/bishe/index.jsp" target="_blank" title="Java语言翻转课堂式教学模式教学系统"> Java语言翻转课堂教学模式系统</a>
</p>
		</footer>
    	<!--footer section end-->
	</session>
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>


