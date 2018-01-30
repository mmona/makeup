<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户中心</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />

</head>


<script type="text/javascript" src="js/common.js"></script>

<script language="JavaScript">
	function check11() {
		if (document.form1.pwd.value == "") {
			alert("密码不能为空!");
			document.form1.pwd.focus();
			return false;
		}
		if (document.form1.qpwd.value == "") {
			alert("确认密码不能为空!");
			document.form1.qpwd.focus();
			return false;
		}
		if (document.form1.qpwd.value != document.form1.pwd.value) {
			alert("两次密码不一致!");
			document.form1.qpwd.focus();
			return false;
		}
	
	}
</script>



<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="20"></td>

		</tr>

		<tr>
			<td align="center" valign="center" height="450">

				<form action="updatePassword.do" name="form1" method="post"
					onSubmit="return check11()">

					<div align="center">
						<br>
						<table border="1" cellspacing="0" bordercolorlight="#C0C0C0"
							bordercolordark="#C0C0C0" width="700">
							<tr>
								<td colspan="3" align="center" bordercolorlight="#C0C0C0"
									bordercolordark="#C0C0C0" height="50"><font
									color=" #FF69B4" style="font-weight:bold;">请填写用户名以及新密码
								</font></td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="50" align="right"><font color="#FF69B4"">用 户
										名：</font></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="50" align="left">
									<input class="input7"
									type="text" name="username" value="${user.password }" /></td>								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="50" align="left"><font color="red">&nbsp;*
								</font>您用来登录的用户名</td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="50" align="right"><font color="#FF69B4"">新 &nbsp;密&nbsp;
										码：&nbsp;</font></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="50" align="left"><input class="input7"
									type="password" name="pwd" value="${user.password }" /></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="50" align="left"><font color="red">&nbsp;*
								</font>长度必须大于5个小于16个字符，只能为英语字、数字</td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="50" align="right"><font color="#FF69B4"">确认密码：</font>
								</td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="50" align="left"><input class="input7"
									type="password" name="qpwd" value="${user.password }" /></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="50" align="left"><font color="red">&nbsp;*
								</font>请将输入的密码再次输入</td>
							</tr>
							
							<tr>
								<input type="hidden" name="id" value="${user.id }">
								<td colspan="3" align="center" bordercolorlight="#C0C0C0"
									bordercolordark="#C0C0C0" height="50"><input type="submit"
									value="修改" /></td>
							</tr>
						</table>
					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td height="10">&nbsp;</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle">&nbsp; <jsp:include
					flush="fasle" page="copyright.jsp" />
			</td>
		</tr>

	</table>

${success }

</body>
</html>
