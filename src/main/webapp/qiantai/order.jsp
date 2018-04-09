<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>我的订单</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/skin.css" rel="stylesheet" type="text/css" />
<script src="js/WdatePicker.js" type="text/javascript"></script>
</head>

<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="50px"></td>

		</tr>

		<tr>
			<td align="center" valign="top" height="420px">

				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="left" valign="top">

							<div align="center" width="120">
								<form action="selectuserorder.do" name="form1" method="get">
									<table id="table1" class="line_table"
										style="width: 500px; margin: 0; padding: 0" cellSpacing="0"
										cellPadding="0">
										<tbody style="margin: 0; padding: 0">
											<tr>
												<td class="line_table" align="right" width="40%"><span
													class="left_bt2">按购买日期查询</span></td>
												<td class="line_table" align="left" width="60%"><input
													type="text" name="times" value="${times }" size="20"
													readOnly  class="Wdate" onfocus="WdatePicker({maxDate:'%y-%M-%d'})"></input></td>
											</tr>
											<tr>
												<td class="line_table" align="right" width="40%"><span
													class="left_bt2">按商品名称查询</span></td>
												<td class="line_table" align="left" width="60%"><input
													type="text" name="name" value="${name}" size="20"></input></td>
											</tr>

											<tr>
												<td class="line_table" align="center" colspan="6"><input
													type="submit" value="查询"></td>


											</tr>
											<tr>
												<td class="line_table" align="center" colspan="6"><a
													href="selectuserorder.do">我的所有订单</a>&nbsp;&nbsp;&nbsp;&nbsp;
													<a href="selectuserorder.do?delivery=${0}">未派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;
													<a href="selectuserorder.do?delivery=${1}">已派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
											</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" valign="top" height="20px"></td>
					</tr>
					<tr>
						<td align="left" valign="top">


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 900px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">
										<tr>
											<td class="line_table" align="center" colspan="11"><span
												class="left_bt2">订单查询结果信息列表</span></td>
										</tr>
										<tr>
											<td class="line_table" align="center"><span
												class="left_bt2">化妆品名称</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">真实姓名</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">订购电话</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">派送地址</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">订购数量</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">单价(元)</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">合计(元)</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">订购时间</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">是否派送</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">是否送达</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2"> &nbsp;&nbsp;&nbsp;&nbsp; </span></td>
										</tr>
										<c:forEach items="${result.list }" var="order">
											<tr>
												<td class="line_table" align="center"><span
													class="left_txt">${order.product.name }</span></td>
												<td class="line_table" align="center"><span
													class="left_txt">${order.user.username }</span></td>
												<td class="line_table" align="center"><span
													class="left_txt">${order.user.telephone }</span></td>
												<td class="line_table" align="center"><span
													class="left_txt">${order.user.address }</span></td>
												<td class="line_table" align="center"><span
													class="left_txt">${order.productsum }</span></td>
												<td class="line_table" align="center"><span
													class="left_txt">${order.product.price2 }</span></td>
												<td class="line_table" align="center"><span
													class="left_txt">${order.product.price2*order.productsum  }</span></td>
												<td class="line_table" align="center"><span
													class="left_txt">${order.times }</span></td>
												<td class="line_table" align="center"><c:choose>
														<c:when test="${order.delivery==1 }">
															<span class="left_txt">是</span>
														</c:when>
														<c:otherwise>
															<span class="left_txt">否</span>
														</c:otherwise>
													</c:choose></td>
												<td class="line_table" align="center"><c:choose>
														<c:when test="${order.reach==1 }">
															<span class="left_txt">是</span>
														</c:when>
														<c:otherwise>
															<span class="left_txt">否</span>
														</c:otherwise>
													</c:choose></td>
												<td class="line_table" align="center"><c:if
														test="${order.delivery==0&&order.reach==0 }">
														<a class="left_txt" href="deleteOrder.do?id=${order.id}">删除</a>
													</c:if></td>
											</tr>

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
										<td width="50%" align="right"><c:choose>
												<c:when test="${result.page.currentPage eq 1}">首页</c:when>
												<c:otherwise>
													<a href="selectuserorder.do">首页</a>
												</c:otherwise>
											</c:choose> <c:choose>
												<c:when test="${result.page.currentPage eq 1 }">上一页</c:when>
												<c:otherwise>
													<a
														href="selectuserorder.do?curPage=${result.page.currentPage-1}">上一页</a>
												</c:otherwise>
											</c:choose> <c:choose>
												<c:when
													test="${result.page.currentPage eq result.page.totalPage }">下一页</c:when>
												<c:otherwise>
													<a
														href="selectuserorder.do?curPage=${result.page.currentPage+1 }">下一页</a>
												</c:otherwise>
											</c:choose> <c:choose>
												<c:when
													test="${result.page.currentPage eq result.page.totalPage }">尾页</c:when>
												<c:otherwise>
													<a
														href="selectuserorder.do?curPage=${result.page.totalPage }">尾页</a>
												</c:otherwise>
											</c:choose></td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="10px">&nbsp;</td>
		</tr>
		<tr>
			<td height="50px" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>
	</table>
	${update }
</body>
</html>
