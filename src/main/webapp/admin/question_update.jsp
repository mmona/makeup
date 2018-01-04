<%@page import="java.util.*" %>
<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head>
<script language="JavaScript">
	function check11() {
		if (document.form1.name.value == "") {
			alert("回复内容不能为空!");
			document.form1.name.focus();
			return false;
		}
	}
</script>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
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
				<p>回复问题</p>

				<div align="center">
					<form action="#" method="post"
						name="form1" onSubmit="return check11()">
						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">

							<tr>
								<td class="line_table" height="25" align="right" width="40%"><span
									class="left_bt2">问题：</span></td>
								<td class="line_table" height="25" width="60%">
								<textarea rows="12" cols="100" name="content"  value="这是个问题"> 这是个问题</textarea>
									<input type="hidden" name="id" value="1" /></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="40%"><span
									class="left_bt2">品牌描述：</span></td>
								<td class="line_table" height="25" width="60%">
								<textarea rows="12" cols="100" name="content"  value="dfasdfs"></textarea>
									<input type="hidden" name="id" value="1" /></td>
							</tr>
							

							<tr>
								<td class="line_table" height="25" align="center" colspan="2">
									<input type="submit" value="回复">
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
