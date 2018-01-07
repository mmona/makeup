<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<base
	href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<html>
<head>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">

/* body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
 */
</style>
</head>
<body>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="11" height="20"><span
									class="left_bt2">会员信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">登录名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">密码</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">真实姓名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">性别</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">年龄</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">家庭住址</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">身份证号</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">电话号码</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">电子邮箱</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">邮政编码</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
							</tr>
				<c:forEach items="${result.list }" var="user">
							<tr>
								<td class="line_table" align="center"><a
									href="menus_update.jsp?">${user.username }</a></td>
								<td class="line_table" align="center">${user.password }</td>
								<td class="line_table" align="center"><span
									class="left_txt">${user.realname}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${user.sex}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${user.age }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${user.address }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${user.card }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${user.telephone }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${user.email }</span></td>
									<td class="line_table" align="center"><span
									class="left_txt">${user.code }</span></td>
								<td class="line_table" align="center"><a
									href="user_update.jsp">修改</a></td>
								<td class="line_table" align="center"><a href="#">删除</a></td>
							</tr>
						</c:forEach>

							
					</table>
					 <table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="page">
			<tr>
				<td width="50%" align="left">共有${result.page.totalCount }条记录，<span
					style="font-family: 宋体; font-size: 9.0pt; color: black;">第</span><span
					style="font-family: Tahoma; font-size: 9.0pt; color: black;">
						${result.page.currentPage}/${result.page.totalPage} </span><span
					style="font-family: 宋体; font-size: 9.0pt; color: black;">页</span></td>
				<td width="50%" align="right">
				<c:choose>
						<c:when test="${result.page.currentPage eq 1}">首页</c:when>
						<c:otherwise>
							<a href="seletAllUser.do">首页</a>
						</c:otherwise>
					</c:choose> 
						<c:choose>
							<c:when test="${result.page.currentPage eq 1 }">上一页</c:when>
							<c:otherwise>
								<a href="seletAllUser.do?curPage=${result.page.currentPage-1}">上一页</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${result.page.currentPage eq result.page.totalPage }">下一页</c:when>
							<c:otherwise>
								<a href="seletAllUser.do?curPage=${result.page.currentPage+1 }">下一页</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
						<c:when test="${result.page.currentPage eq result.page.totalPage }">尾页</c:when>
						<c:otherwise>
							<a href="seletAllUser.do?curPage=${result.page.totalPage-1 }">尾页</a>
						</c:otherwise>
					</c:choose> 
					
				</td>
		</table>
					
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
