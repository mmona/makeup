<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/form.js"></script>
<script type="text/javascript" src="js/blockui.js"></script>

</head>
<body style='background: transparent'>


	<div id='contain'
		style='width: 900px; background: rgb(255, 255, 255); margin: 0px auto; padding: 0px'>

		<div id='top'
			style='width: 900px; height: 108px; background: none transparent scroll repeat 0% 0%'>


			<!-- 顶部菜单(一级) -->

			<div id='pdv_3607' class='pdv_class'
				style='width: 395px; height: 25px; top: 0px; left: 495px; z-index: 4'>
				<div id='spdv_3607' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">

						<div style="padding: 0px">

							<link href="css/topmenu_bk.css" rel="stylesheet" type="text/css" />

							<div id="topmenu">

								<a href="login.jsp" target="_self">会员登录</a>| <a href="reg.jsp"
									target="_self">会员注册</a>|
								<c:choose>
									<c:when test="${user!=null }">
										<a href="logout.do">注销退出</a>|
									</c:when>
									<c:otherwise>
										<a href="login.jsp">注销退出</a>|
									</c:otherwise>
								</c:choose>

								<a href="carry.jsp" target="_self">配送说明</a>| <a
									href="answer.jsp" target="_self">客服中心</a>
							</div>

						</div>
					</div>

				</div>
			</div>

			<!-- 二级导航菜单 -->

			<div id='pdv_3605' class='pdv_class'
				style='width: 898px; height: 41px; top: 65px; left: 0px; z-index: 6'>
				<div id='spdv_3605' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
						<div
							style="height: 25px; margin: 1px; display: none; background:;">
							<div
								style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:">

							</div>
							<div style="float: right; margin-right: 10px; display: none">
								<a href="-1" style="line-height: 25px; color:">更多</a>
							</div>
						</div>
						<div style="padding: 0px">

							<link href="css/A.css" rel="stylesheet" type="text/css" />
							<script type="text/javascript" src="js/channelmenu_dc.js"></script>

							<div id="menu">
								<div class="mainmenuleft"></div>
								<div class="mainmenuright"></div>

								<div id="mainmenu">
									<ul>

										<li><a href="indexInfo.do" target="_self">首页</a></li>

										<li><c:choose>
												<c:when test="${user!=null }">
													<a href="selectShopping.do" target="_self">购物车</a>
												</c:when>
												<c:otherwise>
													<a href="login.jsp">购物车</a>|
									</c:otherwise>
											</c:choose></li>
										<li><c:choose>
												<c:when test="${user!=null }">
													<a href="selectuserorder.do" target="_self">我的订单</a>
												</c:when>
												<c:otherwise>
													<a href="login.jsp">我的订单</a>|
									</c:otherwise>
											</c:choose></li>
										<li><c:choose>
												<c:when test="${user!=null }">
													<a href="center.jsp" target="_self">用户中心</a>
												</c:when>
												<c:otherwise>
													<a href="login.jsp" target="_self">用户中心</a>>|
									</c:otherwise>
											</c:choose></li>


										<li><a href="carry.jsp" target="_self">配送说明</a></li>
										<li><c:choose>
												<c:when test="${user!=null }">
													<a href="answer.jsp" target="_self">客服中心</a>
												</c:when>
												<c:otherwise>
													<a href="login.jsp">客服中心</a>|
									</c:otherwise>
											</c:choose></li>
										<li><c:choose>
												<c:when test="${user!=null }">
													<a href="logout.do">注销退出</a>|
									</c:when>
												<c:otherwise>
													<a href="login.jsp">注销退出</a>|
									</c:otherwise>
											</c:choose></li>

									</ul>
								</div>

								<div id="smenu">
									<div class="smenuleft"></div>
									<div class="smenuright"></div>
									<ul>

									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

								</div>
							</div>
							<script>
								showMenu(0);
							</script>

						</div>
					</div>

				</div>
			</div>

			<!-- 网站标志 -->
			<div id='pdv_3608' class='pdv_class' title=''
				style='width: 208px; height: 100px; top: -22px; left: 0px; z-index: 9'>
				<div id='spdv_3608' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
						<div style="padding: 0px">
							<img src="images/logo2.jpg" alt="" width="100%" border="0" />
						</div>
					</div>
				</div>
			</div>

			<!-- 登录后欢迎界面 -->
			<div id='pdv_3699' class='pdv_class' title=''
				style='width: 300px; height: 40; top: -120px; left: 600px; z-index: 10'>
				<div id='spdv_3608' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
						<div
							style="height: 25px; margin: 1px; display: none; background:;">
							<div
								style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:"></div>
							<div style="float: right; margin-right: 10px; display: none">
								<a href="-1" style="line-height: 25px; color:">更多</a>
							</div>
						</div>
						<c:if test="${user!=null }">
								<div
									style="padding: 0px; font: bold 13px/43px 'Microsoft YaHei', 'SimSun', Arial, Sans-Serif; color: #FF69B4;">
									亲爱的${user.username }您好&nbsp;&nbsp;欢迎光临!</div>
					</div>
						</c:if>
						
				
			</div>
		</div>


	</div>
	</div>
	</div>
	</div>
</body>
</html>
