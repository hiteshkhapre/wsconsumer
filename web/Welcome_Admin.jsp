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
        <p align="center"><font color = "red">Welcome Mr. <%=session.getAttribute("User")%> logged in as <%=session.getAttribute("UserType")%></font></p>

    
    <div id="text9" style="position:absolute; overflow:hidden; left:100px; top:168px; width:300px; height:28px; z-index:18">
<div class="wpmd">
<UL>
    <li><a href="addCustomerForm.jsp"><font face="Tahoma" class="ws8"><B>ADD CUSTOMER</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text10" style="position:absolute; overflow:hidden; left:100px; top:194px; width:300px; height:28px; z-index:19">
<div class="wpmd">
<UL>
<li><a href="Jobseeker-DownloadCV.htm" ><font face="Tahoma" class="ws8"><B>UPDATE CUSTOMER DETAILS</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text11" style="position:absolute; overflow:hidden; left:100px; top:220px; width:300px; height:28px; z-index:20">
<div class="wpmd">
<UL>
    <li><a href="deleteCustomerForm.jsp"><font face="Tahoma" class="ws8"><B>DELETE CUSTOMER</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text12" style="position:absolute; overflow:hidden; left:100px; top:243px; width:300px; height:28px; z-index:21">
<div class="wpmd">
<UL>
    <li><a href="totalCustomerServlet" ><font face="Tahoma" class="ws8"><B>GET TOTAL NUMBER OF CUSTOMERS</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text2" style="position:absolute; overflow:hidden; left:100px; top:267px; width:300px; height:28px; z-index:22">
<div class="wpmd">
<UL>
<li><a href="Jobseeker-Help.htm" ><font face="Tahoma" class="ws8"><B>SETUP DIRECT DEBIT</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text5" style="position:absolute; overflow:hidden; left:100px; top:292px; width:300px; height:28px; z-index:23">
<div class="wpmd">
<UL>
<li><a href="adminLogin.jsp" ><font  face="Tahoma" class="ws8"><B>LOG OUT</B></font></li>
</UL>
<div><font face="Tahoma" class="ws8"><BR></font></div>
</div></div>
    

    
</body>
</html>