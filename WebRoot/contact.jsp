<%@ page contentType="text/html; charset=gbk" %>
<%@ page language="java" import="java.util.*,xidian.qlj.model.*" pageEncoding="gbk"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UserBean ub=(UserBean)request.getAttribute("userInfo");
PartyBean up=(PartyBean)request.getAttribute("partyInfo");
String end=(String)request.getSession().getAttribute("goodDayInfo");
if(end=="")
{
   end="没选";
}
%>

<html>
<head>
<title>Reusable web templates.</title>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<meta NAME="keywords" CONTENT=" ChooseDate.">
<meta NAME="description" CONTENT="ChooseDate.">
<meta NAME="rating" CONTENT="General">
<meta NAME="ROBOTS" CONTENT="ALL">
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="images/bckground.gif">
<table cellspacing="0" cellpadding="0" border="0" height="66" width="100%" background="images/topbarbkg.gif">
  <tr valign="top"> 
    <td width="796" height="45"><img src="images/topbar.jpg" width="699" height="91"></td>
  </tr>
</table>
<table cellspacing="0" cellpadding="0" border="0" height="208" width="762">
  <tr> 
    <td width="258" height="2" valign="top"> 
      <div align="left"><img src="images/breaker.gif" width="225" height="29"><br>
        <img src="images/spacer.gif" width="80" height="77"><img src="images/register.jpg" width="90" height="77" border="0"></a><br>
        <img src="images/spacer1.gif" width="104" height="75"><a href="party.jsp"><img src="images/party.jpg" width="87" height="75" border="0"></a><br>
        <img src="images/spacer2.gif" width="126" height="76"><a href="contact.jsp"><img src="images/contact.jpg" width="87" height="76" border="0"></a><br>
        <img src="images/spacer3.gif" width="139" height="80"><a href="authors.jsp"><img src="images/authors.jpg" width="86" height="80" border="0"></a></div>
    </td>
    <td width="485" height="2" valign="top"> 
      <div align="left">
       <br><strong>欢迎，${userInfo.user_name}</strong>
       <br><strong>聚会：${partyInfo.party_name}</strong>       
      <br><strong>最佳聚会日期：<%=end%></strong>
       </div>
    </td>
    <td width="19" height="2" valign="top" align="left">
    <font face="Verdana, Arial, Helvetica, sans-serif" size="2"> 
      <style>BODY {
	SCROLLBAR-FACE-COLOR: #C40DC6; SCROLLBAR-HIGHLIGHT-COLOR: #FF6A02; SCROLLBAR-SHADOW-COLOR: #FF6A02; SCROLLBAR-3DLIGHT-COLOR: #41B7F2; SCROLLBAR-ARROW-COLOR: #FF6A02; SCROLLBAR-TRACK-COLOR: #41B7F2; SCROLLBAR-DARKSHADOW-COLOR: #000000
}
</style>
      </font> 
      </td>
  </tr>
</table>
</body>
</html>