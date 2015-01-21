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
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="Jquary/demo.css" type="text/css" media="screen" />
<link rel="stylesheet" href="Jquary/flexslider.css" type="text/css" media="screen" />
<title>找團</title>
<style type="text/css">

.bodyleftinsidetwo
{  
    margin-top:-25px;
    margin-left:25px;
    width:450px;
    height:500px;
    background:-webkit-gradient(linear, left top, 
                                left bottom, color-stop(0%,#c5deea), 
                                color-stop(0%,#8abbd7), color-stop(70%,#066dab));
    border-radius:10px 10px 10px 10px;
    box-shadow:2px 2px 2px rgba(20%,20%,40%,0.6),
               4px 4px 6px rgba(20%,20%,40%,0.4),
               6px 6px 12px rgba(20%,20%,40%,0.4);
}
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
.searchbar
{
    box-shadow: 3px 3px 3px rgba(20%,20%,40%,0.4);
	border-top-left-radius:5px 5px; 
	border-top-right-radius:5px 5px; 
	border-bottom-left-radius:5px 5px;   
	border-bottom-right-radius:5px 5px; 
    margin-top:25px;
    width:1300px;
    height:235px;
    background:white;
    padding-top:15px;
}
.searchin
{
    padding-top: 15px;
    padding-left: 30px;
    width:1250px;
    height:190px;
    border:2px solid #000000;
    margin-left: 8px;
}
.searchdiscribtionone{font-size:20px;color:blue;font-family:Microsoft JhengHei;}
.searchdiscribtiontwo{font-size:20px;color:blue;font-family:Microsoft JhengHei;margin-top: -150px;float: right;margin-right: 300px;}
.searchone{margin-top:5px;margin-right:8px;height:30px;width:120px;}
.searchtwo{margin-top:5px;margin-left: 140px;;height:30px;width:120px;}
.searchthree{margin-top:5px;margin-left: 280px;;height:30px;width:120px;}
.searchfour{margin-top:5px;margin-left: 280px;;height:30px;width:120px;}
.searchfive{margin-top:5px;margin-left: 280px;;height:30px;width:120px;}
.discribone{}
.discribtwo{margin-top: -53px;margin-left: 140px;}
.discribthree{margin-top: -53px;margin-left: 280px;}
.discribfour{margin-top: -53px;margin-left: 280px;}
.discribfive{margin-top: -53px;margin-left: 248px;}
.searchchoose{width:1220px;height:130px;border:1px solid #f0f9ff;}
.textone{height:30px;margin-top: -110px;float: right;margin-right: 265px;}
.finishsubmit{height:40px;width:120px;margin-top: -10px;background:#14A1FF;color:white;}
.searcherrorshow{margin-top:25px;width:1250px;height:150px;background:white;border-top-left-radius:5px 5px;border-top-right-radius:5px 5px;border-bottom-left-radius:5px 5px;border-bottom-right-radius:5px 5px; }
.errormsgbox{width:1150px;height:100px;margin-top: -100px;padding-top:15px;}
.errormsg{font-size:48px;color:red;font-family:Microsoft JhengHei;}
.showresult
{
    padding-top:15px;
    margin-top:25px;
    width:1300px;
    min-height:400px;
/*     height:400px; */
    background:white;
    border-top-left-radius:10px 10px;
    border-top-right-radius:10px 10px;
    border-bottom-left-radius:10px 10px;
    border-bottom-right-radius:10px 10px;
}
.showcolorbar
{
    margin-left: 23px;
    width:1250px;
    min-height:380px;
/*     height:380px; */
    border:2px solid green;
}

#textthree
{
    width:150px;
    height:25px;
    margin-top: 80px;
}

#textfour
{
    width:150px;
    height:25px;
    margin-left: 248px;
    margin-top: 4px;
}

.infosearch{
 	width:33%;
  	float:left;  
/* 	display:inline-block;  */
}
#clearDiv{
/* 	width:100%; */
/* 	height:1px; */
	clear:both;
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

$(function() {
    $( "#textthree" ).datepicker(); //時間選擇
    $( "#textfour" ).datepicker();
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
      <a href="<c:url value='/SelectLookForGroupServlet' />" id="a1">找團</a>
    </li>
    <li>
      <a href="#" id="a1">店家資訊</a>
    </li>
    <li>
      <a href="register.jsp" id="a1">註冊</a>
    </li>
    <li class="User">
    	<c:if test="${empty Member}">
			<a href="<c:url value='/login.jsp'/> " id="a1"> 登入 </a>
		</c:if>
		<c:if test="${ ! empty Member }">
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
		<img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${Member.username}&type=MEMBER" height="45px" width="45px" style="float:left;border:2px double rgb(65, 113, 200);" class="circle">
			<p class="font_style circle">${Member.username}</p>
			<p class="font_style circle">${Member.nickname}</p>
	</li>
	</c:if>
  </ul>
</div>
<form action="<c:url value='LookForGroupServlet.do' />" method="POST">
<div style="margin:0 auto;width:1300px;">
  <div class="searchbar">
    <div class="searchin">
      <p class="searchdiscribtionone">條件搜尋：</p>
        <div class="searchchoose">
          <p class="discribone">遊戲類型：</p>
            <select class="searchone" name="gametype">
              <option>策略遊戲</option>
              <option>益智遊戲</option>
              <option>推理遊戲</option>
              <option>角色扮演遊戲</option>
              <option>小品遊戲</option>
            </select>
      
          <p class="discribtwo">開團時間：</p>
            <select class="searchtwo" name="gametime">
              <option>最近→最遠</option>
              <option>最遠→最近</option>
            </select>
      
           <p class="discribthree">遊戲人數：</p>
            <select class="searchthree" name="gamenumber">
              <option>10人以下</option>
              <option>10至20人</option>
              <option>20人以上</option>
            </select>
        </div>
        <div>
      <p class="searchdiscribtiontwo" >遊戲名稱搜尋：</p>
      <input type="text" class="textone" placeholder="遊戲名稱" name="gamenamesearch">
        </div>
        <center>
          <input type="submit" value="送出" class="finishsubmit">
        </center>
    </div>
  </div>
  <!-- 錯誤顯示頁面 -->
<%--   <center><div class="searcherrorshow"></div> --%>
<!--     <div class="errormsgbox"><p class="errormsg">找不到任何團符合條檢查詢 請重新輸入!</p></div> -->
<%--   </center> --%>
  <div class="showresult">
    <div class="showcolorbar">

    <c:if test="${ ! empty requestgroupname.simplegroupgroupname0 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage0}&type=GROUPROOM" style="width:'180px';height:120px" />
    <br>
    ${requestgroupname.simplegroupgroupname0}<br>
    ${numberofpeople.peoplenumber0}<br>
    ${requestype.type00}
    ${requestype.type10}
    ${requestype.type20}
    ${requestype.type30}
    ${requestype.type40}<br>
    ${requesttype.time0}<br>
    </div>
    </c:if>
    <br/>
    
    <c:if test="${ ! empty requestgroupname.simplegroupgroupname1 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage1}&type=GROUPROOM" style="width:'180px';height:120px"/>
    <br>
    ${requestgroupname.simplegroupgroupname1}<br>
    ${numberofpeople.peoplenumber1}<br>
    ${requestype.type01}
    ${requestype.type11}
    ${requestype.type21}
    ${requestype.type31}
    ${requestype.type41}<br>
    ${requesttype.time1}<br>
    </div>
        </c:if>
    
    <br/>
    
    <c:if test="${ ! empty requestgroupname.simplegroupgroupname2 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage2}&type=GROUPROOM" style="width:'180px';height:120px"/>
    <br>
    ${requestgroupname.simplegroupgroupname2}<br>
    ${numberofpeople.peoplenumber2}<br>
    ${requestype.type02}
    ${requestype.type12}
    ${requestype.type22}
    ${requestype.type32}
    ${requestype.type42}<br>
    ${requesttype.time2}<br>
    </div>
    </c:if>
    <br/>
    
    <c:if test="${ ! empty requestgroupname.simplegroupgroupname3 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage3}&type=GROUPROOM" style="width:'180px';height:120px"/>
    <br>
    ${requestgroupname.simplegroupgroupname3}<br>
    ${numberofpeople.peoplenumber3}<br>
    ${requestype.type03}
    ${requestype.type13}
    ${requestype.type23}
    ${requestype.type33}
    ${requestype.type43}<br>
    ${requesttype.time3}<br>
    </div>
    </c:if>
    <br/>
    
    <c:if test="${ ! empty requestgroupname.simplegroupgroupname4 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage4}&type=GROUPROOM" style="width:'180px';height:120px"/>
    <br>
    ${requestgroupname.simplegroupgroupname4}<br>
    ${numberofpeople.peoplenumber4}<br>
    ${requestype.type04}
    ${requestype.type14}
    ${requestype.type24}
    ${requestype.type34}
    ${requestype.type44}<br>
    ${requesttype.time4}<br>
    </div>
    </c:if>
    <br/>
    <c:if test="${ ! empty requestgroupname.simplegroupgroupname5 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage5}&type=GROUPROOM" style="width:'180px';height:120px"/>
    <br>
    ${requestgroupname.simplegroupgroupname5}<br>
    ${numberofpeople.peoplenumber5}<br>
    ${requestype.type05}
    ${requestype.type15}
    ${requestype.type25}
    ${requestype.type35}
    ${requestype.type45}<br>
    ${requesttype.time5}<br>
    </div>
    </c:if>
    <br/>
    
    <c:if test="${ ! empty requestgroupname.simplegroupgroupname6 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage6}&type=GROUPROOM" style="width:'180px';height:120px"/>
    <br>
    ${requestgroupname.simplegroupgroupname6}<br>
    ${numberofpeople.peoplenumber6}<br>
    ${requestype.type06}
    ${requestype.type16}
    ${requestype.type26}
    ${requestype.type36}
    ${requestype.type46}<br>
    ${requesttype.time6}<br>
    </div>
    </c:if>
   	<br/>
   
    <c:if test="${ ! empty requestgroupname.simplegroupgroupname7 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage7}&type=GROUPROOM" style="width:'180px';height:120px"/>
    <br>
   	${requestgroupname.simplegroupgroupname7}<br>
   	${numberofpeople.peoplenumber7}<br>
    ${requestype.type07}
    ${requestype.type17}
    ${requestype.type27}
    ${requestype.type37}
    ${requestype.type47}<br>
    ${requesttype.time7}<br>
    </div>
    </c:if>
    <br/>
    
    <c:if test="${ ! empty requestgroupname.simplegroupgroupname8 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage8}&type=GROUPROOM" style="width:'180px';height:120px"/>
    <br>
    ${requestgroupname.simplegroupgroupname8}<br>
    ${numberofpeople.peoplenumber8}<br>
    ${requestype.type08}
    ${requestype.type18}
    ${requestype.type28}
    ${requestype.type38}
    ${requestype.type48}<br>
    ${requesttype.time8}<br>
    </div>
    </c:if>
    <br/>
    
    <c:if test="${ ! empty requestgroupname.simplegroupgroupname9 }">
    <div class="infosearch">
    <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage9}&type=GROUPROOM" style="width:'180px';height:120px"/>
    <br>
    ${requestgroupname.simplegroupgroupname9}<br>
    ${numberofpeople.peoplenumber9}<br>
    ${requestype.type09}
    ${requestype.type19}
    ${requestype.type29}
    ${requestype.type39}
    ${requestype.type49}<br>
    ${requesttype.time9}<br>
    </div>
    </c:if>
    <br/>
    
    

    
    <div id="clearDiv"></div>
    </div>
  </div>
</div>
</form>
</body>
</html>