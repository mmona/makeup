<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
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
</head>
<body>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="11" height="20"><span
									class="left_bt2">会员信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">登录名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">密码</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">真实姓名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">性别</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">年龄</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">家庭住址</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">身份证号</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">电话号码</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">电子邮箱</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">邮政编码</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
							</tr>

							<tr>
								<td class="line_table" align="center"><a
									href="menus_update.jsp?">糖醋排骨</a></td>
								<td class="line_table" align="center">32432432</td>
								<td class="line_table" align="center"><span
									class="left_txt">排骨、糖、醋</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">炒菜到底</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">暂无</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">26.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">24.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">4</span></td>
									<td class="line_table" align="center"><span
									class="left_txt">4</span></td>
								<td class="line_table" align="center"><a
									href="user_update.jsp">修改</a></td>
								<td class="line_table" align="center"><a href="#">删除</a></td>
							</tr>

							<tr>
								<td class="line_table" align="center"><a
									href="menus_update.jsp?">咸肉菜饭</a></td>
								<td class="line_table" align="center"><a
									href="../img/m_xianroucaifan.gif"><img
										src="../img/m_xianroucaifan.gif" width="30" heigth="30"></a></td>
								<td class="line_table" align="center"><span
									class="left_txt">咸肉、米饭</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">炒饭</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">暂无</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">15.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">12.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">4</span></td>
								<td class="line_table" align="center"><a
									href="menus_update.jsp">修改</a></td>
								<td class="line_table" align="center"><a href="#">删除</a></td>
							</tr>

							<tr>
								<td class="line_table" align="center"><a
									href="menus_update.jsp?">水煮鱼</a></td>
								<td class="line_table" align="center"><a
									href="../img/m_shuizhuyu.gif"><img
										src="../img/m_shuizhuyu.gif" width="30" heigth="30"></a></td>
								<td class="line_table" align="center"><span
									class="left_txt">鱼，辣椒</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">川菜</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">暂无</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">38.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">32.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><a
									href="menus_update.jsp">修改</a></td>
								<td class="line_table" align="center"><a href="#">删除</a></td>
							</tr>

							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
									<span class="left_bt2">第1页 &nbsp;&nbsp;共1页 </span>&nbsp;&nbsp;
									<a href="#">[首页]</a> <a href="#">[尾页]</a>&nbsp;&nbsp; <a
									href="#%>">[上一页]</a> <a href="#">[下一页]</a>
								</td>
							</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
