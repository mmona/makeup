<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客服中心</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />

</head>
<script language="JavaScript">
	function check11() {
		if (document.form1.content.value == "") {
			alert("提问内容不能为空!");
			document.form1.content.focus();
			return false;
		}
	}
</script>

<script type="text/javascript" src="js/common.js"></script>

 
<body >
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  
    
  <jsp:include flush="fasle" page="top.jsp"/>
    
    </td>
  </tr>
  <tr >
  <td height="50"></td>
  
</tr>
  
  <tr>
    <td align="center" valign="top" height="400">
    
    <table border="0" cellspacing="0"  width="100%">
    
		<tr>
		  <td  align="center" vlign="top"  >
			 <strong><span style="font-family: Helvetica, sans-serif;font-size: 20px; color:#FF69B4">
			       客服中心
			 </span></strong>
			 <br>
		  </td>
		</tr>
		<form action="addQuestion.do" method="post"
						name="form1" onSubmit="return check11()">
		<tr>
		  <td  align="center" vlign="top" >
		  <textarea rows="12" cols="100" name="content"></textarea>
		  </td>
		</tr>
		<tr>
		<td  align="center" vlign="top" >
		  <input  class="answer" type=submit value="提交"/>
		  </td>
		  </tr>
		  </form>
		<tr>
		  <td  align="center"  >
			 <a href="indexInfo.do" target="_self">
			 <span style="font-family: Helvetica, sans-serif;font-size: 16px; color:#FF69B4">
			     返回
			 </span></a>
		  </td>
		</tr>	
   </table>
 
 
    
    
    
     </td>
  </tr>
  <tr>
    <td height="10">&nbsp;</td>
  </tr>
  <tr>
    <td height="50" align="center" valign="middle">&nbsp; 
   
        <jsp:include flush="fasle" page="copyright.jsp"/>
    </td>
  </tr>
  
</table>
${success }
 ${fail }
</body>
</html>
