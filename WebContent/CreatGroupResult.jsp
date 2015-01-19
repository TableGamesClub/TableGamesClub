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
<link rel="stylesheet" href="Jquary/demo.css" type="text/css" media="screen" />
<link rel="stylesheet" href="Jquary/flexslider.css" type="text/css" media="screen" />
<title>開團成功內容頁面!</title>
<style type="text/css">
.gray
{
    color:gray;
}
.bodyleftinsidep
{
    padding-top:25px;
    padding-left:25px;
    font-size:18px;
    color:#ffffff;
    font-family:Microsoft JhengHei;
    font-weight:900;
}
#abgneBlock {
    border-top-left-radius:10px 10px;
    border-top-right-radius:10px 10px;
    border-bottom-left-radius:10px 10px;  
    border-bottom-right-radius:10px 10px;
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
#abgneBlock .list img{
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

body
{
    background-image:url(images/scapes2.png);
    
}

input #textone
{
    width:200px;
}
#formone
{
    margin-top:10px;
    margin-left:10px;
    width:400px;
    height:430px;
}
#a1
{
    color:#FFFFFF;
    text-shadow:1px 1px 1px #FFFFFF;
    font-family:Microsoft JhengHei;
	font-weight:bolder;
}
#a2
{
    width:150px;
    color:#0072E3;
    text-shadow:1px 1px 1px #0072E3;
    font-family:Microsoft JhengHei;
    font-weight:bolder;
}
#a3
{
    color:#0072E3;
    text-shadow:1px 1px 1px #0072E3;
    font-family:Microsoft JhengHei;
    font-weight:bolder;
}
#b
{
    color:gray;
    font-family:Microsoft JhengHei;
	font-weight:bolder;
}
#HEADERONE 
{
    border-top-left-radius:10px 10px;
    border-top-right-radius:10px 10px;
    border-bottom-left-radius:10px 10px;  
    border-bottom-right-radius:10px 10px;
	margin:0 auto;
	width:1300px;
	height:75px;
 	background-image:url(res/bo.jpg); 
 	margin-bottom: 10px;
}

#menu 
{
　　　border:2px;
	border-top-left-radius:10px 10px;
    border-top-right-radius:10px 10px;
    border-bottom-left-radius:10px 10px;  
    border-bottom-right-radius:10px 10px;
	margin: 0 auto;
	list-style: none;
	padding:10px;
	width: 1300px;
	height:50px;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#c5deea), color-stop(0%,#8abbd7), color-stop(55%,#066dab));
	box-shadow: 3px 3px 3px rgba(20%,20%,40%,0.4);
}
#menu li 
{
	margin: 0;
	padding: 0;
	float: left;
	border: 2px solid #BAD6F4;
    border-top-left-radius:5px 5px;
    border-top-right-radius:5px 5px;
    border-bottom-left-radius:5px 5px;  
    border-bottom-right-radius:5px 5px;
}

#menu .li 
{
	margin: 0;
	padding: 0;
	float: left;
	border: 2px solid #0072E3;
    border-top-left-radius:5px 5px;
    border-top-right-radius:5px 5px;
    border-bottom-left-radius:5px 5px;  
    border-bottom-right-radius:5px 5px;
}

#menu li a 
{
    font-size: 17px;
	padding: 15px 50px 15px 50px;
	display: block;
	text-decoration: none;
	width: 80px;
	font-family:Microsoft JhengHei;
	font-weight:bolder;
}
#menu li ul {
    border-top-left-radius:10px 10px;
    border-top-right-radius:10px 10px;
    border-bottom-left-radius:10px 10px;  
    border-bottom-right-radius:10px 10px;
	padding: 0px;
	list-style: none;
	position: absolute;
	width: 180px;
	color: #fff;
 	background: #c5deea url('bottom.gif') no-repeat bottom; 
	box-shadow: 3px 3px 3px rgba(20%,20%,40%,0.4);
	text-decoration: none;
	display: none;
}
#menu li ul li { border:2px solid #0072E3;
	                 background-color: #c5deea;width:180px;height:30px;padding-top:10px; }
#menu li ul li a { display: inline; }
#menu li ul li a:hover { text-decoration: none;align:center; }
.font-size
{
	font-family:Microsoft JhengHei;
}
element .style
{
    width:98%;
/*     float:left; */
}

li.MemInfo{
	width:180px;
	height:48px;
	background-color: #DEDEEE;
}


.font_style{
	font-family: DFKai-sb;
	margin:3px;
	margin-left:52px;
	border: 1px solid #7A9ABC;
	padding-left: 9px;
}

.circle{
	border-top-left-radius:5px 5px; 
	border-top-right-radius:5px 5px; 
	border-bottom-left-radius:5px 5px;   
	border-bottom-right-radius:5px 5px; 
}

.A1{
	cursor:default;
}

.resultbody
{
    border-radius:10px;
    margin-top:25px;    
    width:1100px;
    height:550px;
    background:white;
}
</style>

<script type="text/javascript">
$(function(){
	// 幫 #menu li 加上 hover 事件
	$('#menu>li').hover(function(){
		// 先找到 li 中的子選單
		var _this = $(this),
			_subnav = _this.children('ul');
		
		// 變更目前母選項的背景顏色
		// 同時淡入子選單(如果有的話)
		_this.css('backgroundColor', '#c5deea');
		_this.css('text-decoration', 'underline');
		_this.css('border-top-left-radius','5px 5px');
		_this.css('border-bottom-left-radius','5px 5px');
		_this.css('border-top-right-radius','5px 5px');
		_this.css('border-bottom-right-radius','5px 5px');
		_subnav.css('box-shadow', '3px 3px 3px rgba(20%,20%,40%,0.4)')
		_subnav.css('z-index','500')
		_subnav.stop(true, true).fadeIn(400);
	} , function(){
		// 變更目前母選項的背景顏色
		// 同時淡出子選單(如果有的話)
		// 也可以把整句拆成上面的寫法
		$(this).css('backgroundColor', '').children('ul').stop(true, true).fadeOut(400);
		$(this).css('text-decoration', 'none');
	});
	
	// 取消超連結的虛線框
	$('a').focus(function(){
		this.blur();
	});
});

$(function(){//使用者下拉選單
	$('#menu>li>ul>li').hover(function(){
		// 先找到 li 中的子選單
		var _this = $(this),
			_subnav = _this.children('ul');
		
		// 變更目前母選項的背景顏色
		// 同時淡入子選單(如果有的話)
		_this.css('backgroundColor', '#DEDEEE');
		_this.css('text-decoration', 'underline');
		_this.css('border-top-left-radius','5px 5px');
		_this.css('border-bottom-left-radius','5px 5px');
		_this.css('border-top-right-radius','5px 5px');
		_this.css('border-bottom-right-radius','5px 5px');
		_subnav.css('box-shadow', '3px 3px 3px rgba(20%,20%,40%,0.4)')
		_subnav.css('z-index','500')
		_subnav.stop(true, true).fadeIn(400);
	} , function(){
		// 變更目前母選項的背景顏色
		// 同時淡出子選單(如果有的話)
		// 也可以把整句拆成上面的寫法
		$(this).css('backgroundColor', '').children('ul').stop(true, true).fadeOut(400);
		$(this).css('text-decoration', 'none');
		
	});
})

$(function(){//會員圖片
	$('#menu>li:nth-child(7)').hover(function(){
		// 先找到 li 中的子選單
		var _this = $(this),
			_subnav = _this.children('ul');
		
		// 變更目前母選項的背景顏色
		// 同時淡入子選單(如果有的話)
		_this.css('backgroundColor', '#DEDEEE');
		_this.css('text-decoration', 'none');
		_this.css('border-top-left-radius','5px 5px');
		_this.css('border-bottom-left-radius','5px 5px');
		_this.css('border-top-right-radius','5px 5px');
		_this.css('border-bottom-right-radius','5px 5px');
		_subnav.css('box-shadow', '3px 3px 3px rgba(20%,20%,40%,0.4)')
		_subnav.css('z-index','500')
		_subnav.stop(true, true).fadeIn(400);
	} , function(){
		// 變更目前母選項的背景顏色
		// 同時淡出子選單(如果有的話)
		// 也可以把整句拆成上面的寫法
		$(this).css('backgroundColor', '').children('ul').stop(true, true).fadeOut(400);
	});
})

$(function(){//使用者特效
	// 幫 #menu li 加上 hover 事件
	$('#menu>li:nth-child(6)').hover(function(){
		// 先找到 li 中的子選單
		var _this = $(this),
			_subnav = _this.children('ul');
		
		// 變更目前母選項的背景顏色
		// 同時淡入子選單(如果有的話)
		_this.css('backgroundColor', '#c5deea');
		_this.css('text-decoration', 'none');
		_this.css('border-top-left-radius','5px 5px');
		_this.css('border-bottom-left-radius','5px 5px');
		_this.css('border-top-right-radius','5px 5px');
		_this.css('border-bottom-right-radius','5px 5px');
		_subnav.css('box-shadow', '3px 3px 3px rgba(20%,20%,40%,0.4)')
		_subnav.css('z-index','500')
		_subnav.stop(true, true).fadeIn(400);
	} , function(){
		// 變更目前母選項的背景顏色
		// 同時淡出子選單(如果有的話)
		// 也可以把整句拆成上面的寫法
		$(this).css('backgroundColor', '').children('ul').stop(true, true).fadeOut(400);
		$(this).css('text-decoration', 'none');
	});
	
	// 取消超連結的虛線框
	$('a').focus(function(){
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
      <a href="#" id="a1">找團</a>
    </li>
    <li>
      <a href="#" id="a1">店家資訊</a>
    </li>
    <li>
      <a href="register.jsp" id="a1">註冊</a>
    </li>
    <li class="User">
    	<c:if test="${empty username}">
			<a href="<c:url value='/login.jsp'/> " id="a1"> 登入 </a>
		</c:if>
		<c:if test="${ ! empty username }">
			<a id="a1" class="A1" href="#"><font>使用者<img src="res/arror_down.png" height="16px" style="position: relative; top:2px; left:52px"></font></a>
			<ul>
        		<li>
          			<a href="#" id="a2">會員資料</a>
          			
        		</li><br /><br />
        		<li>
          			<a href="loginout.jsp" id="a2">登出</a>
        		</li>
      		</ul>
      	
	</li>
	<li class="MemInfo">
		<img src="${pageContext.servletContext.contextPath}/controller/GetMemberImage?username=${username}" height="45px" width="45px" style="float:left;border:2px double rgb(65, 113, 200);" class="circle">
			<p class="font_style circle">${username}</p>
			<p class="font_style circle">${nickname}</p>
	</li>
	</c:if>
  </ul>
</div>
<div style="margin:0 auto;width:1300px;">
  <center><div class="resultbody"><p>開團確認畫面</p></div></center>
</div>
</body>
</html>