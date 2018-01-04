<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
<head>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
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
<script language="JavaScript">
	function check11() {

		if (document.form1.name.value == "") {
			alert("菜品名称不能为空!");
			document.form1.name.focus();
			return false;
		}
		if (document.form1.author.value == "") {
			alert("原料不能为空!");
			document.form1.author.focus();
			return false;
		}
		if (document.form1.price.value == "") {
			alert("市场价格不能为空!");
			document.form1.price1.focus();
			return false;
		}
		if (document.form1.price1.value == "") {
			alert("会员价格不能为空!");
			document.form1.price1.focus();
			return false;
		}
		if (document.form1.brief.value == "") {
			alert("说明不能为空!");
			document.form1.brief.focus();
			return false;
		}

		if (document.form1.img.value == "") {
			alert("上传图片不能为空!");
			document.form1.img.focus();
			return false;
		}
	}
</script>
</head>
<body>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">

				<p>添加菜单</p>

				<div align="center">

					<form action="../MenuAddServlet" method="post" name="form1"
						onSubmit="return check11()" enctype="multipart/form-data">


						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">菜品名称：</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="text" name="name" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">原&nbsp;&nbsp;&nbsp; 料：</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="text" name="burden" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">市场价格：</span></td>
								<td height="25" width="80%"><input type="text" name="price"
									size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">会员价格：</span></td>
								<td height="25" width="80%"><input type="text"
									name="price1" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">说&nbsp;&nbsp;&nbsp; 明：</span></td>
								<td class="line_table" height="25" width="80%"><textarea
										rows="12" name="brief" cols="100"></textarea></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">菜品类别：</span></td>
								<td class="line_table" height="25" width="80%">
								<select name="typeid">
										<option value="1">凉拌菜</option>
										<option value="2">炒菜</option>
										<option value="6">炒饭</option>
										<option value="10">蒸菜</option>
										<option value="11">川菜</option>
								</select></td>
							</tr>

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">上传图片：</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="file" name="img" size="50"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="center" colspan="2"><input
									type="submit" value="添加"></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
