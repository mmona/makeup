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
			alert("��Ʒ���Ʋ���Ϊ��!");
			document.form1.name.focus();
			return false;
		}
		if (document.form1.author.value == "") {
			alert("ԭ�ϲ���Ϊ��!");
			document.form1.author.focus();
			return false;
		}
		if (document.form1.price.value == "") {
			alert("�г��۸���Ϊ��!");
			document.form1.price1.focus();
			return false;
		}
		if (document.form1.price1.value == "") {
			alert("��Ա�۸���Ϊ��!");
			document.form1.price1.focus();
			return false;
		}
		if (document.form1.brief.value == "") {
			alert("˵������Ϊ��!");
			document.form1.brief.focus();
			return false;
		}

		if (document.form1.img.value == "") {
			alert("�ϴ�ͼƬ����Ϊ��!");
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

				<p>��Ӳ˵�</p>

				<div align="center">

					<form action="../MenuAddServlet" method="post" name="form1"
						onSubmit="return check11()" enctype="multipart/form-data">


						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">��Ʒ���ƣ�</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="text" name="name" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">ԭ&nbsp;&nbsp;&nbsp; �ϣ�</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="text" name="burden" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">�г��۸�</span></td>
								<td height="25" width="80%"><input type="text" name="price"
									size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">��Ա�۸�</span></td>
								<td height="25" width="80%"><input type="text"
									name="price1" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">˵&nbsp;&nbsp;&nbsp; ����</span></td>
								<td class="line_table" height="25" width="80%"><textarea
										rows="12" name="brief" cols="100"></textarea></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">��Ʒ���</span></td>
								<td class="line_table" height="25" width="80%">
								<select name="typeid">
										<option value="1">�����</option>
										<option value="2">����</option>
										<option value="6">����</option>
										<option value="10">����</option>
										<option value="11">����</option>
								</select></td>
							</tr>

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">�ϴ�ͼƬ��</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="file" name="img" size="50"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="center" colspan="2"><input
									type="submit" value="���"></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
