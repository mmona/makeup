<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客服中心</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="qiantai/css/common.css" rel="stylesheet" type="text/css" />

</head>
<script language="JavaScript">
	function check11() {
		if (document.form1.content.value == "") {
			alert("提问内容不能为空!");
			document.form1.content.focus();
			return false;
		}
	}
</script>

<script type="text/javascript" src="qiantai/js/common.js"></script>


<body>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="50"></td>

		</tr>

		<tr>
			<td align="center" valign="top" height="400">

				<table border="0" cellspacing="0" width="100%">

					<tr>
						<td align="center" vlign="top"><strong><span
								style="font-family: Helvetica, sans-serif; font-size: 20px; color: #FF69B4">
									客服中心 </span></strong> <br></td>
					</tr>
					<c:forEach items="${result.list}" var="review">
						<tr>
							<td align="left">
							<span
								style="ont-family: Helvetica, sans-serif; font-size: 15px; ">
									问题： </span> 
									<span
								style="ont-family: Helvetica, sans-serif; font-size: 15px;" />
								${review.question.content } </span> &nbsp;&nbsp;&nbsp; 
								<span
								style="ont-family: Helvetica, sans-serif; font-size: 15px;">
									${review.question.times } </span> <br>
									 <span
								style="ont-family: Helvetica, sans-serif; font-size: 15px; ">
									回复： </span> 
								<strong>
									<span
										style="ont-family: Helvetica, sans-serif; font-size: 15px; color: #FF69B4"">
										&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;${review.content } </span>
			  &nbsp;&nbsp;&nbsp;
			  <span style="ont-family: Helvetica, sans-serif; font-size: 15px;color: #FF69B4"">
										${review.time } </span>
										</strong>
									</br>
								</c:forEach></td>
								<table width="90%" border="0" align="center"
														cellpadding="0" cellspacing="0" class="page">
														<tr>
															<td width="50%" align="left">共有${result.page.totalCount }条记录，<span
																style="font-family: 宋体; font-size: 9.0pt; color: black;">第</span><span
																style="font-family: Tahoma; font-size: 9.0pt; color: black;">
																	${result.page.currentPage}/${result.page.totalPage} </span><span
																style="font-family: 宋体; font-size: 9.0pt; color: black;">页</span></td>
															<td width="50%" align="right"><c:choose>
																	<c:when test="${result.page.currentPage eq 1}">首页</c:when>
																	<c:otherwise>
																		<a href="selectReviewByUser.do">首页</a>
																	</c:otherwise>
																</c:choose> <c:choose>
																	<c:when test="${result.page.currentPage eq 1 }">上一页</c:when>
																	<c:otherwise>
																		<a
																			href="selectReviewByUser.do?curPage=${result.page.currentPage-1}">上一页</a>
																	</c:otherwise>
																</c:choose> <c:choose>
																	<c:when
																		test="${result.page.currentPage eq result.page.totalPage }">下一页</c:when>
																	<c:otherwise>
																		<a
																			href="selectReviewByUser.do?curPage=${result.page.currentPage+1 }">下一页</a>
																	</c:otherwise>
																</c:choose> <c:choose>
																	<c:when
																		test="${result.page.currentPage eq result.page.totalPage }">尾页</c:when>
																	<c:otherwise>
																		<a
																			href="selectReviewByUser.do?curPage=${result.page.totalPage }">尾页</a>
																	</c:otherwise>
																</c:choose></td>
														</tr>
													</table>
								
								<form action="addQuestion.do" method="post" name="form1"
						onSubmit="return check11()">
						<tr>
							<td align="center" vlign="top"><textarea rows="5" cols="100"
									name="content"></textarea></td>
						</tr>
						<tr>
							<td align="center" vlign="top"><input class="answer"
								type=submit value="提交" /></td>
						</tr>
					</form>
								
						</tr>
					
					
					<tr>
						<td align="center"><a href="indexInfo.do" target="_self">
								<span
								style="font-family: Helvetica, sans-serif; font-size: 16px; color: #FF69B4">
									返回 </span>
						</a></td>
					</tr>
				</table>





			</td>
		</tr>
		<tr>
			<td height="10">&nbsp;</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle">&nbsp; <jsp:include
					flush="fasle" page="copyright.jsp" />
			</td>
		</tr>

	</table>
	${success } ${fail }
</body>
</html>
