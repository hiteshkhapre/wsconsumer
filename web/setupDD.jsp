<%-- 
    Document   : userLogin
    Created on : 30-Nov-2014, 12:58:19
    Author     : hiteshkhapre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
       <!--  <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css" type="text/css" media="all" />
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js" type="text/javascript"></script> 
<script type="text/javascript">
$(function () {
$('#scheduledate').datepicker({ dateFormat: 'yy-mm-dd' });
$('#scheduledate').datepicker();
});
</script>
    <style>
.ui-datepicker th { background-color: #CCCCFF; }
</style>-->
     <style type="text/css">
    .title {
        color: blue;
        text-decoration: bold;
        text-size: 1em;
    }

    .container {
  margin: 50px auto;
  width: 640px;
}
 

body {
  font: 13px/20px "Lucida Grande", Tahoma, Verdana, sans-serif;
  color: #404040;
  background: #ccc;
}

img{
    vertical-align: middle
}

    </style>
    </head>
    <body>
        <img src="images/abclogo.jpg" alt="ABC Bank Logo" style="width:216px;height:68px">
        <h1 align="center">Welcome to ABC Bank</h1>
        <p align="center"><font color = "red">Welcome Mr. <%=session.getAttribute("FirstName")%> logged in as <%=session.getAttribute("UserType")%></font></p>
<p align="center"><font color = "red">Customer ID is <%=session.getAttribute("CustID")%></font></p>
    
    <div id="text9" style="position:absolute; overflow:hidden; left:100px; top:168px; width:300px; height:28px; z-index:18">
<div class="wpmd">
<UL>
    <li><a href="profileServlet"><font face="Tahoma" class="ws8"><B>MY PROFILE</B></font></a></li>
</UL>
    <div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>


    <div id="text10" style="position:absolute; overflow:hidden; left:100px; top:194px; width:300px; height:28px; z-index:19">
<div class="wpmd">
<UL>
<li><a href="AccountServlet"><font face="Tahoma" class="ws8"><B>MY ACCOUNT DETAILS</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text11" style="position:absolute; overflow:hidden; left:100px; top:220px; width:300px; height:28px; z-index:20">
<div class="wpmd">
<UL>
<li><a href="downloadStat.jsp"><font face="Tahoma" class="ws8"><B>DOWNLOAD MY STATEMENT</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text12" style="position:absolute; overflow:hidden; left:100px; top:243px; width:300px; height:28px; z-index:21">
<div class="wpmd">
<UL>
    <li><a href="depositMoney.jsp" ><font face="Tahoma" class="ws8"><B>DEPOSIT MONEY</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text2" style="position:absolute; overflow:hidden; left:100px; top:267px; width:300px; height:28px; z-index:22">
<div class="wpmd">
<UL>
<li><a href="withdrawMoney.jsp" ><font face="Tahoma" class="ws8"><B>WITHDRAW MONEY</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text22" style="position:absolute; overflow:hidden; left:100px; top:292px; width:300px; height:28px; z-index:22">
<div class="wpmd">
<UL>
<li><a href="setupDD.jsp" ><font face="Tahoma" class="ws8"><B>SETUP DIRECT DEBIT</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>


<div id="text5" style="position:absolute; overflow:hidden; left:100px; top:317px; width:300px; height:28px; z-index:23">
<div class="wpmd">
<UL>
    <li><a href="logoutServlet" ><font  face="Tahoma" class="ws8"><B>LOG OUT</B></font></a></li>
</UL>
<div><font face="Tahoma" class="ws8"><BR></font></div>
</div></div>
 
 <div style="position:absolute; overflow:hidden; left:350px; top:180px; width:500px; height:auto; z-index:1">
            <p style="text-align: center;"><b>Setup Direct Debit</b></p>
    
<form method="post" action="ddServlet">
    
<p style="text-align: center;">Account Number : <input maxlength="30" name="accountNumber" size="30" type="text" value="" ></p>

<p style="text-align: center;">Amount to be debited : <input maxlength="50" name="amount" size="30" type ="text" value=""></p>
<p style="text-align: center;">
 Select next schedule Date :
 <input type="date" value="" name="scheduledate"/></p>

<p style="text-align: center;"><input name="submit" type="submit" value="Setup Direct Debit" /></p>
</form>     
 </div>
</html>