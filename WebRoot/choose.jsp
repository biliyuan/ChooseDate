<%@ page contentType="text/html; charset=gbk" %>
<%@ page language="java" import="java.util.*,xidian.qlj.model.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UserBean ub=(UserBean)request.getAttribute("userInfo");
PartyBean up=(PartyBean)request.getAttribute("partyInfo");
%>
<html>
<head>
<title>Reusable web templates.</title>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<meta NAME="keywords" CONTENT=" ChooseDate.">
<meta NAME="description" CONTENT="ChooseDate.">
<meta NAME="rating" CONTENT="General">
<meta NAME="ROBOTS" CONTENT="ALL">
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
        <script language=JavaScript 
      src="vnu_datestamp.js"></script>
        <br><strong>欢迎，${userInfo.user_name}</strong>
       <br><strong>聚会：${partyInfo.party_name}</strong>                   
        <br><strong> 欢迎选择日期！</strong> 
        <br>
        <form action="choosedate" method="post" onsubmit="return datesubmit();">
        <input type="hidden" id="chooseyear" name="chooseyear" value="">
        <input type="hidden" id="choosemonth" name="choosemonth"value="">
        <input type="hidden" id="chooseday" name="chooseday" value="">
        <input type="submit" value="确定日期"> 
        </form>     
        </div>
    <td width="19" height="2" valign="top" align="left"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"> 
      <style>BODY {
	SCROLLBAR-FACE-COLOR: #C40DC6; SCROLLBAR-HIGHLIGHT-COLOR: #FF6A02; SCROLLBAR-SHADOW-COLOR: #FF6A02; SCROLLBAR-3DLIGHT-COLOR: #41B7F2; SCROLLBAR-ARROW-COLOR: #FF6A02; SCROLLBAR-TRACK-COLOR: #41B7F2; SCROLLBAR-DARKSHADOW-COLOR: #000000
}
</style>
<Style>
.right
{
position:absolute;
left:700px;
top:120px;
}

.Calendar {font-family: verdana;text-decoration: none;width: 425;background-color: #C0D0E8;font-size: 22.5pt;border:0px dotted #1C6FA5;}
.CalendarTD {font-family: verdana;font-size: 17.5pt;color: #000000;background-color:#f6f6f6;height: 50px;width:11%;text-align: center;}

.Title {font-family: verdana;font-size: 27.5pt;font-weight: normal;height: 60px;text-align: center;color: #333333;text-decoration: none;background-color: #A4B9D7;border-top-width: 2.5px;border-right-width: 2.5px;border-bottom-width: 2.5px;border-left-width: 2.5px;border-bottom-style:2.5px;border-top-color: #999999;border-right-color: #999999;border-bottom-color: #999999;border-left-color: #999999;}

.Day {font-family: verdana;font-size: 17.5pt;color:#243F65;background-color: #E5E9F2;height: 50px;width:11%;text-align: center;}
.DaySat {font-family: verdana;font-size: 17.5pt;color:#FF0000;text-decoration: none;background-color:#E5E9F2;text-align: center;height: 45px;width: 12%;}
.DaySun {font-family: verdana;font-size: 17.5pt;color: #FF0000;text-decoration: none;background-color:#E5E9F2;text-align: center;height: 45px;width: 12%;}
.DayNow {font-family: verdana;font-size: 17.5pt;font-weight: bold;color: #000000;background-color: #FFFFFF;height: 50px;text-align: center;}

.DayTitle {font-family: verdana;font-size: 22.5pt;color: #000000;background-color: #C0D0E8;height: 50px;width:11%;text-align: center;}
.DaySatTitle {font-family: verdana;font-size: 22.5pt;color:#FF0000;text-decoration: none;background-color:#C0D0E8;text-align: center;height: 50px;width: 12%;}
.DaySunTitle {font-family: verdana;font-size: 22.5pt;color: #FF0000;text-decoration: none;background-color: #C0D0E8;text-align: center;height: 50px;width: 12%;}

.DayButton {font-family: Webdings;font-size: 22.5pt;font-weight: bold;color: #243F65;cursor:hand;text-decoration: none;}

</Style>

      </font> </td>
  </tr>
</table>
<Script LANGUAGE="JavaScript">
 var months = new Array("一", "二", "三","四", "五", "六", "七", "八", "九","十", "十一", "十二");
 var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31,30, 31, 30, 31);
 var days = new Array("日","一", "二", "三","四", "五", "六");
 var classTemp;
 var today=new getToday();
 var year=today.year;
 var month=today.month;
 var newCal; 
 var selectday=null;

 function getDays(month, year) {
  if (1 == month) return ((0 == year % 4) && (0 != (year % 100))) ||(0 == year % 400) ? 29 : 28;
  else return daysInMonth[month];
 }

 function getToday() {
  this.now = new Date();
  this.year = this.now.getFullYear();
  this.month = this.now.getMonth();
  this.day = this.now.getDate();
 }

 function Calendar() {
  newCal = new Date(year,month,1);
  today = new getToday();   
  var day = -1;
  var startDay = newCal.getDay();
  var endDay=getDays(newCal.getMonth(), newCal.getFullYear());
  var daily = 0;
  if ((today.year == newCal.getFullYear()) &&(today.month == newCal.getMonth()))
  {
   day = today.day;
  }
  var caltable = document.all.caltable.tBodies.calendar;
  var intDaysInMonth =getDays(newCal.getMonth(), newCal.getFullYear());

  for (var intWeek = 0; intWeek < caltable.rows.length;intWeek++)
   for (var intDay = 0;intDay < caltable.rows[intWeek].cells.length;intDay++)
   {
    var cell = caltable.rows[intWeek].cells[intDay];
    var montemp=(newCal.getMonth()+1)<10?("0"+(newCal.getMonth()+1)):(newCal.getMonth()+1);         
    if ((intDay == startDay) && (0 == daily)){ daily = 1;}
    var daytemp=daily<10?("0"+daily):(daily);
    var d="<"+newCal.getFullYear()+"-"+montemp+"-"+daytemp+">";
    if(day==daily) cell.className="DayNow";
    else if(intDay==6) cell.className = "DaySat";
    else if (intDay==0) cell.className ="DaySun";
    else cell.className="Day";
    if ((daily > 0) && (daily <= intDaysInMonth))
    {
     cell.innerText = daily;
     daily++;
    } else
    {
     cell.className="CalendarTD";
     cell.innerText = "";
    }
  }
  document.all.year.value=year;
  document.all.month.value=month+1;
 }

 function subMonth()
 {
  if ((month-1)<0)
  {
   month=11;
   year=year-1;
  } else
  {
   month=month-1;
  }
  Calendar();
 }

 function addMonth()
 {
  if((month+1)>11)
  {
   month=0;
   year=year+1;
  } else
  {
   month=month+1;
  }
  Calendar();
 }

 function setDate() 
 {
  if (document.all.month.value<1||document.all.month.value>12)
  {
   alert("月的有效范围在1-12之间!");
   return;
  }
  year=Math.ceil(document.all.year.value);
  month=Math.ceil(document.all.month.value-1);
  Calendar();
 }
 function datesubmit()
{
   if(selectday==null)
   {
      return false;
   }
 else{
   document.getElementById("chooseyear").value=year;
   month=month+1;
   document.getElementById("choosemonth").value=month;
   document.getElementById("chooseday").value=selectday.innerText;
   return true; 
    }
}
</Script>

<Script>
function buttonOver()
{
 var obj = window.event.srcElement;
 if(obj!=selectday)
 { 
     obj.runtimeStyle.cssText = "background-color:#FFFFFF";
 }

// obj.className="Hover";
}

function buttonOut()
{
 var obj = window.event.srcElement;
 if(obj!=selectday)
 window.setTimeout(function(){obj.runtimeStyle.cssText = "";},300);
}
function buttonclick()
{
    var obj = window.event.srcElement;
    if(selectday!=null)
    {
    selectday.runtimeStyle.cssText="";
    }
    selectday=obj;
 obj.runtimeStyle.cssText = "background-color:#87CEFA";

}

</Script>



<div class="right">
<table border="0" cellpadding="0" cellspacing="1" class="Calendar" id="caltable">
<thead>
     <tr align="center" valign="middle"> 
  <td colspan="7" class="Title">
   <a href="javaScript:subMonth();" title="上一月" Class="DayButton">3</a> <input {font-family: verdana;font-size: 22.5pt;text-decoration: none;background-color: #FFFFFF;height: 50px;border: 2.5px solid #666666;color:#000000}; name="year" type="text" size="4" maxlength="4" onKeyDown="if (event.keyCode==13)" onKeyUp="this.value=this.value.replace(/[^0-9]/g,'')"  onpaste="this.value=this.value.replace(/[^0-9]/g,'')"> 年 <input {font-family: verdana;font-size: 22.5pt;text-decoration: none;background-color: #FFFFFF;height: 50px;border: 2.5px solid #666666;color:#000000}; name="month" type="text" size="1" maxlength="2" onKeyDown="if (event.keyCode==13)" onKeyUp="this.value=this.value.replace(/[^0-9]/g,'')"  onpaste="this.value=this.value.replace(/[^0-9]/g,'')"> 月 <a href="JavaScript:addMonth();" title="下一月" Class="DayButton">4</a>
  </td>
 </tr>
 <tr align="center" valign="middle"> 
  <Script LANGUAGE="JavaScript">  
   document.write("<TD class=DaySunTitle id=diary >" + days[0] + "</TD>"); 
   for (var intLoop = 1; intLoop < days.length-1;intLoop++) 
    document.write("<TD class=DayTitle id=diary>" + days[intLoop] + "</TD>"); 
    document.write("<TD class=DaySatTitle id=diary>" + days[intLoop] + "</TD>"); 
  </Script>
 </TR> 
</thead>
<TBODY border=1 cellspacing="0" cellpadding="0" ID="calendar" ALIGN=CENTER ONCLICK="getDiary()">
 <Script LANGUAGE="JavaScript">
  for (var intWeeks = 0; intWeeks < 6; intWeeks++)
  {
   document.write("<TR style='cursor:hand'>");
   for (var intDays = 0; intDays < days.length;intDays++) document.write("<TD class=CalendarTD onMouseover='buttonOver();' onMouseOut='buttonOut();' onclick='buttonclick();'></TD>");
   document.write("</TR>");
  } 
 </Script>
</TBODY>
</TABLE>
</div>
<Script  LANGUAGE="JavaScript">
 Calendar();
</Script>
</body>
</html>