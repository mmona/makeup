<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="gb2312"%>

<html>
<title>��ױƷ����</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/skin.css" rel="stylesheet" type="text/css" />
</head>



<body style='background:transparent'>
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
    <td align="center" valign="center" height="450">
    

    <div align="center">
	

    <table id="table2"   class="line_table" style="width:100%;  margin: 0; padding: 0" cellSpacing="0" cellPadding="0">
   
		<tr>
			<td  class="line_table" height="25" align="right" width="20%"><span class="left_bt2">��ױƷ���ƣ�</span></td>
			<td class="line_table" height="25"  width="70%">
			<span class="left_bt2">${product.name }</span></td>
		</tr>
		<tr>
			<td  class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">��	Ҫ�ɷ� ��
			</span></td>
			<td class="line_table" height="25" width="80%">
			<span class="left_bt2">${product.burden}</span></td>
		</tr>
		<tr>
			<td class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">ԭ&nbsp;&nbsp;&nbsp;
			�ۣ�</span></td>
			<td  class="line_table" height="25"  width="80%">
			<span class="left_bt2">${product.price1}</span></td>
		</tr>
		<tr>
			<td class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">��Ա��
			�ۣ�</span></td>
			<td height="25"  width="80%">
			<span class="left_bt2" height="25"  width="80%">${product.price2}</span></td>
		</tr>
		<tr>
			<td class="line_table"  height="25"  align="right" width="20%"><span class="left_bt2">��&nbsp;&nbsp;&nbsp; 
			����</span></td>
			<td class="line_table" height="25"  width="80%">
			<span class="left_bt2">${product.description}</span></td>
		</tr>
		<tr>
			<td  class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">��ױƷ���</span></td>
			<td  class="line_table"  height="25"  width="80%">
			<span class="left_bt2">${product.type.tname}</span>
			</td>
		</tr>
		<tr>
			<td class="line_table" align="right" width="20%">
			<span class="left_bt2">չʾͼƬ</span>��</td>
			<td  class="line_table" width="80%" align="left"><img src="../upload/${product.imgpath}"></td>
		</tr>

		<tr>
			<td  class="line_table" height="25"  align="center" colspan="2">
			<a href="indexInfo.do" target="_self"><input type="submit" value="����"></a>
			</td>
		</tr>
		
    
		</table>

  	</div>
    
    
    
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
