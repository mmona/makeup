<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>女孩地带</title>
<meta content="" name=keywords />
<meta content="" name=description />
<!-- <link href="css/common.css" rel="stylesheet" type="text/css" /> -->
<script src="${basePath}/makeup/jquery/jquery-2.2.4.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/form.js"></script>
<script type="text/javascript" src="js/blockui.js"></script>
<script type="text/javascript">
	$(function() {
		/* 	selectshoppingcar();
			selectRecommend(); */
	});
</script>

</head>



<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="30"></td>

		</tr>

		<tr>
			<td align="left" valign="top"><table width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="59%" align="left" valign="top"><div id='pdv_3606'
								class='pdv_class' title=''
								style='width: 648px; top: 0px; left: 0px; z-index: 12'>
								<div id='spdv_3606' class='pdv_content'
									style='overflow: visible; width: 100%;'>
									<div class="pdv_border"
										style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
										<!-- <div style="height:25px;margin:1px;display:none;background:;">
                <div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:"></div>
                <div style="float:right;margin-right:10px;display:none"> <a href="-1" style="line-height:25px;color:">更多</a> </div>
              </div>-->
										<div style="padding: 0px">
											<link href="css/dingcanall.css" rel="stylesheet"
												type="text/css" />
											<script src="js/dingcanall.js" type="text/javascript"></script>

											<div id="dingcanall2">

												<div style="margin-top: 0px; padding: px;">
													<c:forEach items="${result.list}" var="product">
														<div
																style="margin-top: 10px; margin-left: 30px; float: left;">
															<table>
																<tr>

																	<td style="margin-top: 10px;">
																		<div>
																			<table>
																				<tr>
																					<td rowspan="5" class="bookPic"><img
																			src="../${product.imgpath}" width="100px" height="90px" /></td>
																					<td ><span>化妆品名称:</span></td>
																					<td ><span><strong
																							style="color: HotPink;"><a
																								href="selectProducrInfo.do?id=${product.id }" >${product.name}</a></strong></span></td>
																				</tr>
																				<tr>
																					<td><span>原价:</span></td>
																					<td><span style="color: HotPink;">${product.price1 }</span></td>
																				</tr>
																				<tr>
																					<td><span>现价:</span></td>
																					<td><span><strong style="color: red;">${product.price2 }</strong></span></td>
																				</tr>
																				<tr>
																					<td><span>品牌:</span></td>
																					<td><span style="color: HotPink;">${product.brand.bname}</span></td>
																				</tr>
																				<tr>
																					<td><span>类型:</span></td>
																					<td><span style="color: HotPink;">${product.type.tname}</span></td>
																				</tr>
																				<tr>
																					<td colspan="2" style="height: 40px;"><c:choose>
																							<c:when test="${user!=null }">
																								<a href="addShoppingCar.do?id=${product.id }" style="color: HotPink;">加入购物车</a>
																							</c:when>
																							<c:otherwise>
																								<a href="login.do" style="color: HotPink;">加入购物车</a>
																							</c:otherwise>
																						</c:choose></td>
																					<td></td>
																				</tr>
																			</table>
																		</div>
																			
																	</td>
																</tr>

															</table>

														</div>
												</c:forEach>
													
												</div>

											</div>

										</div>

										<div id="dingcanall_bottom_left">&nbsp;</div>
										<div id="dingcanall_bottom_right">&nbsp;</div>
										<input type="hidden" name="picw" id="picw" value="150" /> <input
											type="hidden" name="pich" id="pich" value="140" /> <input
											type="hidden" name="fittype" id="fittype" value="auto" />
									</div>
								</div>
							</div>
							</div>
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
																		<a href="indexInfo.do">首页</a>
																	</c:otherwise>
																</c:choose> <c:choose>
																	<c:when test="${result.page.currentPage eq 1 }">上一页</c:when>
																	<c:otherwise>
																		<a
																			href="indexInfo.do?curPage=${result.page.currentPage-1}">上一页</a>
																	</c:otherwise>
																</c:choose> <c:choose>
																	<c:when
																		test="${result.page.currentPage eq result.page.totalPage }">下一页</c:when>
																	<c:otherwise>
																		<a
																			href="indexInfo.do?curPage=${result.page.currentPage+1 }">下一页</a>
																	</c:otherwise>
																</c:choose> <c:choose>
																	<c:when
																		test="${result.page.currentPage eq result.page.totalPage }">尾页</c:when>
																	<c:otherwise>
																		<a
																			href="indexInfo.do?curPage=${result.page.totalPage }">尾页</a>
																	</c:otherwise>
																</c:choose></td>
														</tr>
													</table>
							
							</td>
						
						<td width="41%" align="right" valign="top"><table width="243"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td></td>
								</tr>
								<tr>
									<td valign="top"><div id='pdv_' class='pdv_class'
											title='商品查询'
											style='width: 243px; top: 0px; left: 0px; z-index: 3'>
											<div id='spdv_3603' class='pdv_content'
												style='overflow: hidden; width: 100%; height: 100%'>
												<div class="pdv_border"
													style="border: 0px; height: 100%; padding: 0; margin: 0; background: url(base/border/640/images/left.jpg) repeat-y">
													<div
														style="height: 100%; background: url(images/right.jpg) right repeat-y">
														<div
															style="height: 43px; background: url(images/bg.jpg) 0px 0px no-repeat">
															<div
																style="float: left; font: bold 16px/43px 'Microsoft YaHei', 'SimSun', Arial, Sans-Serif; text-align: left; padding-left: 50px; color: #FF69B4;">
																商品查询</div>
														</div>
														<div style="margin: 0px 3px; padding: 10px;" align="left">
															<link href="css/newslist_time2.css" rel="stylesheet"
																type="text/css" />


															<div align="center" width="120">
																<form action="indexInfo.do" name="form1"
																	method="post">
																	<table id="table1" class="line_table"
																		style="width: 100%; margin: 0; padding: 0"
																		cellSpacing="0" cellPadding="0">
																		<tbody style="margin: 0; padding: 0">

																			<tr>
																				<td class="line_table" align="left" width="60%"><input
																					type="text" name="name" size="20" value=""> <input
																					type="submit" class="btn btn-primary pull-right"
																					value="查询"></td>
																			</tr>
																	</table>
																</form>
															</div>
														</div>
													</div>
												</div>
												<div
													style="margin-top: -10px; height: 10px; line-height: 10px; background: url(images/bg.jpg) 0px -220px no-repeat">&nbsp;</div>
												<div
													style="float: right; margin-top: -10px; width: 10px; height: 10px; line-height: 10px; background: url(images/bg.jpg) -890px -220px no-repeat">&nbsp;</div>
											</div>
										</div></td>
								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>
									<td valign="top">
										<div id='pdv_3614' class='pdv_class' title='购物车'
											style='width: 243px; top: 0px; left: 0px; z-index: 2'>
											<div id='spdv_3614' class='pdv_content'
												style='overflow: visible; width: 100%;'>
												<div class="pdv_border"
													style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
													<div
														style="height: 25px; margin: 1px; display: none; background:;">
														<div
															style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color: #FF69B4">
															购物车</div>

													</div>
													<div style="padding: 0px">
														<link href="css/dingcanche.css" rel="stylesheet"
															type="text/css" />
														<script src="js/dingcanall.js" type="text/javascript"></script>
														<script src="js/dingcansubmit.js" type="text/javascript"></script>
														<div id="dingcanche">
															<div id="dingcanche2">
																<div id="dingcanche_top">
																	<div id="dingcanche_top_left" style="color: HotPink;">购物车</div>
																	<div id="dingcanche_top_right">&nbsp;</div>
																</div>


																<div id="dcinfo" style="margin: 0px 3px 1px 3px;"></div>
																<table width="100%" border="0" cellspacing="0"
																	style="background: #fef0d3;">
																	<tr>
																		<td align="center">化妆品名称</td>
																		<td align="center">单价</td>
																		<td align="center">数量</td>
																		<td align="center"></td>
																	</tr>
																	<c:forEach items="${indexShopping }" var="order">
																		<tr id="shoppingcar">
																			<td align="center">${order.product.name }</td>
																			<td align="center">${order.product.price2 }</td>
																			<td align="center">${order.productsum }</td>
																			<c:set
																				value="${sum + order.product.price2*order.productsum}"
																				var="sum" />
																			<c:set value="${sum1 + order.productsum}" var="sum1" />
																			<td align="center"><a
																				href="deleteShoppingindex.do?id=${order.id }">取消</a></td>
																		</tr>
																	</c:forEach>

																</table>



																<div style="height: 24px; margin: 5px 3px 1px 3px;">
																	<div
																		style="float: left; line-height: 24px; padding-left: 25px;">小&nbsp;&nbsp;计：</div>
																	<div
																		style="float: right; line-height: 24px; padding-right: 15px;">
																		<font id="allnums" style="color: #ff0000;">${sum1 }</font>份
																	</div>
																	<div
																		style="float: right; line-height: 24px; padding-right: 30px;">
																		<font id="cpprice" style="color: #ff0000;">${sum }</font>元
																	</div>
																</div>
																<div style="height: 30px; margin: 5px 3px 1px 3px;">
																	<table width="100%" border="0" cellspacing="0">
																		<tr>
																			<td align="center" width="40%"></td>
																			<td align="center" width="40%"><a
																				href="updateindexshopping.do"><img
																					src="images/canche_submit.gif" border="0" /></a></td>
																			<td align="center" width="40%"><a
																				href="deleteindexshopping.do"><img
																					src="images/quxiao2.gif" border="0" /></a></td>
																		</tr>
																	</table>

																</div>
															</div>
														</div>
													</div>
													<div id="dingcanche_bottom_left">&nbsp;</div>
													<div id="dingcanche_bottom_right">&nbsp;</div>
													<input type="hidden" name="modnums_b" id="modnums_b"
														value="" />
													<script>
														$("div.cpline_d:even")
																.addClass(
																		"cpline_s");
													</script>
												</div>
											</div>
										</div>
										</div>

									</td>
								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>
									<td valign="top"><div id='pdv_3613' class='pdv_class'
											title='店长推荐'
											style='width: 243px; top: 0px; left: 0px; z-index: 5'>
											<div id='spdv_3613' class='pdv_content'
												style='overflow: hidden; width: 100%; height: 100%'>
												<div class="pdv_border"
													style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
													<div
														style="height: 25px; margin: 1px; display: none; background:;">
														<div
															style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color: #FF69B4;">
															店长推荐</div>
														<div style="float: right; margin-right: 10px; display:">
															<a href="-1" style="line-height: 25px; color:">更多</a>
														</div>
													</div>
													<div style="padding: 0px">
														<link href="css/dingcanweekmenu.css" rel="stylesheet"
															type="text/css" />
														<div id="dingcanweekmenu">
															<div id="dingcanweekmenu2">
																<div id="dingcanweekmenu_top">
																	<div id="dingcanweekmenu_top_left"
																		style="color: #FF69B4;">店长推荐</div>
																	<div id="dingcanweekmenu_top_right">&nbsp;</div>

																</div>
																<div style="padding: px;">
																	<div class="dingcanweekmenuinfo" align="left">
																		<link href="css/newslist_time2.css" rel="stylesheet"
																			type="text/css" />
																		<c:forEach items="${recommend}" var="recommend">

																			<li class="newslist_time2" id="recommend"><div
																					class="time">${recommend.price2 }￥</div> <a
																				href="#" class="newslist_time2">${recommend.name }</a></li>
																		</c:forEach>
																	</div>
																</div>
															</div>
														</div>
														<!--<div id="dingcanweekmenu_bottom_left"></div>
                    <div id="dingcanweekmenu_bottom_right">&nbsp;</div>-->
													</div>
												</div>
												<!-- </div>-->
											</div></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
			
		</tr>
			
		<tr>
			<td height="10">&nbsp;</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>

	</table>
	${deleteshoppingcar}


</body>
</html>
