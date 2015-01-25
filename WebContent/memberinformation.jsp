<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="Scripts/jquery-ui.css">
<script src="Scripts/jquery-ui.js"></script>
<!-- <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<script	src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="Jquary/demo.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="Jquary/flexslider.css" type="text/css"
	media="screen" />
<title>會員基本資料</title>
<style type="text/css">
.gray {
	color: gray;
}

.bodyleftinsidep {
	padding-top: 25px;
	padding-left: 25px;
	font-size: 18px;
	color: #ffffff;
	font-family: Microsoft JhengHei;
	font-weight: 900;
}

#abgneBlock {
	border-top-left-radius: 10px 10px;
	border-top-right-radius: 10px 10px;
	border-bottom-left-radius: 10px 10px;
	border-bottom-right-radius: 10px 10px;
	width: 809px;
	height: 480px;
	position: relative;
	overflow: hidden;
	border: 1px solid #ccc;
}

#abgneBlock ul.list {
	padding: 0;
	margin: 0;
	list-style: none;
	position: absolute;
	width: 9999px;
	height: 100%;
}

#abgneBlock ul.list li {
	float: left;
	height: 100%;
}

#abgneBlock .list img {
	width: 90%;
	height: 98%;
	border: 0;
}

#abgneBlock ul.playerControl {
	margin: 0;
	padding: 0;
	list-style: none;
	position: absolute;
	bottom: 5px;
	right: 5px;
	height: 14px;
}

#abgneBlock ul.playerControl li {
	float: left;
	width: 10px;
	height: 10px;
	cursor: pointer;
	margin: 0px 2px;
	background: url(images/cir_ctrl.png) no-repeat -10px 0;
}

#abgneBlock ul.playerControl li.current {
	background-position: 0 0;
}

body {
	background-image: url(images/scapes2.png);
}

input #textone {
	width: 200px;
}

#a1 {
	color: #FFFFFF;
	text-shadow: 1px 1px 1px #FFFFFF;
	font-family: Microsoft JhengHei;
	font-weight: bolder;
}

#a2 {
	width: 150px;
	color: #0072E3;
	text-shadow: 1px 1px 1px #0072E3;
	font-family: Microsoft JhengHei;
	font-weight: bolder;
}

#a3 {
	color: #0072E3;
	text-shadow: 1px 1px 1px #0072E3;
	font-family: Microsoft JhengHei;
	font-weight: bolder;
}

#b {
	color: gray;
	font-family: Microsoft JhengHei;
	font-weight: bolder;
}

#HEADERONE {
	border-top-left-radius: 10px 10px;
	border-top-right-radius: 10px 10px;
	border-bottom-left-radius: 10px 10px;
	border-bottom-right-radius: 10px 10px;
	margin: 0 auto;
	width: 1300px;
	height: 75px;
	background-image: url(res/bo.jpg);
	margin-bottom: 10px;
}

#menu {
	　　　border: 2px;
	border-top-left-radius: 10px 10px;
	border-top-right-radius: 10px 10px;
	border-bottom-left-radius: 10px 10px;
	border-bottom-right-radius: 10px 10px;
	margin: 0 auto;
	list-style: none;
	padding: 10px;
	width: 1300px;
	height: 50px;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #c5deea),
		color-stop(0%, #8abbd7), color-stop(55%, #066dab));
	box-shadow: 3px 3px 3px rgba(20%, 20%, 40%, 0.4);
}

#menu li {
	margin: 0;
	padding: 0;
	float: left;
	border: 2px solid #BAD6F4;
	border-top-left-radius: 5px 5px;
	border-top-right-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
	border-bottom-right-radius: 5px 5px;
}

#menu .li {
	margin: 0;
	padding: 0;
	float: left;
	border: 2px solid #0072E3;
	border-top-left-radius: 5px 5px;
	border-top-right-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
	border-bottom-right-radius: 5px 5px;
}

#menu li a {
	font-size: 17px;
	padding: 15px 50px 15px 50px;
	display: block;
	text-decoration: none;
	width: 80px;
	font-family: Microsoft JhengHei;
	font-weight: bolder;
}

#menu li ul {
	border-top-left-radius: 10px 10px;
	border-top-right-radius: 10px 10px;
	border-bottom-left-radius: 10px 10px;
	border-bottom-right-radius: 10px 10px;
	padding: 0px;
	list-style: none;
	position: absolute;
	width: 180px;
	color: #fff;
	background: #c5deea url('bottom.gif') no-repeat bottom;
	box-shadow: 3px 3px 3px rgba(20%, 20%, 40%, 0.4);
	text-decoration: none;
	display: none;
}

#menu li ul li {
	border: 2px solid #0072E3;
	background-color: #c5deea;
	width: 180px;
	height: 30px;
	padding-top: 10px;
}

#menu li ul li a {
	display: inline;
}

#menu li ul li a:hover {
	text-decoration: none;
	align: center;
}

.font-size {
	font-family: Microsoft JhengHei;
}

element .style {
	width: 98%;
	/*     float:left; */
}

li.MemInfo {
	width: 180px;
	height: 48px;
	background-color: #DEDEEE;
}

.font_style {
	font-family: DFKai-sb;
	margin: 3px;
	margin-left: 52px;
	border: 1px solid #7A9ABC;
	padding-left: 9px;
}

.circle {
	border-top-left-radius: 5px 5px;
	border-top-right-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
	border-bottom-right-radius: 5px 5px;
}

.A1 {
	cursor: default;
}

.headbodyimage {
	margin-top: 25px;
	width: 1200px;
	height: 250px;
	margin-left: 50px;
	background: #C4E1FF;
	background-image:url(images/memberintroimg.jpg);
	border-radius:10px 10px 10px 10px;
	box-shadow: 3px 3px 3px rgba(20%, 20%, 40%, 0.4);
	opacity:0.9;
}

.imageiconin {
	margin-left: 15px;
	margin-top: 25px;
	width: 180px;
	height: 150px;
	border-radius:10px 10px 10px 10px;
}

.nickname {
	margin-left: 15px;
	margin-top: 25px;
	width: 180px;
	height: 30px;
}

.text {
	width: 360px;
	height: 30px;
	font-size: 20px;
}

.textone {
    font-size:28px;
	margin-top: -190px;
	margin-left: 220px;
	color:#1F4EDD;
	font-weight:900;
	font-family: Microsoft JhengHei;
}

.texttwo {

	margin-top: 25px;
	margin-left: 220px;
	color:white;
	font-weight:600;
	font-family: Microsoft JhengHei;
}

.textthree {
	margin-top: 15px;
	margin-left: 220px;
	color:white;
	font-weight:600;
	font-family: Microsoft JhengHei;
}

.textfour {
	float: right;
	margin-top: -75px;
	margin-right: 180px;
	color:white;
	font-weight:600;
	font-family: Microsoft JhengHei;
}

.textfive {
	float: right;
	margin-right: 180px;
	margin-top: -32px;
	color:white;
	font-weight:600;
	font-family: Microsoft JhengHei;
}

.middlebodyone {
	margin-top: -30px;
	width: 1200px;
	height: 300px;
	background: white;
	margin-left: 50px;
	border-radius:10px 10px 10px 10px;
	margin-bottom: 50px;
	box-shadow: 3px 3px 3px rgba(20%, 20%, 40%, 0.4);
}

.middlebodytwo {
	margin-top: 30px;
	width: 900px;
    height: 140px;
	background: rgba(240,249,255,0.3);
	margin-left: 50px;
	border-radius:10px 10px 10px 10px;
}

.middlebodyheadone {
	margin-top: 15px;
	width: 330px;
	height: 70px;
	background: #E0FFFF;
	margin-left: 50px;
	position: relative;
	border-radius:10px 10px 10px 10px;
	box-shadow: 3px 3px 3px rgba(20%, 20%, 40%, 0.4);
}

.middlebodyoneline {
    border-top-left-radius:10px 10px;
    border-top-right-radius:10px 10px;
	margin-top: -10px;
	width: 1186px;
	border: 7px solid #E0FFFF;
}

.middlebodyinsideone {
	width: 285px;
	height: 230px;
	border: 5px solid #1E5799;
	margin-top: 15px;
	margin-left: 35px;
}

.middlebodyinsidetwo {
	width: 1120px;
	height: 230px;
	border: 5px solid #2828FF;
	margin-top: 35px;
	margin-left: 35px;
}

.middlebodyinsidethree {
	width: 1120px;
	height: 180px;
	border: 5px solid #2828FF;
	margin-top: 35px;
	margin-left: 35px;
}

.middlebodyinside {
	width: 1120px;
	height: 230px;
	border: 5px solid #2828FF;
	margin-top: 15px;
	margin-left: 35px;
}

.intromain
{ 
    padding:20px;
    width: 800px;
    height: 200px;
    background: -webkit-gradient(linear, left top, left bottom, 
                color-stop(0%,rgba(30,87,153,1)), color-stop(100%,rgba(32,124,202,1)), 
                color-stop(100%,rgba(125,185,232,1)));
    margin-left: 330px;
    margin-top: -240px;
    border-top-right-radius:10px 10px;
    border-bottom-right-radius:10px 10px;
}

.groupimage {
	margin-top: -195px;
	width: 220px;
	height: 150px;
	margin-left: 75px;
}
.lookforgroup
{
    width:200px;
    height:65px;
    margin-top: 50px; 
    background:#074B99;
    color:#ffffff;
    border-radius:10px 10px 10px 10px;
    }
.creategroup{
    width:200px;
    height:65px;
    float: right;
    margin-top: 50px;
    margin-right: 200px;
    background:#1f3b08;
    color:#ffffff;
    border-radius:10px 10px 10px 10px;
    }
</style>

<script type="text/javascript">
	$(function() {
		// 幫 #menu li 加上 hover 事件
		$('#menu>li').hover(
				function() {
					// 先找到 li 中的子選單
					var _this = $(this), _subnav = _this.children('ul');

					// 變更目前母選項的背景顏色
					// 同時淡入子選單(如果有的話)
					_this.css('backgroundColor', '#c5deea');
					_this.css('text-decoration', 'underline');
					_this.css('border-top-left-radius', '5px 5px');
					_this.css('border-bottom-left-radius', '5px 5px');
					_this.css('border-top-right-radius', '5px 5px');
					_this.css('border-bottom-right-radius', '5px 5px');
					_subnav.css('box-shadow',
							'3px 3px 3px rgba(20%,20%,40%,0.4)')
					_subnav.css('z-index', '500')
					_subnav.stop(true, true).fadeIn(400);
				},
				function() {
					// 變更目前母選項的背景顏色
					// 同時淡出子選單(如果有的話)
					// 也可以把整句拆成上面的寫法
					$(this).css('backgroundColor', '').children('ul').stop(
							true, true).fadeOut(400);
					$(this).css('text-decoration', 'none');
				});

		// 取消超連結的虛線框
		$('a').focus(function() {
			this.blur();
		});
	});

	$(function() {//使用者下拉選單
		$('#menu>li>ul>li').hover(
				function() {
					// 先找到 li 中的子選單
					var _this = $(this), _subnav = _this.children('ul');

					// 變更目前母選項的背景顏色
					// 同時淡入子選單(如果有的話)
					_this.css('backgroundColor', '#DEDEEE');
					_this.css('text-decoration', 'underline');
					_this.css('border-top-left-radius', '5px 5px');
					_this.css('border-bottom-left-radius', '5px 5px');
					_this.css('border-top-right-radius', '5px 5px');
					_this.css('border-bottom-right-radius', '5px 5px');
					_subnav.css('box-shadow',
							'3px 3px 3px rgba(20%,20%,40%,0.4)')
					_subnav.css('z-index', '500')
					_subnav.stop(true, true).fadeIn(400);
				},
				function() {
					// 變更目前母選項的背景顏色
					// 同時淡出子選單(如果有的話)
					// 也可以把整句拆成上面的寫法
					$(this).css('backgroundColor', '').children('ul').stop(
							true, true).fadeOut(400);
					$(this).css('text-decoration', 'none');

				});
	})

	$(function() {//會員圖片
		$('#menu>li:nth-child(7)').hover(
				function() {
					// 先找到 li 中的子選單
					var _this = $(this), _subnav = _this.children('ul');

					// 變更目前母選項的背景顏色
					// 同時淡入子選單(如果有的話)
					_this.css('backgroundColor', '#DEDEEE');
					_this.css('text-decoration', 'none');
					_this.css('border-top-left-radius', '5px 5px');
					_this.css('border-bottom-left-radius', '5px 5px');
					_this.css('border-top-right-radius', '5px 5px');
					_this.css('border-bottom-right-radius', '5px 5px');
					_subnav.css('box-shadow',
							'3px 3px 3px rgba(20%,20%,40%,0.4)')
					_subnav.css('z-index', '500')
					_subnav.stop(true, true).fadeIn(400);
				},
				function() {
					// 變更目前母選項的背景顏色
					// 同時淡出子選單(如果有的話)
					// 也可以把整句拆成上面的寫法
					$(this).css('backgroundColor', '').children('ul').stop(
							true, true).fadeOut(400);
				});
	})

	$(function() {//使用者特效
		// 幫 #menu li 加上 hover 事件
		$('#menu>li:nth-child(6)').hover(
				function() {
					// 先找到 li 中的子選單
					var _this = $(this), _subnav = _this.children('ul');

					// 變更目前母選項的背景顏色
					// 同時淡入子選單(如果有的話)
					_this.css('backgroundColor', '#c5deea');
					_this.css('text-decoration', 'none');
					_this.css('border-top-left-radius', '5px 5px');
					_this.css('border-bottom-left-radius', '5px 5px');
					_this.css('border-top-right-radius', '5px 5px');
					_this.css('border-bottom-right-radius', '5px 5px');
					_subnav.css('box-shadow',
							'3px 3px 3px rgba(20%,20%,40%,0.4)')
					_subnav.css('z-index', '500')
					_subnav.stop(true, true).fadeIn(400);
				},
				function() {
					// 變更目前母選項的背景顏色
					// 同時淡出子選單(如果有的話)
					// 也可以把整句拆成上面的寫法
					$(this).css('backgroundColor', '').children('ul').stop(
							true, true).fadeOut(400);
					$(this).css('text-decoration', 'none');
				});

		// 取消超連結的虛線框
		$('a').focus(function() {
			this.blur();
		});
	});
</script>
</head>
<body>
	<div id="HEADERONE"></div>
	<div>
  <ul id="menu">
    <li>
      <a href="home.jsp" id="a1">首頁</a>
    </li>
    <li>
      <a href="CreateGroup.jsp"
       id="a1">開團</a>
    </li>
    <li>
      <a href="<c:url value='/SelectLookForGroupServlet'/>" id="a1">找團</a>
    </li>
    <li>
      <a href="#" id="a1">店家資訊</a>
    </li>
    	<c:if test="${empty Member}">
    <li>
      		<a href="register.jsp" id="a1">註冊</a>
    </li>
      	</c:if>
    <li class="User">
    	<c:if test="${empty Member}">
			<a href="<c:url value='/login.jsp'/> " id="a1"> 登入 </a>
		</c:if>
		<c:if test="${ ! empty Member }">
			<a id="a1" class="A1" href="#"><font>使用者<img src="res/arror_down.png" height="16px" style="position: relative; top:2px; left:52px"></font></a>
			<ul>
        		<li>
          			<a href="<c:url value='/MemberInfoServlet'/> " id="a2">會員資料</a>
          			
        		</li><br /><br />
        		<li>
          			<a href="loginout.jsp" id="a2">登出</a>
        		</li>
      		</ul>
      	
	</li>
	<li class="MemInfo">
		<img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${Member.username}&type=MEMBER" height="45px" width="45px" style="float:left;border:2px double rgb(65, 113, 200);" class="circle">
			<p class="font_style circle">${Member.username}</p>
			<p class="font_style circle">${Member.nickname}</p>
	</li>
	</c:if>
  </ul>
</div>

	<div style="margin: 0 auto; width: 1300px;">
		<div class="headbodyimage">
			<div>
				<img
					src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${Member.username}&type=member"
					class="imageiconin">
			</div>
			<div class="nickname">
				<center>
					<p style="font-size: 18px;font-weight:900;">暱稱 : ${Member.nickname}</p>
				</center>
			</div>
			<div class="text textone">
				<center>會員帳號:${Member.username}</center>
			</div>
			<div class="text texttwo">
				<center>電子信箱:${Member.email}</center>
			</div>
			<div class="text textthree">
				<center>性別:${Member.gender}</center>
			</div>
			<div class="text textfour">
				<center>生日:${Member.birthday}</center>
			</div>
			<div class="text textfive">
				<center>入會日期:${Member.joinDate}</center>
			</div>
		</div>
		<div class="middlebodyheadone">
			<center>
				<p style="font-size: 20px; color: #1f3b08; padding-top: 25px; font-weight:900;font-family: Microsoft JhengHei;">現有加入團</p>
			</center>
		</div>

        <c:set var="temp1" value="0" />
			<c:forEach var="GroupRooms" items="${memgroupall}">
		<div class="middlebodyone">
			<div class="middlebodyoneline"></div>
			<div class="middlebodyinsideone"></div>
			<div>
				<img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${GroupRooms.groupSerialNumber}&type=GroupRoom" class="groupimage">
			</div>
			<div class="intromain">
			
				<div>
					<div class="groupname">
						<center>
							<p style="font-size: 20px; padding-top: 15px; color:#e9e9ce; font-weight:900;font-family: Microsoft JhengHei;">團名稱:${GroupRooms.groupRoomName}</p>
						</center>
					</div>
					<div class="groupgametype">
						<center>
							<p style="font-size: 20px; padding-top: 15px; color:#e9e9ce; font-weight:900;font-family: Microsoft JhengHei;">
								遊戲類型:
								<c:if test="${temp1==0}">${typeList.kind00}</c:if>
								<c:if test="${temp1==0}">${typeList.kind01}</c:if>
								<c:if test="${temp1==0}">${typeList.kind02}</c:if>
								<c:if test="${temp1==0}">${typeList.kind03}</c:if>
								<c:if test="${temp1==0}">${typeList.kind04}</c:if>
								<c:if test="${temp1==0}">${typeList.kind05}</c:if>
								<c:if test="${temp1==0}">${typeList.kind06}</c:if>
								<c:if test="${temp1==0}">${typeList.kind07}</c:if>
								<c:if test="${temp1==0}">${typeList.kind08}</c:if>
								<c:if test="${temp1==0}">${typeList.kind09}</c:if>
								<c:if test="${temp1==0}">${typeList.kind10}</c:if>
								<c:if test="${temp1==1}">${typeList.kind000}</c:if>
								<c:if test="${temp1==1}">${typeList.kind001}</c:if>
								<c:if test="${temp1==1}">${typeList.kind002}</c:if>
								<c:if test="${temp1==1}">${typeList.kind003}</c:if>
								<c:if test="${temp1==1}">${typeList.kind004}</c:if>
								<c:if test="${temp1==1}">${typeList.kind005}</c:if>
								<c:if test="${temp1==1}">${typeList.kind006}</c:if>
								<c:if test="${temp1==1}">${typeList.kind007}</c:if>
								<c:if test="${temp1==1}">${typeList.kind008}</c:if>
								<c:if test="${temp1==1}">${typeList.kind009}</c:if>
								<c:if test="${temp1==1}">${typeList.kind010}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0000}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0001}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0002}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0003}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0004}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0005}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0006}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0007}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0008}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0009}</c:if>
								<c:if test="${temp1==2}">${typeList.kind0010}</c:if>
							</p>
						</center>
					</div>
					<div class="groupgamename">
						<center>
							<p style="font-size: 20px; padding-top: 15px; color:#e9e9ce; font-weight:900;font-family: Microsoft JhengHei;">
								遊戲名稱:
								<c:if test="${temp1==0}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices0}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==1}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices1}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==2}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices2}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==3}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices3}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==4}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices4}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==5}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices5}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==6}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices6}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==7}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices7}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==8}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices8}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==9}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices9}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
								<c:if test="${temp1==10}">
									<c:forEach var="GroupChoiceGames"
										items="${choiceGames.choices10}">${GroupChoiceGames.boardGameName}<span>,</span>
									</c:forEach>
								</c:if>
							</p>
						</center>
					</div>
				</div>

				<div class="groupgamedate">
					<center>
						<p style="font-size: 20px; padding-top: 15px; color:#e9e9ce; font-weight:900;font-family: Microsoft JhengHei;">開團時間:${GroupRooms.groupStartTime}</p>
					</center>
				</div>
				<div class="groupgamenumber">
					<center>
						<p style="font-size: 20px; padding-top: 15px; color:#e9e9ce; font-weight:900;font-family: Microsoft JhengHei;">
							加團人數:
							<c:if test="${temp1==0}">${map_count.count0}</c:if>
							<c:if test="${temp1==1}">${map_count.count1}</c:if>
							<c:if test="${temp1==2}">${map_count.count2}</c:if>
							<c:if test="${temp1==3}">${map_count.count3}</c:if>
							<c:if test="${temp1==4}">${map_count.count4}</c:if>
							<c:if test="${temp1==5}">${map_count.count5}</c:if>
							<c:if test="${temp1==6}">${map_count.count6}</c:if>
							<c:if test="${temp1==7}">${map_count.count7}</c:if>
							<c:if test="${temp1==8}">${map_count.count8}</c:if>
							<c:if test="${temp1==9}">${map_count.count9}</c:if>
							<c:if test="${temp1==10}">${map_count.count10}</c:if>
						</p>
					</center>
				</div>

<!-- 			  <div> -->
<!-- 				<input type="button" value="查看" class="buttoncheck"> -->
<!-- 			  </div> -->
				<c:set var="Id" scope="session" value="${Member.memberId}"/>
				<c:if test="${Id==GroupRooms.member.memberId}">
				<span style="float:right">
					<button id="selectRoom00">刪除團</button>
				</span>
				</c:if>
				<span style="float:right">
					<button id="selectRoom00">查看團</button>
				</span>
				<c:if test="${Id!=GroupRooms.member.memberId}">
				<span style="float:right">
					<button id="opener" name="quitroom00" value=${GroupRooms.groupSerialNumber}>我要退團</button>
				</span>
				</c:if>
			</div>
			</div>
			<c:set var="temp1" value="${temp1+1}" />
			</c:forEach>
			<!--     <div class="middlebodyinsidetwo"></div> -->
			<!--     <div><img src="images/0007.jpg" class="groupimage"></div> -->
			<!--     <div class="groupname"> -->
			<%--       <center><p style="font-size:20px;padding-top:15px">團名稱</p></center> --%>
			<!--     </div> -->
			<!--     <div class="groupgametype"> -->
			<%--       <center><p style="font-size:20px;padding-top:15px">遊戲類型</p></center> --%>
			<!--     </div> -->
			<!--     <div class="groupgamename"> -->
			<%--       <center><p style="font-size:20px;padding-top:15px">遊戲名稱</p></center> --%>
			<!--     </div> -->
			<!--     <div class="groupgamedate"> -->
			<%--       <center><p style="font-size:20px;padding-top:15px">開團時間</p></center> --%>
			<!--     </div> -->
			<!--     <div class="groupgamenumber"> -->
			<%--       <center><p style="font-size:20px;padding-top:15px">加團人數</p></center> --%>
			<!--     </div> -->
			<!--     <div> -->
			<!--        <input type="button" value="查看" class="buttoncheck"> -->
			<!--     </div> -->
	
		<center><div class="middlebodytwo">
			<a href="<c:url value='/SelectLookForGroupServlet' />"><input type="button" value="找團" class="lookforgroup"
				style="font-size: 36px; color: #feffff;font-family: Microsoft JhengHei;"></a> <input
				type="button" value="開團" class="creategroup"
				style="font-size: 36px; color: #fefcea;font-family: Microsoft JhengHei;">
		</div></center>
	</div>
	<div id="dialog" title="退團理由" style="width: 400px">
		<h3 style="margin:3px 10px 10px -1px;color:black">請填寫退團的原因：</h3>
		<form action="<c:url value="/QuitRoomServlet"/>" method="post" id="quitform">
			<textarea rows="5" cols="44" name="quitReason" id="quitReason"></textarea>
			<input type="submit" value="送出" style="float:right;margin-top: 14px" id="submit">
			<input type="button" value="取消" style="float:right;margin-top: 14px;margin-right: 3px" id="cancel">
			<input type="text" value="" style="display:none" id="roomId00" name="roomId00">
		</form>
<!-- 		<button id="testButton">test</button> -->
<!-- 		<button id="testButton2">test2</button> -->
	</div>
	
  <script>
  var anotherVariable = jQuery.noConflict();
//   打開退團理由框框
  $(function() {
    $( "#dialog" ).dialog({
      autoOpen: false,
      show: {
        effect: "blind",
        duration: 500
      },
      hide: {
        effect: "blind",
        duration: 500
      },
      width: 450,
      height: 280,
    });
 
    $('button[name="quitroom00"]').click(function() {//使用name抓取(id抓取會有語法錯誤問題)
      $( "#dialog" ).dialog( "open" );
//       alert($(this).val());
	  $('#roomId00').val($(this).val());
      
    });
    $( "#cancel" ).click(function() {
        $( "#dialog" ).dialog( "close" );
      });
  });
  </script>
  <script>
  var anotherVariable2 = jQuery.noConflict();
//   按鈕特效框框
  $(function() {
	  $("#cancel,#selectRoom00,#opener" )
      .button()
      .click(function( event ) {
        event.preventDefault();
      });
  });
  
  $(function() {
	  $("#submit")
	  .button()
	  .click(function(){
// 		  $('#quitform').submit();
	  })
  });
  

  </script>	
  
  <script type="text/javascript">//房間號碼測試
  	 $('#testButton').click(function(){
     alert($('#roomId00').val());
  	 })
  </script>
</body>
</html>
