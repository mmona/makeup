<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>关于我们</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />

</head>


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
			       关于我们
			 </span></strong>
			 <br>
		  </td>
		</tr>
		<tr>
		  <td  align="left" vlign="top" >
             <p style=" font-size: 16px; color:#FF69B4">
              <br><br>
 
             &nbsp;&nbsp;&nbsp;&nbsp;无论是一支光彩艳丽的口红，还是一张水润莹亮的面膜，这里有你想要变美的一切。我们有当下最时尚的彩妆，也有呵护肌肤的各种营养蛋白，更有贴心周到的服务！<br><br>
             &nbsp;&nbsp;&nbsp;&nbsp;欢迎来到女孩地带，一起变成精致的猪猪女孩吧！
             </p>
        
		  </td>
		</tr>
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


 
</body>
</html>
