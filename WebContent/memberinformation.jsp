<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
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
}

.imageiconin {
	margin-left: 15px;
	margin-top: 25px;
	width: 180px;
	height: 150px;
}

.nickname {
	margin-left: 15px;
	margin-top: 25px;
	width: 180px;
	height: 30px;
	border: 2px solid #000000;
}

.text {
	width: 360px;
	height: 30px;
	border: 1px solid #000000;
	font-size: 20px;
}

.textone {
	margin-top: -160px;
	margin-left: 220px;
}

.texttwo {
	margin-top: 20px;
	margin-left: 220px;
}

.textthree {
	margin-top: 20px;
	margin-left: 220px;
}

.textfour {
	float: right;
	margin-top: -84px;
	margin-right: 180px;
}

.textfive {
	float: right;
	margin-right: 180px;
	margin-top: -32px;
}

.middlebodyone {
	margin-top: -30px;
	width: 1200px;
	height: 550px;
	background: white;
	margin-left: 50px;
}

.middlebodytwo {
	margin-top: 30px;
	width: 1200px;
	height: 200px;
	background: white;
	margin-left: 50px;
}

.middlebodyheadone {
	margin-top: 15px;
	width: 330px;
	height: 70px;
	background: #E0FFFF;
	margin-left: 50px;
	position: relative;
}

.middlebodyoneline {
	margin-top: -10px;
	width: 1186px;
	border: 7px solid #2828FF;
}

.middlebodyinsideone {
	width: 1120px;
	height: 230px;
	border: 5px solid #2828FF;
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

.groupimage {
	margin-top: -195px;
	width: 220px;
	height: 150px;
	margin-left: 75px;
}
/* .groupname{margin-top: -220px;margin-left: 315px;width:300px;height:60px;border:1px solid #2828FF;} */
/* .groupgametype{margin-top: 10px;margin-left: 315px;width:300px;height:60px;border:1px solid #2828FF;} */
/* .groupgamename{margin-top: 10px;margin-left: 315px;width:300px;height:60px;border:1px solid #2828FF;} */
/* .groupgamedate{width:300px;height:60px;border:1px solid #2828FF;float: right;margin-right: 235px;margin-top: -170px;} */
/* .groupgamenumber{width:300px;height:60px;border:1px solid #2828FF;float: right;margin-top: -95px;margin-right: 235px;} */
/* .buttoncheck{width:150px;height:50px;margin-top: -55px;float: right;margin-right: 60px;} */
/* .lookforgroup{width:360px;height:120px;margin-top: 32px;margin-left: 60px;} */
/* .creategroup{width:360px;height:120px;float:right;margin-top: 32px;margin-right: 60px;} */
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
			<li><a href="home.jsp" id="a1">首頁</a></li>
			<li><a href="CreateGroup.jsp" id="a1">開團</a></li>
			<li><a href="#" id="a1">找團</a></li>
			<li><a href="#" id="a1">店家資訊</a></li>
			<li><a href="register.jsp" id="a1">註冊</a></li>
			<li class="User"><c:if test="${empty Member}">
					<a href="<c:url value='/login.jsp'/> " id="a1"> 登入 </a>
				</c:if> <c:if test="${ ! empty Member }">
					<a id="a1" class="A1" href="#"><font>使用者<img
							src="res/arror_down.png" height="16px"
							style="position: relative; top: 2px; left: 52px"></font></a>
					<ul>
						<li><a href="#" id="a2">會員資料</a></li>
						<br />
						<br />
						<li><a href="loginout.jsp" id="a2">登出</a></li>
					</ul></li>
			<li class="MemInfo"><img
				src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${Member.username}&type=Member"
				height="45px" width="45px"
				style="float: left; border: 2px double rgb(65, 113, 200);"
				class="circle">
				<p class="font_style circle">${Member.username}</p>
				<p class="font_style circle">${Member.nickname}</p></li>
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
					<p style="font-size: 18px">暱稱:${Member.nickname}</p>
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
				<p style="font-size: 20px; color: #A20055; padding-top: 25px">現有加入團</p>
			</center>
		</div>


		<div class="middlebodyone">
			<div class="middlebodyoneline"></div>
			<div class="middlebodyinsideone"></div>
			<div>
				<img src="images/0007.jpg" class="groupimage">
			</div>
			<c:set var="temp1" value="0" />
			<c:forEach var="GroupRooms" items="${memgroupall}">
				<div>
					<div class="groupname">
						<center>
							<p style="font-size: 20px; padding-top: 15px">團名稱:${GroupRooms.groupRoomName}</p>
						</center>
					</div>
					<div class="groupgametype">
						<center>
							<p style="font-size: 20px; padding-top: 15px">
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
							<p style="font-size: 20px; padding-top: 15px">
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
						<p style="font-size: 20px; padding-top: 15px">開團時間:${GroupRooms.groupStartTime}</p>
					</center>
				</div>
				<div class="groupgamenumber">
					<center>
						<p style="font-size: 20px; padding-top: 15px">
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
				<c:set var="temp1" value="${temp1+1}" />
			</c:forEach>
			<div>
				<input type="button" value="查看" class="buttoncheck">
			</div>

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
		</div>
		<div class="middlebodytwo">
			<div class="middlebodyoneline"></div>
			<input type="button" value="找團" class="lookforgroup"
				style="font-size: 36px; color: #2828FF;"> <input
				type="button" value="開團" class="creategroup"
				style="font-size: 36px; color: #2828FF;">
		</div>
	</div>
</body>
</html>