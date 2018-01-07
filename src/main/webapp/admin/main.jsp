<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>女孩地带- 管理页面</title>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
</head>
<frameset rows="64,*" frameborder="NO" border="0" framespacing="0">
	<frame src="admin_top.jsp" noresize="noresize" frameborder="NO"
		name="topFrame" scrolling="no" marginwidth="0" marginheight="0"
		target="index" />
	<frameset cols="200,*" rows="560,*" id="frame">
		<frame src="admin_left.jsp" name="leftFrame" noresize="noresize"
			marginwidth="0" marginheight="0" frameborder="0" scrolling="no"
			target="main" />
		<frame src="order.jsp" name="main" marginwidth="0" marginheight="0"
			frameborder="0" scrolling="auto" target="main" />
	</frameset>
	<noframes>
		<body></body>
	</noframes>
</html>
