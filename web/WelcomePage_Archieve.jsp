<%-- 
    Document   : WelcomePage
    Created on : 30-Nov-2014, 14:29:51
    Author     : hiteshkhapre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to ABC Bank</title>
                <style type="text/css">
    .title {
        color: blue;
        text-decoration: bold;
        text-size: 1em;
    }

div#container
{
	position:relative;
	width: 793px;
	margin-top: 0px;
	margin-left: auto;
	margin-right: auto;
	text-align:left; 
}
body {text-align:center;margin:0}
/*----------Text Styles----------*/
.ws6 {font-size: 8px;}
.ws7 {font-size: 9.3px;}
.ws8 {font-size: 11px;}
.ws9 {font-size: 12px;}
.ws10 {font-size: 13px;}
.ws11 {font-size: 15px;}
.ws12 {font-size: 16px;}
.ws14 {font-size: 19px;}
.ws16 {font-size: 21px;}
.ws18 {font-size: 24px;}
.ws20 {font-size: 27px;}
.ws22 {font-size: 29px;}
.ws24 {font-size: 32px;}
.ws26 {font-size: 35px;}
.ws28 {font-size: 37px;}
.ws36 {font-size: 48px;}
.ws48 {font-size: 64px;}
.ws72 {font-size: 96px;}
.wpmd {font-size: 13px;font-family: Arial,Helvetica,Sans-Serif;font-style: normal;font-weight: normal;}
/*----------Para Styles----------*/
DIV,UL,OL /* Left */
{
 margin-top: 0px;
 margin-bottom: 0px;
}


    </style>
      <script language="javascript" type="text/javascript">
<!--
function MM_swapImgRestore() {
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() {
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) {
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() {
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

//-->
</script>
    </head>
    <body>
                
        
        <div id="container">
<div id="image1" style="position:absolute; overflow:hidden; left:17px; top:620px; width:765px; height:64px; z-index:0"><img src="images/bot21.jpg" alt="" title="" border=0 width=765 height=64></div>

<div id="image14" style="position:absolute; overflow:hidden; left:162px; top:145px; width:20px; height:273px; z-index:1"><img src="images/ver_line.gif" alt="" title="" border=0 width=20 height=273></div>

<div id="text3" style="position:absolute; overflow:hidden; left:264px; top:144px; width:204px; height:28px; z-index:2">
<div class="wpmd">
<div><font color="#FF9900" face="Arial Narrow" class="ws16">Welcome Mr. <%=session.getAttribute("User")%></font></div>
<p><font color="#FF9900" face="Arial Narrow">logged in as <%=session.getAttribute("UserType")%></font></p>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="g_nav10d" style="position:absolute; left:17px; top:87px; z-index:3"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('g_nav10','','images/nav495176620a.gif',1)" href="Homepage.htm"><img name="g_nav10" onLoad="MM_preloadImages('images/nav495176620a.gif')" alt="" border=0 src="images/nav495176620i.gif"></a></div>
<div id="g_nav11d" style="position:absolute; left:149px; top:87px; z-index:3"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('g_nav11','','images/nav495176621a.gif',1)" href="Jobseeker-Login.htm"><img name="g_nav11" onLoad="MM_preloadImages('images/nav495176621a.gif')" alt="" border=0 src="images/nav495176621i.gif"></a></div>
<div id="g_nav12d" style="position:absolute; left:281px; top:87px; z-index:3"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('g_nav12','','images/nav495176622a.gif',1)" href="Agent-Login.htm"><img name="g_nav12" onLoad="MM_preloadImages('images/nav495176622a.gif')" alt="" border=0 src="images/nav495176622i.gif"></a></div>
<div id="g_nav13d" style="position:absolute; left:413px; top:87px; z-index:3"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('g_nav13','','images/nav495176623a.gif',1)" href="mailto:support@securejobs.org.uk"><img name="g_nav13" onLoad="MM_preloadImages('images/nav495176623a.gif')" alt="" border=0 src="images/nav495176623i.gif"></a></div>

<div id="g_text1" style="position:absolute; overflow:hidden; left:78px; top:42px; width:192px; height:30px; z-index:4">
<div class="wpmd">
<div><font color="#3366FF" class="ws20"><B>ABC Bank - logged in as <%=session.getAttribute("UserType")%></B></font></div>
</div></div>

<div id="g_image3" style="position:absolute; overflow:hidden; left:610px; top:0px; width:162px; height:128px; z-index:5"><img src="images/building.jpg" alt="" title="" border=0 width=162 height=128></div>

<div id="g_image2" style="position:absolute; overflow:hidden; left:19px; top:32px; width:56px; height:52px; z-index:6"><img src="images/logo2.gif" alt="" title="" border=0 width=56 height=52></div>

<div id="g_image1" style="position:absolute; overflow:hidden; left:21px; top:1px; width:584px; height:8px; z-index:7"><img src="images/busi2_line.jpg" alt="" title="" border=0 width=584 height=8></div>






<div id="image2" style="position:absolute; overflow:hidden; left:770px; top:0px; width:20px; height:620px; z-index:14"><img src="images/ver_line.gif" alt="" title="" border=0 width=20 height=620></div>

<div id="hr1" style="position:absolute; overflow:hidden; left:17px; top:410px; width:764px; height:17px; z-index:15">
<hr size=2 width=764>
</div>




<div id="text9" style="position:absolute; overflow:hidden; left:3px; top:168px; width:123px; height:28px; z-index:18">
<div class="wpmd">
<UL>
    <li><a href="Jobseeker-MyProfile.htm"><font color="#C0C0C0" face="Tahoma" class="ws8"><B>MY PROFILE</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text10" style="position:absolute; overflow:hidden; left:3px; top:194px; width:165px; height:28px; z-index:19">
<div class="wpmd">
<UL>
<li><a href="Jobseeker-DownloadCV.htm" ><font color="#C0C0C0" face="Tahoma" class="ws8"><B>DOWNLOAD MY CV</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text11" style="position:absolute; overflow:hidden; left:3px; top:220px; width:123px; height:28px; z-index:20">
<div class="wpmd">
<UL>
<li><font color="#C0C0C0" face="Tahoma" class="ws8"><B>SEARCH JOB</B></font></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text12" style="position:absolute; overflow:hidden; left:3px; top:243px; width:150px; height:28px; z-index:21">
<div class="wpmd">
<UL>
    <li><a href="Jobseeker-CareerAdvice.htm" ><font color="#C0C0C0" face="Tahoma" class="ws8"><B>CAREER ADVICE</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text2" style="position:absolute; overflow:hidden; left:3px; top:267px; width:123px; height:28px; z-index:22">
<div class="wpmd">
<UL>
<li><a href="Jobseeker-Help.htm" ><font color="#C0C0C0" face="Tahoma" class="ws8"><B>HELP</B></font></a></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

<div id="text5" style="position:absolute; overflow:hidden; left:3px; top:292px; width:123px; height:28px; z-index:23">
<div class="wpmd">
<UL>
<li><font color="#C0C0C0" face="Tahoma" class="ws8"><B>LOG OUT</B></font></li>
</UL>
<div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
</div></div>

</div>

            
        
  
        
        
    </body>
</html>
