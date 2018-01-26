<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
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
<script src="/jquery/jquery-2.2.4.min.js"
	type="text/javascript"></script>
<script language="JavaScript">
	function check11() {

		if (document.form1.newname.value == "") {
			alert("请输入用户名!");
			document.form1.newname.focus();
			return false;
		}
		if (document.form1.newpwd.value == "") {
			alert("请输入密码!");
			document.form1.newpwd.focus();
			return false;
		}
	}
	
</script >
<script type="text/javascript">
/* $("input[name='pwd']").val().remove();
 function updateAdmin(){
	$.ajax({
		url:"updateAdmin.do?id=${admin.id}",
		data:$("#update").serialize(),
		type:post,
		success:function(data){
			if(data.message == 'success'){
				alert("修改成功,请重新登录！！！");
			}else{
				
				alert("修改失败，请重新修改！！！");
			}
		}
	}
			
			
	
	
	
	
	)
} */



</script>
</head>

<body>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="center" bgcolor="#F7F8F9">


				<div align="center" >

					<form name="form1"  id="update"   action="updateAdmin.do?id=${admin.id}"
						method="post" onSubmit="return check11()"  target="_top">
						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">
							<tbody style="margin: 0; padding: 0">
								<tr>
									<td class="line_table" align="center" colspan="8" height="20">
										<span class="left_bt2">更改管理员信息</span>
									</td>
								</tr>

								<tr>
									<td class="line_table" align="right" width="45%"><span
										class="left_bt2">管理员姓名</span></td>
									<td class="line_table" align="left" width="55%"><input
										type="text" name="name" size="20" value="${admin.name }"></td>
								</tr>
								<tr>
									<td class="line_table" align="right" width="45%"><span
										class="left_bt2">管理员密码</span></td>
									<td class="line_table" align="left" width="55%"><input
										type="password" name="pwd" size="20" value="${admin.password }"/>
										
									</td>
								</tr>
								<tr>
									<td class="line_table" align="center" colspan="8" height="20">
										<input type="submit" value="修改"   />
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>


			</td>


		</tr>
	</table>

</body>
</html>
