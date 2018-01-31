<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<base
	href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<html>
<head>
<link href="admin/images/skin.css" rel="stylesheet" type="text/css" />
<script src="${basePath}/makeup/jquery/jquery-2.2.4.min.js"
	type="text/javascript"></script>
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
<script type="text/javascript">
function check11(){
	if (document.form1.name.value == "" ) 
	{
		alert("化妆品名称不能为空!");
		document.form1.name.focus();
		return false;
	}
	if (document.form1.price1.value == "" ) 
	{
		alert("原价不能为空!");
		document.form1.price1.focus();
		return false;
	}
	if (document.form1.price2.value == "" ) 
	{
		alert("会员价不能为空!");
		document.form1.price2.focus();
		return false;
	}
}
	$(function() {
		selecttype();
		selectBrand();
	});
	function selecttype(){
		$.ajax({
			url : "typeInfo.do",
			type : "post",
			dataType : "json",
			success : function(data) {
					$.each(data, function(index, element) {
						$("select[name='typeid']").append($("<option value='"+element.id+"'>"+element.tname+"</option>"));
					})
			}
		});
	}
	function selectBrand(){
		$.ajax({
			url : "brandInfo.do",
			type : "post",
			dataType : "json",
			success : function(data) {
					$.each(data, function(index, element) {
						$("select[name='brandid']").append($("<option value='"+element.id+"'>"+element.bname+"</option>"));
					})
			}
		});
	}

</script>
</head>
<body>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<p>添加商品</p>
				<div align="center">
					<form action="addProduct.do" method="post" name="form1"
						onSubmit="return check11()">
						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">化妆品名称：</span></td>
								<td class="line_table" height="25" width="70%"><input
									type="text" name="name" size="45" value=""></td>
							</tr>

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">主要成分：</span></td>
								<td class="line_table" height="25" width="80%"><textarea
										rows="5" name="burden" cols="100"></textarea></td>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">原&nbsp;&nbsp;&nbsp;价：</span></td>
								<td height="25" width="80%"><input type="text" name="price1"
									size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">会员价格：</span></td>
								<td height="25" width="80%"><input type="text"
									name="price2" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">主要描述：</span></td>
								<td class="line_table" height="25" width="80%"><textarea
										rows="5" name="description" cols="100"></textarea></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">化妆品类别：</span></td>
								<td class="line_table" height="25" width="80%"><select
									name="typeid">

								</select></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">化妆品品牌：</span></td>
								<td class="line_table" height="25" width="80%"><select
									name="brandid">

								</select></td>
							</tr>
						 <%-- <tr>
								<td class="line_table" align="right" width="20%"><span
									class="left_bt2">展示图片</span>：</td>
								<td class="line_table" width="80%" align="left"> <a 
									class="a-upload" href="admin/updatephoto.jsp"><img
									src="upload/${product.imgpath }" name="file"/>
								</a></td>
							</tr>  --%>

							<tr>

								<td class="line_table" height="25" align="center" colspan="2">
									<input type="submit" value="添加">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</td>

		</tr>
	</table>


</body>
</html>
