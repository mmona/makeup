<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
<head>
<script language="JavaScript">
	function check11() {

		if (document.form1.name.value == "") {
			alert("请输入标题!");
			document.form1.name.focus();
			return false;
		}
		if (document.form1.content.value == "") {
			alert("请输入内容!");
			document.form1.content.focus();
			return false;
		}
	}
</script>

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
</head>

<body>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<p>&nbsp;</p>

				<div align="center">

					<form action="#" method="post"
						name="form1" onSubmit="return check11()">


						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">

							<tr>
								<td class="line_table" align="right" width="10%"><span
									class="left_bt2">公告标题：</span></td>
								<td class="line_table" width="90%"><input type="text"
									name="name" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" align="right" width="10%"><span
									class="left_bt2">公告内容：</span></td>
								<td class="line_table" width="90%"><textarea rows="14"
										name="content" cols="105"></textarea></td>
							</tr>
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
