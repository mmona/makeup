<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="admin/images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
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
								<td class="line_table" align="center" colspan="15"><span
									class="left_bt2">销售订单查询结果信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">订单ID</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">用户ID</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">用户名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">真实姓名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">联系方式</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">家庭住址</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">化妆品名称</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">单价(元)</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">合计(元)</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">订购时间</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">订购数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">是否派送</span></td>
									<td class="line_table" align="center"><span
									class="left_bt2">是否送达</span></td>
								<td class="line_table" align="center" colspan="2"><span
									class="left_bt2">确认订单</span></td>
							</tr>
							<c:forEach items="${result.list}" var="order">
								<tr>
									<td class="line_table" align="center"><span
										class="left_txt">${order.id}</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${order.user.id}</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${order.user.username }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${order.user.realname }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${order.user.telephone }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${order.user.address }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${order.product.name }</span></td>

									<td class="line_table" align="center"><span
										class="left_txt">${order.product.price2 }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${order.product.price2*order.productsum  }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${order.times }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${order.productsum }</span></td>
									<td class="line_table" align="center"><c:choose>
											<c:when test="${order.delivery==1 }">
												<span class="left_txt">是</span>
											</c:when>
											<c:otherwise>
												<span class="left_txt">否</span>
											</c:otherwise>
											</c:choose>
										</td>
										<td class="line_table" align="center"><c:choose>
											<c:when test="${order.reach==1 }">
												<span class="left_txt">是</span>
											</c:when>
											<c:when test="${order.delivery==0}">
												<span class="left_txt">否</span>
											</c:when>
											<c:otherwise>
												<a href="updateReach.do?id=${order.id}">否</a>
											</c:otherwise>
											</c:choose>
										</td>
									<td class="line_table" align="center">
									<c:choose>
									<c:when test="${order.delivery==1 }">
									<span class="left_txt">已确认</span>
											</c:when>
											<c:otherwise>
												<a href="updateOrder.do?id=${order.id}">确认</a>
											</c:otherwise>
									</c:choose>
									</td>
									<td class="line_table" align="center">
									<c:choose>
									<c:when test="${order.delivery==1&&order.reach==1}">
										<a href="updateIsOrder.do?id=${order.id}">删除</a>
											</c:when>
										<c:when test="${order.delivery==1&&order.reach==0}">
										<a href="updatedelivery.do?id=${order.id}">取消</a>
											</c:when>
											<c:otherwise>
													<a href="updateIsOrder.do?id=${order.id}">取消</a>
											</c:otherwise>
									</c:choose>
								</td>
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
										<a href="selectOrder.do">首页</a>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when test="${result.page.currentPage eq 1 }">上一页</c:when>
									<c:otherwise>
										<a href="selectOrder.do?curPage=${result.page.currentPage-1}">上一页</a>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when
										test="${result.page.currentPage eq result.page.totalPage }">下一页</c:when>
									<c:otherwise>
										<a href="selectOrder.do?curPage=${result.page.currentPage+1 }">下一页</a>
									</c:otherwise>
								</c:choose> <c:choose>
									<c:when
										test="${result.page.currentPage eq result.page.totalPage }">尾页</c:when>
									<c:otherwise>
										<a href="selectOrder.do?curPage=${result.page.totalPage }">尾页</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
				</div>




			</td>
		</tr>
	</table>
${update }
</body>
</html>