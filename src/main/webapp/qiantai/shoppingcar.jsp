<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>-购物车</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/skin.css" rel="stylesheet" type="text/css" />
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


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 700px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">
										<tr>
											<td class="line_table" align="center" colspan="5"><span
												class="left_bt2">我的购物车信息列表</span></td>
										</tr>
										<tr>
											<td class="line_table" align="center" width="40%"><span
												class="left_bt2">化妆品名称</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">单价</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">数量</span></td>
											<td class="line_table" align="center" width="10%"><span
												class="left_bt2">&nbsp;&nbsp;</span></td>
											<td class="line_table" align="center" width="10%"><span
												class="left_bt2">&nbsp;&nbsp;</span></td>
										</tr>
										<c:forEach items="${result.list }" var="order">
											<tr>
												<td class="line_table" align="center" width="40%"><span
													class="left_txt">${order.product.name }</span></td>
												<td class="line_table" align="center" width="20%"><span
													class="left_txt">${order.product.price2 }</span></td>
												<td class="line_table" align="center" width="20%"><span
													class="left_txt">${order.productsum }</span></td>
												<c:set
													value="${sum + order.product.price2*order.productsum}"
													var="sum" />
												<c:set value="${sum1 + order.productsum}" var="sum1" />
												<td class="line_table" align="center" width="10%"><a
													href="deleteShoppingCar.do?id=${order.id }">取消</a></td>
												<td class="line_table" align="center" width="10%"><a
													href="updateShoppingCar.do?id=${order.id }">提交</a></td>
											</tr>

										</c:forEach>

										<tr>
											<td class="line_table" align="center" colspan="5"><span
												class="left_bt2">小&nbsp;&nbsp;计：</span>&nbsp; <span
												style="color: #ff0000;">${sum }</span>&nbsp;&nbsp; <span
												class="left_bt2">元</span>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span class="left_bt2">共：</span>&nbsp; <span
												style="color: #ff0000;">${sum1 }</span>&nbsp; <span
												class="left_bt2">份</span></td>

										</tr>
										<tr>
										<c:if test="${result.list!=null }">
										
										<tr>
											<td class="line_table" align="center" colspan="5"
												valign="center"><a href="updateshopping.do"><img
													src="images/canche_submit.gif" border="0" /></a>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

												<a href="deleteshopping.do"><img
													src="images/quxiao2.gif" border="0" /></a></td>

										</tr>
										
										
										</c:if>
										
								</table>
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
									<a href="selectShopping.do">首页</a>
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${result.page.currentPage eq 1 }">上一页</c:when>
								<c:otherwise>
									<a
										href="selectShopping.do?curPage=${result.page.currentPage-1}">上一页</a>
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when
									test="${result.page.currentPage eq result.page.totalPage }">下一页</c:when>
								<c:otherwise>
									<a
										href="selectShopping.do?curPage=${result.page.currentPage+1 }">下一页</a>
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when
									test="${result.page.currentPage eq result.page.totalPage }">尾页</c:when>
								<c:otherwise>
									<a href="selectShopping.do?curPage=${result.page.totalPage }">尾页</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</table>
				</div>
			</td>
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
	${deleteshoppingcar }

</body>
</html>
