<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : Jobseeker-Login.jsp
    Created on : 15-Mar-2014
    Author     : Hitesh Khapre - K1359384@kingston.ac.uk
    Modified by: Leon Munir - K0834666@kingston.ac.uk
    Modified on: 20-Mar-2014
--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Secure Jobs :: Job Seekers</title>
        <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
        <meta name="generator" content="Web Page Maker">
        <style type="text/css">
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

        <script src="scripts/ac_activex.js" type="text/javascript"></script>

        <script language="JavaScript1.4" type="text/javascript">
        <!--
            function jsPlay(soundobj) {
                var thissound = eval("document." + soundobj);
                try {
                    thissound.Play();
                }
                catch (e) {
                    thissound.DoPlay();
                }
            }
        //-->
        </script>

        <script language="javascript" type="text/javascript">
        <!--
            function MM_swapImgRestore() {
                var i, x, a = document.MM_sr;
                for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
                    x.src = x.oSrc;
            }

            function MM_preloadImages() {
                var d = document;
                if (d.images) {
                    if (!d.MM_p)
                        d.MM_p = new Array();
                    var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
                    for (i = 0; i < a.length; i++)
                        if (a[i].indexOf("#") != 0) {
                            d.MM_p[j] = new Image;
                            d.MM_p[j++].src = a[i];
                        }
                }
            }

            function MM_findObj(n, d) {
                var p, i, x;
                if (!d)
                    d = document;
                if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
                    d = parent.frames[n.substring(p + 1)].document;
                    n = n.substring(0, p);
                }
                if (!(x = d[n]) && d.all)
                    x = d.all[n];
                for (i = 0; !x && i < d.forms.length; i++)
                    x = d.forms[i][n];
                for (i = 0; !x && d.layers && i < d.layers.length; i++)
                    x = MM_findObj(n, d.layers[i].document);
                if (!x && d.getElementById)
                    x = d.getElementById(n);
                return x;
            }

            function MM_swapImage() {
                var i, j = 0, x, a = MM_swapImage.arguments;
                document.MM_sr = new Array;
                for (i = 0; i < (a.length - 2); i += 3)
                    if ((x = MM_findObj(a[i])) != null) {
                        document.MM_sr[j++] = x;
                        if (!x.oSrc)
                            x.oSrc = x.src;
                        x.src = a[i + 2];
                    }
            }

        //-->
        </script>

        <style type="text/css">
            div#container
            {
                position:relative;
                width: 807px;
                margin-top: 0px;
                margin-left: auto;
                margin-right: auto;
                text-align:left; 
            }
            body {text-align:center;margin:0}
        </style>

    </head>
    <body>
        <div id="container">
            <div id="image1" style="position:absolute; overflow:hidden; left:19px; top:620px; width:762px; height:64px; z-index:0"><img src="images/bot21.jpg" alt="" title="" border=0 width=762 height=64></div>

            <div id="text2" style="position:absolute; overflow:hidden; left:19px; top:441px; width:223px; height:119px; z-index:1; background-color:#F7F7F7">
                <div class="wpmd">
                    <div><font color="#333333" face="Tahoma" class="ws11"><B>Mystery shopping in UK?</B></font></div>
                    <div><font color="#3366FF" face="Tahoma" class="ws8">www.calsteragency.com/?</font></div>
                    <div><font color="#808080" face="Tahoma" class="ws8">Up to 200 GBP per assignment,? no special education required</font></div>
                    <div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
                </div></div>

            <div id="g_image3" style="position:absolute; overflow:hidden; left:610px; top:0px; width:162px; height:128px; z-index:2"><img src="images/building.jpg" alt="" title="" border=0 width=162 height=128></div>

            <div id="g_image1" style="position:absolute; overflow:hidden; left:21px; top:1px; width:584px; height:8px; z-index:3"><img src="images/busi2_line.jpg" alt="" title="" border=0 width=584 height=8></div>

            <div id="g_text1" style="position:absolute; overflow:hidden; left:78px; top:42px; width:192px; height:30px; z-index:4">
                <div class="wpmd">
                    <div><font color="#3366FF" class="ws20"><B>Secure Job</B></font></div>
                </div></div>

            <div id="image13" style="position:absolute; overflow:hidden; left:770px; top:0px; width:20px; height:620px; z-index:5"><img src="images/ver_line.gif" alt="" title="" border=0 width=20 height=620></div>

            <div id="g_image2" style="position:absolute; overflow:hidden; left:19px; top:32px; width:56px; height:52px; z-index:6"><img src="images/logo2.gif" alt="" title="" border=0 width=56 height=52></div>

            <div id="g_nav10d" style="position:absolute; left:17px; top:87px; z-index:7"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('g_nav10', '', 'images/nav495176620a.gif', 1)" href="index.htm"><img name="g_nav10" onLoad="MM_preloadImages('images/nav495176620a.gif')" alt="" border=0 src="images/nav495176620i.gif"></a></div>
            <div id="g_nav11d" style="position:absolute; left:149px; top:87px; z-index:7"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('g_nav11', '', 'images/nav495176621a.gif', 1)" href="Jobseeker-Login.htm"><img name="g_nav11" onLoad="MM_preloadImages('images/nav495176621a.gif')" alt="" border=0 src="images/nav495176621i.gif"></a></div>
            <div id="g_nav12d" style="position:absolute; left:281px; top:87px; z-index:7"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('g_nav12', '', 'images/nav495176622a.gif', 1)" href="Agent-Login.htm"><img name="g_nav12" onLoad="MM_preloadImages('images/nav495176622a.gif')" alt="" border=0 src="images/nav495176622i.gif"></a></div>
            <div id="g_nav13d" style="position:absolute; left:413px; top:87px; z-index:7"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('g_nav13', '', 'images/nav495176623a.gif', 1)" href="mailto:support@securejobs.org.uk"><img name="g_nav13" onLoad="MM_preloadImages('images/nav495176623a.gif')" alt="" border=0 src="images/nav495176623i.gif"></a></div>

            <div id="text3" style="position:absolute; overflow:hidden; left:275px; top:137px; width:247px; height:28px; z-index:8">
                <div class="wpmd">
                    <div><font color="#FF9900" face="Arial Narrow" class="ws16">SecureJob Login - Jobseeker</font></div>
                    <div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
                </div></div>
                <form:form method="POST" commandName="persons">
                    <form:input path="username" style="position:absolute;width:210px;left:357px;top:208px;z-index:9" />
                    <form:password path="password" style="position:absolute;width:211px;left:356px;top:245px;z-index:10"/>
                <div id="text1" style="position:absolute; overflow:hidden; left:273px; top:211px; width:80px; height:19px; z-index:11">
                    <div class="wpmd">
                        <div><font color="#333333"><B>Username</B></font></div>
                    </div></div>

                <div id="text4" style="position:absolute; overflow:hidden; left:273px; top:245px; width:77px; height:19px; z-index:12">
                    <div class="wpmd">
                        <div><font color="#333333"><B>Password</B></font></div>
                    </div></div>

                <input name="submit" type="submit" value="Submit" style="position:absolute;left:357px;top:288px;z-index:13">
            </form:form>
            <div id="hr1" style="position:absolute; overflow:hidden; left:17px; top:410px; width:764px; height:17px; z-index:14">
                <hr size=2 width=764>
            </div>

            <div id="text5" style="position:absolute; overflow:hidden; left:264px; top:440px; width:223px; height:119px; z-index:15; background-color:#F7F7F7">
                <div class="wpmd">
                    <div><font color="#333333" face="Tahoma" class="ws11"><B>Totaljobs Official Site?</B></font></div>
                    <div><font color="#3366FF" face="Tahoma">www.totaljobs.com/?</font></div>
                    <div><font color="#969696" face="Tahoma" class="ws8">Find New Staff To Fill Vacancies? Or Find Yourself A Great Job Today!</font></div>
                    <div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
                </div></div>

            <div id="text6" style="position:absolute; overflow:hidden; left:517px; top:433px; width:223px; height:119px; z-index:16; background-color:#F7F7F7">
                <div class="wpmd">
                    <div><font color="#333333" face="Tahoma" class="ws11"><B>Part time work in UK?</B></font></div>
                    <div><font color="#3366FF" face="Tahoma" class="ws8">jobs.trovit.com</font></div>
                    <div><font color="#808080" face="Tahoma" class="ws8">Apply now!!</font></div>
                    <div><font color="#808080" face="Tahoma" class="ws8"><BR></font></div>
                </div></div>

            <div id="flash1" style="position:absolute; overflow:hidden; left:18px; top:136px; width:227px; height:255px; z-index:17">
                <script type="text/javascript">
                    AC_RunFlashContent("id", "flash1", "width", "227", "height", "255", "quality", "high", "autoplay", "true", "loop", "true", "wmode", "window", "codebase", "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab", "pluginspage", "http://www.macromedia.com/go/getflashplayer", "src", "images/business04.swf");
                </script>
                <noscript>
                <object classid="clsid:D27CDB6E-AE6D-11CF-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab" width=227 height=255>
                    <param name="movie" value="images/business04.swf">
                    <param name="quality" value="high">
                    <param name="loop" value="true">
                    <param name="wmode" value="window">
                    <param name="autoplay" value="true">
                    <!--[if !IE]>-->
                    <object data="images/business04.swf" width="227" height="255" type="application/x-shockwave-flash">
                        <param name="pluginurl" value="http://www.macromedia.com/go/getflashplayer">
                        <param name="quality" value="high">
                        <param name="loop" value="true">
                        <param name="wmode" value="window">
                        <param name="autoplay" value="true">
                    </object>
                    <!--<![endif]-->
                </object>
                </noscript>
            </div>

            <div id="text7" style="position:absolute; overflow:hidden; left:274px; top:173px; width:208px; height:25px; z-index:18">
                <div class="wpmd">
                    <div><font face="Tahoma">Please enter your details to login</font></div>
                </div></div>
                <form:form method="POST">
                <input type="submit" name="reset" value="Reset" style="position:absolute;left:440px;top:288px;z-index:19">
            </form:form>
            <div id="text8" style="position:absolute; overflow:hidden; left:299px; top:328px; width:96px; height:28px; z-index:20">
                <div class="wpmd">
                    <div><a href="Jobseeker-Registration.htm"><font color="#FF9900" face="Arial Narrow" class="ws12"><B>Register here!</B></font></a></div>
                </div></div>

            <div id="text9" style="position:absolute; overflow:hidden; left:409px; top:327px; width:158px; height:28px; z-index:21">
                <div class="wpmd">
                    <div><a href="Forgot-Password1.htm"><font color="#FF9900" face="Arial Narrow" class="ws12"><B>Forgot your password?</B></font></a></div>
                </div></div>

        </div>

    </body>
</html>
