<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<<<<<<< HEAD
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="Jquary/demo.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="Jquary/flexslider.css" type="text/css"
	media="screen" />
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<title>查看專賣店現有團資訊</title>
<style type="text/css">
#feedback {
	font-size: 1.4em;
}

#selectable .ui-selecting {
	border: 0;
	background: #4EFEB3;
	height: 35px;
	border-radius: 5px;
	padding-top: 5px;
	box-shadow: 3px 3px 3px rgba(117, 34, 1, 0.4);
}

#selectable .ui-selected {
	border: 0;
	background: #02DF82;
	color: white;
	height: 35px;
	border-radius: 5px;
	padding-top: 5px;
	box-shadow: 3px 3px 3px rgba(117, 34, 1, 0.4);
}
/* #selectable { border: 0;list-style-type: none;margin: 35px;padding: 0;width: 75%;border-radius:5px;padding-top: 5px; } */
#selectable li {
	border: 0;
	margin: 3px;
	padding: 0.4em;
	font-size: 1.4em;
	height: 35px;
	border-radius: 5px;
	padding-top: 5px;
	box-shadow: 3px 3px 3px rgba(117, 34, 1, 0.4);
}

.font-size1 {
	font-size: 24px;
}

body {
	background-image: url(images/scapes2.png);
}

#HEADERONE {
	border-radius: 10px 10px;
	margin: 0 auto;
	width: 1300px;
	height: 75px;
	background-image: url(res/bo.jpg);
	margin-bottom: 10px;
}

.smbody {
	margin-top: 20px;
	width: 1300px;
	height: 1000px;
	background-color: #660000;
	border-radius: 10px 10px 10px 10px;
}

.smbodyleft {
	border-top-left-radius: 10px 10px 10px 10px;
	border-bottom-left-radius: 10px 10px 10px 10px;
	height: 975px;
	float: left;
	width: 341px;
	border-top: 3px double #008a00;
	border-left: 3px double #008a00;
	border-bottom: 3px double #008a00;
	margin-top: -1000px;
	padding: 10px;
}

.smbodyleftinside {
	border-radius: 10px 10px;
	width: 300px;
	height: 970px;
	border: 3px double #008a00;
	background: #A6FFA6;
	margin-left: 15px;
}

.smbodyleftinsidetop {
	width: 230px;
	height: 250px;
	border: 3px Solid #FFFFDF;
	margin-top: 5px;
	margin-left: 7px;
	padding-top: 15px;
	padding-left: 50px;
	background-color: #002E02;
}

.smbodyleftinsidebottom {
	margin-top: 35px;
	margin-left: 21px;
	height: 620px;
	width: 250px;
}

.smbodyright {
	height: 995px;
	width: 930px;
	border-top: 3px double #008a00;
	border-right: 3px double #008a00;
	border-bottom: 3px double #008a00;
	margin-top: -1000px;
	margin-left: 364px;
	border-top-right-radius: 10px 10px 10px 10px;
	border-bottom-right-radius: 10px 10px 10px 10px;
}

.smbodyrighttop {
	border-radius: 10px 10px 10px 10px;
	width: 910px;
	height: 968px;
	border: 3px Solid #E8B09D;
	margin-left: 7px;
	margin-top: 10px;
	background-image: url(images/woodhead.jpg);
	background-size: cover;
	box-shadow: 3px 3px 3px rgba(117, 34, 1, 0.4);
}

.smbodyrightmiddleline {
	margin-top: 5px;
	width: 920px;
	border: 7px Solid gray;
}

.smbodyrightbottom {
	width: 910px;
	height: 650px;
	border: 3px Solid #000000;
	margin-left: 7px;
	margin-top: 10px;
}

.aditheadimage {
	border-radius: 10px 10px 10px 10px;
	width: 180px;
	height: 150px;
	border: 1px solid #752201;
	margin-top: 30px;
	margin-left: 15px;
}

.adtnickaccount {
	padding-top: 20px;
	width: 300px;
	height: 50px;
	border: 3px outset #f0b7a1;
	margin-left: 15px;
	margin-top: 55px;
}

.adtinfo {
	width: 360px;
	height: 100px;
}

.headimage {
	width: 180px;
	height: 150px;
}

.memberstatus {
	width: 280px;
	height: 70px;
	border: 1px Solid #FFFFDF;
	margin-left: 9px;
	margin-top: -75px;
}

.smbodyleftinsidetext {
	width: 250px;
	height: 40px;
	background: white;
	margin-top: 40px;
	padding-top: 25px;
	font-size: 24px;
	color: #006e2e;
	border-radius: 10px 10px 10px 10px;
	box-shadow: 3px 3px 3px rgba(117, 34, 1, 0.4);
	font-weight: bolder;
}

.selectoption {
	font-size: 20px;
	color: #006e2e;
	font-family: Microsoft JhengHei;
}
</style>

<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="HEADERONE"></div>
	<div style="margin: 0 auto; width: 1300px;">
		<div class="smbody"></div>
		<div class="smbodyleft">
			<div class="smbodyleftinside">
				<div class="smbodyleftinsidetop">
					<img
						src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${storemem.storeMemberId}&type=storeMember"
						class="headimage"><br>
				</div>
				<div class="memberstatus">
					<center>
						<p style="font-size: 20px; line-height: 22px; color: #FFFFDF;">帳號:${storemem.storeUsername}</p>
					</center>
					<center>
						<p style="font-size: 20px; line-height: 22px; color: #FFFFDF;">登入時間:${JoinDate}</p>
					</center>
				</div>
				<div class="smbodyleftinsidebottom" id="selectable">
					<div class="smbodyleftinsidetext">
						<center>
							<a href="StoreMemberInformation.jsp" class="selectoption">個人資訊</a>
						</center>
					</div>
					<div class="smbodyleftinsidetext">
						<center>
							<a href="<c:url value='/StoreMemberInfoServlet'/>" class="selectoption">專賣店資訊</a>
						</center>
					</div>
					<div class="smbodyleftinsidetext">
						<center>
							<a href="ucGroupInformation.jsp" class="selectoption">查看所有團</a>
						</center>
					</div>
					<div class="smbodyleftinsidetext">
						<center>
							<a href="StoreMemberLoginout.jsp" class="selectoption">登出</a>
						</center>
					</div>
				</div>
			</div>
		</div>
		<div class="smbodyright">
			<div class="smbodyrighttop">
				<p style="font-size: 24px">查看專賣店現有團資訊</p>
				12311212

			</div>
		</div>
	</div>
=======
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="Jquary/demo.css" type="text/css" media="screen" />
<link rel="stylesheet" href="Jquary/flexslider.css" type="text/css" media="screen" />
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<title>查看專賣店現有團資訊</title>
<style type="text/css">

#feedback { font-size: 1.4em; }
#selectable .ui-selecting { border: 0;background: #4EFEB3;height:35px;border-radius:5px;padding-top: 5px; box-shadow: 3px 3px 3px rgba(117,34,1,0.4);}
#selectable .ui-selected { border: 0;background: #02DF82; color: white;height:35px;border-radius:5px;padding-top: 5px;box-shadow: 3px 3px 3px rgba(117,34,1,0.4);}
/* #selectable { border: 0;list-style-type: none;margin: 35px;padding: 0;width: 75%;border-radius:5px;padding-top: 5px; } */
#selectable li { border: 0;margin: 3px; padding: 0.4em; font-size: 1.4em; height: 35px;border-radius:5px;padding-top: 5px;box-shadow: 3px 3px 3px rgba(117,34,1,0.4); }

.font-size1
{
    font-size:24px;
}
body
{
    background-image:url(images/scapes2.png);
    
}
#HEADERONE 
{
    border-radius:10px 10px;
	margin:0 auto;
	width:1300px;
	height:75px;
 	background-image:url(res/bo.jpg); 
 	margin-bottom: 10px;
}

.smbody
{
    margin-top:20px;
    width:1300px;
    height:1000px;
    background-color:#660000;
    border-radius:10px 10px 10px 10px;
}
.smbodyleft
{
    border-top-left-radius:10px 10px 10px 10px;
    border-bottom-left-radius:10px 10px 10px 10px;
    height: 975px;
    float:left;
    width:341px;
    border-top:3px double #008a00;
    border-left:3px double #008a00;
    border-bottom:3px double #008a00;
    margin-top: -1000px;
    padding:10px;
}
.smbodyleftinside
{
    border-radius:10px 10px;
    width:300px;
    height:970px;
    border:3px double #008a00;
    background:#A6FFA6;
    margin-left: 15px;
}
.smbodyleftinsidetop
{
    width:230px;
    height:250px;
    border:3px Solid #FFFFDF;
    margin-top: 5px;
    margin-left: 7px;
    padding-top: 15px;
    padding-left: 50px;
    background-color:#002E02;
}
.smbodyleftinsidebottom
{
    margin-top: 35px;
    margin-left: 21px;
    height: 620px;
    width: 250px;
}
.smbodyright
{
    height:995px;
    width:930px;
    border-top:3px double #008a00;
    border-right:3px double #008a00;
    border-bottom:3px double #008a00;
    margin-top: -1000px;
    margin-left:364px;
    border-top-right-radius:10px 10px 10px 10px;
    border-bottom-right-radius:10px 10px 10px 10px;
}

.smbodyrighttop
{
    border-radius:10px 10px 10px 10px;
    width:910px;
    height:968px;
    border: 3px Solid #E8B09D;
    margin-left: 7px;
    margin-top: 10px;
    background-image:url(images/woodhead.jpg);
    background-size:cover;
    box-shadow: 3px 3px 3px rgba(117,34,1,0.4);
    
}
.smbodyrightmiddleline
{
    margin-top:5px;
    width:920px;
    border:7px Solid gray;
}
.smbodyrightbottom
{
    width:910px;
    height:650px;
    border:3px Solid #000000;
    margin-left: 7px;
    margin-top: 10px;
    
}
.aditheadimage
{   
    border-radius:10px 10px 10px 10px;
    width:180px;
    height:150px;
    border:1px solid #752201;
    margin-top: 30px;
    margin-left: 15px;
}
.adtnickaccount
{
    padding-top:20px;
    width:300px;
    height:50px;
    border:3px outset #f0b7a1;
    margin-left: 15px;
    margin-top: 55px;
}
.adtinfo
{
    width:360px;
    height:100px;
}
.headimage
{
    width:180px;
    height:150px;
}
.memberstatus
{
    width: 280px;
    height: 70px;
    border: 1px Solid #FFFFDF;
    margin-left: 9px;
    margin-top: -75px;
}
.smbodyleftinsidetext
{ 
    width:250px;
    height:40px;
    background:white;
    margin-top:40px;
    padding-top:25px;
    font-size:24px;
    color:#006e2e;
    border-radius:10px 10px 10px 10px;
    box-shadow: 3px 3px 3px rgba(117,34,1,0.4);
    font-weight:bolder;
}
.selectoption
{font-size:20px;color:#006e2e;font-family:Microsoft JhengHei;}

</style>

<script type="text/javascript">

</script>
</head>
<body>
<div id="HEADERONE"></div>
<div style="margin:0 auto;width:1300px;　">
  <div class="smbody">
  </div>
  <div class="smbodyleft">
    <div class="smbodyleftinside">
      <div class="smbodyleftinsidetop">
      <img src="images/Asuka_Langley_Soryu.jpg" class="headimage"><br>     
      </div>
      <div class="memberstatus">
            <center><p style="font-size:20px;line-height:22px;color:#FFFFDF;">帳號</p></center>
            <center><p style="font-size:20px;line-height:22px;color:#FFFFDF;">登入時間</p></center> 
      </div>
      <div class="smbodyleftinsidebottom" id="selectable">
         <div class="smbodyleftinsidetext"><center><a href="#" class="selectoption">個人資訊</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="#" class="selectoption">專賣店資訊</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="http://yahoo.com.tw" class="selectoption">查看所有團</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="#" class="selectoption">登出</a></center></div>
      </div>
    </div>
  </div>
  <div class="smbodyright">
    <div class="smbodyrighttop">
       <p style="font-size:24px">查看專賣店現有團資訊</p>
    </div>
  </div>
</div>
>>>>>>> refs/heads/tablis0814
</body>
</html>
