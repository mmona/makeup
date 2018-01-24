<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <base
	href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
body {
	font:12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	margin: 0px;
}
#container {
	width: 182px;
}
H1 {
	font-size: 12px;
	margin: 0px;
	width: 182px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;	
}
H1 a {
	display: block;
	width: 182px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}
.content{
	width: 182px;
	
}
.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block;
}
.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 182px;
	padding-left: 0px;
}
.MM {
	width: 182px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px,0px,0px,0px);
}
.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
</style>
</head>

<body>


<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="type"><a href="javascript:void(0)">会员管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
        <li><a href="seletAllUser.do" target="main">会员信息列表</a></li>
      
        </ul>
      </div>
     
      <h1 class="type"><a href="javascript:void(0)">商品信息管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
            <li><a href="selectProduct.do" target="main">商品信息列表</a></li>
        </ul>
        <ul class="MM">
            <li><a href="admin/addproduct.jsp" target="main">添加商品信息</a></li>
        </ul>
      </div>
       <h1 class="type"><a href="javascript:void(0)">化妆品类别管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
            <li><a href="admin/type_add.jsp" target="main">添加新类别</a></li>
            <li><a href="selectType.do" target="main">类别信息列表</a></li>
        </ul>
      </div>
       <h1 class="type"><a href="javascript:void(0)">化妆品品牌管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
            <li><a href="admin/brand_add.jsp" target="main">添加新品牌</a></li>
            <li><a href="selectBrand.do" target="main">品牌信息列表</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">销售订单管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
          <li><a href="selectOrder.do" target="main">销售订单信息列表</a></li>
          <li><a href="searchOrder.do" target="main">销售订单查询</a></li>
          <li><a href="selectOrderByTimes.do" target="main">本日销售额统计</a></li>
        </ul>
      </div>
       <h1 class="type"><a href="javascript:void(0)">客服管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
            <li><a href="selectQuestion.do" target="main">提问信息列表</a></li>
            <li><a href="selectReview.do" target="main">回复信息列表</a></li>
        </ul>
      </div>
    </div>

    <h1 class="type"><a href="admin/admin_update.jsp" target="index">系统用户管理</a></h1>
    <h1 class="type"><a href="admin/logout.do" target="index">注销退出</a></h1>
      </td>
  </tr>
</table>
</body>
</html>
