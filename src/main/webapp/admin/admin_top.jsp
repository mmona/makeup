<%@page import="java.util.*"%>
<%@ page import="com.mona.makeup.pojo.User" %>
<%@ page language="java"  pageEncoding="utf-8"%>
<html>
<title>网上订餐后台- 管理页面</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<script src="/jquery/jquery-2.2.4.min.js"
	type="text/javascript"></script> 
<link href="images/skin.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0">

<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64"></td>
    <td width="39%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="admin_txt">管理员：<b>${admin.name}</b> 您好,感谢登陆使用！</td>
        <td width="22%"><a href="../admin/index.jsp" style="text-decoration: none;color: #fff">系统退出</a></td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>