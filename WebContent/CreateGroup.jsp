<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="controller.*"%>
<%@ page import="model.*"%>
<%@ page import="model.service.*"%>
<%@ page import="model.Interface.*"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>

<%
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"model-config1-DriverManagerDataSource.xml");
	BoardGameKindDAO_Interface dao = (BoardGameKindDAO_Interface) context
			.getBean("BoardGameKindDAO");
	BoardGamesDAO_Interface dao2 = (BoardGamesDAO_Interface) context
			.getBean("BoardGamesDAO");
	StoreInformationDAO_Interface dao3 = (StoreInformationDAO_Interface) context
			.getBean("StoreInformationDAO");
	List<BoardGameKind> list = dao.getAll();
	List<StoreInformation> list2 = dao3.getAll();
	pageContext.setAttribute("list",list);
	pageContext.setAttribute("list2",list2);
	
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="Scripts/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="Scripts/jquery-ui.js"></script>
<link rel="stylesheet" href="Jquary/demo.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="Jquary/flexslider.css" type="text/css"
	media="screen" />
<!-- <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css" rel="stylesheet"> -->
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script> -->
<link href='Scripts/jquery-ui-timepicker-addon.css' rel='stylesheet'>
<script type="text/javascript" src="Scripts/jquery-ui-timepicker-addon.js"></script>
<script type='text/javascript' src='Scripts/jquery-ui-sliderAccess.js'></script>
<!-- <script type='text/javascript' src='Scripts/jquery.livequery.min.js'></script> -->

<title>開團</title>
<style type="text/css">
.red{color:red;}
.gray{color:gray;}
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
    border-radius:10px 10px 10px 10px;
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

.cgbody
{
   border-top-left-radius:10px 10px;
   border-top-right-radius:10px 10px;
   border-bottom-left-radius:10px 10px;
   border-bottom-right-radius:10px 10px;
   margin-left: 200px;
   margin-top:25px;
   width:850px;
   height:900px; 
   background: -webkit-gradient(linear, left bottom, 
                                right top, 
                                color-stop(51%,#feffff), 
                                color-stop(100%,#ddf1f9), 
                                color-stop(100%,#a0d8ef));
   font-size:18px;
   color:#2c539e;
   font-family:Microsoft JhengHei;
   overflow-x:hidden;
   overflow-y:auto;
}

.choiceGame{
	font-size: 80%; 
	float:left;
	border:3px outset;
	margin: 1px 1px;
}
#ui-datepicker-div.ui-datepicker.ui-widget.ui-widget-content.ui-helper-clearfix.ui-corner-all{
	width: 300px;
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
    $( "#datepicker" ).datepicker(); //時間選擇
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
<form enctype="multipart/form-data" action="<c:url value="/CreateRoomServletMB"/>" method="post"
					id="createRoomJSP">
	<div  style="margin:0 auto;width:1300px;">
		<div class="cgbody">
			<center>
				<div><br/><br/><br/><br/>
						<h1 style="font-size:36px;font-weight:900;">開團資料</h1>
				<div style="margin-top:35px;">輸入您的桌遊團名<span class="red">*</span></div>
					<input type="text" style="width:200px" style="width:200px" placeholder="" name="roomName"></div>
				<div><span>選擇店家:</span><span class="red">*</span></div>
				<div>
					<select id="boardGameStore" name="boardGameStore">
						<option value="0">請選擇</option>
						<c:forEach var="stores" items="${list2}">
							<option value="${stores.storeId}">${stores.storeName}</option>
						</c:forEach>
					</select>
				</div>
				<div style="display: inline" id="gametype">
					<div><span>桌遊類型:</span><span class="red">*</span></div>
					<div style="margin-left: 27px">
						<select id="select1" style="width:80px" name="gamesType">
							<option value="0">請選擇</option>
							<c:forEach var="games" begin="0" end="6" items="${list}">
								<option value="${games.boardGameSerialNumber}" name="">${games.boardGameStyle}</option>
							</c:forEach>
						</select>
						<select id="select2" style="width:120px" name="gamesName">
							<option value="volvo">請選擇</option>
						</select>
						<input type="button" id="CreateNewStylebutton" value="+" />
					</div>
					<div id="sapnType" style="width: 300px;height:200px;border:1px solid black;overflow: scroll;overflow-x:hidden;padding: 3px 3px"></div>
				</div>
				<div><span>預約時間:</span><span class="red">*</span></div>
					<div style="">
						<span><input id="datetimepicker1" type="text" style="width:100px" name="startTime" value="2015-02-01 10:00:00"/></span>~
						<span><input id="datetimepicker2" type="text" style="width:100px" name="endTime" value=""/></span>
					</div>
					<div id="ajaxImgSpan" style="height:25px;width:25px"><img src="res/ajax.gif" id="ajaxImg" style="display: none"></div>
					<div id="timeText" style="margin-bottom: 13px"></div>
				<div><span>開團人數:</span><span class="red">*</span></div>
					<input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;font-size: medium" name="roomNumber">
					<div id="slider-range" style="width:200px"></div>
				<div><span>團圖:</span><span class="red">*</span></div>
				<img id="blah" alt="your image" width="200" height="150"/><br>
				<div style="margin: 2px 0 0 40px">
					<input type="file" onchange="$('#blah')[0].src = window.URL.createObjectURL(this.files[0])" name="roomImg">
				</div>
				<div><span>開團說明:</span><span class="red">*</span></div>
					<div><textarea rows="3" style="width:300px;height:100px;" name="roomString" value="歡迎大家一起來玩桌遊喔！"></textarea></div><br/><br/>		
				<button type="submit" style="width:240px;height:60px;font-size:20px;font-family:Microsoft JhengHei;color:#0a77d5;background: -webkit-gradient(linear, left bottom, right top, color-stop(0%,#feccb1), color-stop(62%,#f17432), color-stop(100%,#ea5507), color-stop(100%,#fb955e));color:#f8ffe8;">完成開團!</button>	
			</center>
		</div>
	</div>
</form>
  <script language="JavaScript">
  //時間選擇器
    $(document).ready(function(){ 
//       var opt1={dateFormat: 'yy-mm-dd',
// 	        showSecond: true,
//                 timeFormat: 'HH:mm:ss',
// 		stepHour:2, 
// 		stepMinute:5, 
// 		stepSecond:10
//                 };
//       var opt2={dateFormat: 'yy-mm-dd',
// 	        showSecond: true,
//                 timeFormat: 'HH:mm:ss',
// 		controlType:"select"
//                 };
      var opt3={dateFormat: 'yy-mm-dd',
	        showSecond: false,
                timeFormat: 'HH:mm:ss',
		addSliderAccess:true,
		sliderAccessArgs:{touchonly:false}
                };
      $('#datetimepicker1').datetimepicker(opt3);
      $('#datetimepicker2').datetimepicker(opt3);
//       $('#datetimepicker3').datetimepicker(opt3);
      });

  //選擇桌遊ajax
</script>
<script>
        var btnLoad = document.getElementById("select1");
        var a1 = $('#select1');
        btnLoad.addEventListener("click",beforeload,false);
        var xhr;
        
        function beforeload(){
			if($(this).val()==a1.val()){
				btnLoad.addEventListener("click",load,false);
			}
        }
        
        function load(){    
			var boardGameStore = document.getElementById("boardGameStore");//抓取店家號碼
        	xhr = new XMLHttpRequest();
        	xhr.addEventListener("readystatechange",callback2,false);
            var url = "GetGamesJson?storeId="+boardGameStore.value+"&type="+$(this).val();     //url要改
        	xhr.open("get",url,true); 
        	xhr.send();
        }
        function callback2(){
        	if(xhr.readyState == 4){
        		if(xhr.status == 200){
	      		var data = xhr.responseText
	      		var datas=JSON.parse(data);
	      		var txtLi
	          	var myDiv = document.getElementById("select2");
	      		$('#select2').empty();
	      		$('#select2').append("<option>請選擇</option>");
	          	for(var i=0;i<datas.length;i++){
				var txtLi = document.createTextNode(datas[i]);
	       	  	var eleLi = document.createElement("option");
				eleLi.appendChild(txtLi);
				console.log(txtLi);
	          	 	myDiv.appendChild(eleLi);	            	 
	          	 }
        		}else{
        			alert(xhr.status + ":" + xhr.statusText);
                }
        	}
        }
 </script>    
 <script>
      //按鈕
    	$('#CreateNewStylebutton').bind('click',function(){
    			$('#sapnType')
    			.append("<span class='choiceGame'>"+"<input type='checkbox' name='games' value="+$('#select2').val()+" checked style='display:none;'>"+$('#select2').val()+
    				   "<a href=# class='del'><img src='res/Icon/xx.png' style='height:18px;position:relative;top:4px'></a></span>");
//     			alert($('span[name="games"]').text())
//     			$('input[name="games"]').after(123);
    		});
    		
    		$('#gametype').on('click','.del',function(){
//     			alert(123)
        		$(this).parents('span').remove();
        		$(this).parents('br').remove();
        	})
        	
    	//滑動條
		var u = 2;
		var l = 60;
	    $( "#slider-range" ).slider({
	      range: true,
	      min: u,
	      max: l,
	      values: [ 5, 15 ],
	      slide: function( event, ui ) {
	        $( "#amount" ).val( ui.values[ 0 ] + " ~ " + ui.values[ 1 ] );
	      }
	    });
	    $( "#amount" ).val(   $( "#slider-range" ).slider( "values", 0 ) +
	      " ~ " + $( "#slider-range" ).slider( "values", 1 ) );
	    
	    
	    //ajax開團時間判斷
	    $("#datetimepicker1").datetimepicker({
	    	onClose: function() {
			}
		});
	    $("#datetimepicker2").datetimepicker({
	    	onClose: function() {
	    		load2();
			}
		});
	    
	    
			var xmlHttp;
			function load2(){
// 				alert($('#datetimepicker1').val());
// 				alert($('#datetimepicker2').val());
// 				alert($('#boardGameStore').val());
				xmlHttp=new XMLHttpRequest();
				xmlHttp.addEventListener("readystatechange",callback,false);
				var url="GetCount?S="+$('#datetimepicker1').val()+"&E="+$('#datetimepicker2').val()+"&N="+$('#boardGameStore').val();
				xmlHttp.open("get",url,true);//true為非同步
				xmlHttp.send();
			}
			
			function callback(){
				console.log(xmlHttp.readyState);
				document.getElementById("timeText").innerHTML="";//清空一次
				if(xmlHttp.readyState==1){
					$('#ajaxImg').css("display","inline");
				}
				if(xmlHttp.readyState==4){
					if(xmlHttp.status==200){
						$('#ajaxImg').css("display","none");
						var data2=xmlHttp.responseText;
						var myDiv=document.getElementById("timeText");
						myDiv.innerHTML="店家剩餘人數："+data2+"人";
					}else{
						if($('#boardGameStore').val()==0){
							$('#ajaxImg').css("display","none");
							alert("請先選擇店家！");
							return;
						}
						alert(xmlHttp.status+":"+xmlHttp.statusText);
					}
				}
			}
			
	    
   </script>
</body>
</html>
