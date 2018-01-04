<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
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
											<td class="line_table" align="center" colspan="4"><span
												class="left_bt2">我的购物车信息列表</span></td>
										</tr>
										<tr>
											<td class="line_table" align="center" width="40%"><span
												class="left_bt2">化妆品名称</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">单价</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">数量</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">&nbsp;&nbsp;</span></td>
										</tr>
										<tr>
											<td class="line_table" align="center" width="40%"><span
												class="left_txt">糖醋排骨</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_txt">24.0</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_txt">1</span></td>
											<td class="line_table" align="center" width="20%"><a
												href="#">取消</a></td>
										</tr>
										<tr>
											<td class="line_table" align="center" width="40%"><span
												class="left_txt">咸肉菜饭</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_txt">12.0</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_txt">1</span></td>
											<td class="line_table" align="center" width="20%"><a
												href="#">取消</a></td>
										</tr>
										

										<tr>
											<td class="line_table" align="center" colspan="4"><span
												class="left_bt2">小&nbsp;&nbsp;计：</span>&nbsp; <span
												style="color: #ff0000;">36.0</span>&nbsp;&nbsp; <span
												class="left_bt2">元</span>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span class="left_bt2">共：</span>&nbsp; <span
												style="color: #ff0000;">2</span>&nbsp; <span
												class="left_bt2">份</span></td>

										</tr>
<tr>
										
										<tr>
											<td class="line_table" align="center" colspan="4"
												valign="center"><a href="#"><img
													src="images/canche_submit.gif" border="0" /></a>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

												<a href="#"><img src="images/quxiao2.gif" border="0" /></a></td>

										</tr>
											<tr>
																<td class="line_table" align="center" colspan="11"
																	height="20"><span class="left_bt2">第1页
																		&nbsp;&nbsp;共1页 </span>&nbsp;&nbsp; <a href="#">[首页]</a> <a
																	href="#">[尾页]</a>&nbsp;&nbsp; <a href="#%>">[上一页]</a> <a
																	href="#">[下一页]</a></td>
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



</body>
</html>
