<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/TableGamesClub/resources/demos/style.css">
<link rel="stylesheet" href="/TableGamesClub/Jquary/demo.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/TableGamesClub/Jquary/flexslider.css" type="text/css" media="screen" />
<title>加團資訊</title>
<style type="text/css">
.errormsg
{
 margin-left:165px;
 margin-top:20px;
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
    background-image:url(/TableGamesClub/images/scapes2.png);
    
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
 	background-image:url(/TableGamesClub/res/bo.jpg); 
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
 	background: #c5deea url('/TableGamesClub/bottom.gif') no-repeat bottom; 
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
.bodytwo
{
    padding-top:15px;
    padding-left:25px;
    margin-top:100px;
    width:1275px;
    height:50px;
    background:-webkit-gradient(linear, left top, 
                                        right bottom, 
                                        color-stop(0%,#feffff), 
                                        color-stop(35%,#ddf1f9), 
                                        color-stop(100%,#a0d8ef));
    border-top-left-radius:10px 10px;
    border-top-right-radius:10px 10px;
    border-bottom-left-radius:10px 10px;  
    border-bottom-right-radius:10px 10px;
    box-shadow: 3px 3px 3px rgba(20%,20%,40%,0.7);
}
.bodyleft
{
    margin-top:25px;
    width:1300px;
    height:550px;
    background:-webkit-gradient(linear, left top, 
                                        right bottom, 
                                        color-stop(0%,#feffff), 
                                        color-stop(35%,#ddf1f9), 
                                        color-stop(100%,#a0d8ef));
    border-top-left-radius:10px 10px;
    border-top-right-radius:10px 10px;
    border-bottom-left-radius:10px 10px;  
    border-bottom-right-radius:10px 10px;
    box-shadow: 3px 3px 3px rgba(20%,20%,40%,0.7);
}
.bodyleftinsideone
{  
    padding-top:25px;
    margin-left:25px;
    width:450px;
    height:5px;
    background:#FFFFFF;
}
.bodyleftinsidetwo
{  
    margin-top:-25px;
    margin-left:25px;
    width:450px;
    height:500px;
    background:-webkit-gradient(linear, left top, 
                                left bottom, color-stop(0%,#c5deea), 
                                color-stop(0%,#8abbd7), color-stop(70%,#066dab));
    border-top-left-radius:10px 10px;
    border-top-right-radius:10px 10px;
    border-bottom-left-radius:10px 10px;  
    border-bottom-right-radius:10px 10px;
    box-shadow:2px 2px 2px rgba(20%,20%,40%,0.6),
               4px 4px 6px rgba(20%,20%,40%,0.4),
               6px 6px 12px rgba(20%,20%,40%,0.4);
}
.bodyleftlimbo
{
    padding: 30px 30px 30px 30px;
    width:390px;
    height:400px;
    border-top:3px Solid #DDF1F9;
    
}
#abgne-block-20110317 {
margin-right: 30px;
margin-left: auto;
margin-top: -545px;
width: 720px;
height: 480px;
border: 10px solid #0a77d5;
border-top-left-radius:10px 10px; 
border-top-right-radius:10px 10px; 
border-bottom-left-radius:10px 10px;   
border-bottom-right-radius:10px 10px; 
box-shadow: 3px 3px 3px rgba(20%,20%,40%,0.7);
}
.abgne-player {

	width: 720px;	/* 圖片的寬 */
	height: 450px;	/* 圖片的高 */
	position: relative;
	overflow: hidden;
}
.abgne-player ul.abgne-list {
	position: absolute;
	width: 9999px;
	height: 100%;
}
.abgne-player ul.abgne-list li {
	float: left;
	width: 720px;	/* 圖片的寬 */
	height: 100%;
}
.abgne-player ul.abgne-list img{
	width: 100%;
	height: 100%;
	border: 0;
}
.abgne-control {
	height: 24px;
	padding: 3px;
	color: #fff;
	font-size: 13px;
	background: #3f4c6b;
}
.abgne-control ul {
	float: left;
}
.abgne-control ul li {
	float: left;
	padding: 0 5px;
	line-height: 20px;
	margin: 2px;
	background: #3f4c6b;
	cursor: pointer;
}
.abgne-control ul.numbers {
	margin-left: 13px;
}
.abgne-control ul li.current {
	background: #fff;
	color:#3f4c6b;;
}
.abgne-control ul li.hover {
	background: #fff;
	color:#3f4c6b;;
}
#textone
{
    width:130px;
}
#texttwo
{
    width:130px;
    float:right;
}
#textthree
{
    width:130px;
}
#textfour
{
    float: right;
    width: 127px;
}
#selectone 
{
    width:134px;
    float: left;
}

#selecttwo 
{
    width:130px;
    float:right;
}
#selectonep
{
    color:#F0F8FF;
    font-family:Microsoft JhengHei;
	font-weight:bolder;
    font-size:16px;
    margin-top:12px
}

#selecttwop
{ 
    color:#F0F8FF;
    font-family:Microsoft JhengHei;
	font-weight:bolder;
    font-size:16px;
    margin-top: -20px;
    width:130px;
    float:right;
}
#selectthreep
{
    color:#F0F8FF;
    font-family:Microsoft JhengHei;
	font-weight:bolder;
    margin-top: 45px;
    font-size:16px;
    width:130px;
}
#selectfourp
{
    color:#F0F8FF;
    font-family:Microsoft JhengHei;
	font-weight:bolder;
    margin-top: -18px;
    font-size: 16px;
    width: 130px;
    float: right;
}
#selecttfivep
{
    color:#F0F8FF;
    font-family:Microsoft JhengHei;
	font-weight:bolder;
    margin-top: 25px;
    font-size: 16px;
    width:130px;
}
#selectthree
{
    width:134px;
}



div#abgne_marquee {
	position: relative;
	overflow: hidden;	/* 超出範圍的部份要隱藏 */
	width: 580px;
	height: 28px;
	border: 1px solid #750000;
}
div#abgne_marquee ul, div#abgne_marquee li {
	margin: 0;
	padding: 1;
	list-style: none;
}
div#abgne_marquee ul {
	position: absolute;
	left: 30px;			/* 往後推個 30px */
}
div#abgne_marquee ul li a {
    color:#EA0000;
	display: block;
	overflow: hidden;	/* 超出範圍的部份要隱藏 */
	font-size:16px;
	height: 28px;
	line-height: 25px;
	text-decoration: none;
}
div#abgne_marquee div.marquee_btn {
	position: absolute;
	cursor: pointer;
}
div#abgne_marquee div#marquee_next_btn {
	left: 5px;
}
div#abgne_marquee div#marquee_prev_btn {
	right: 5px;
}

.advbodyleft
{
    width:580px;
    height:30px;
    border:1px solid #750000;
}
.advshowleft
{
    margin-top:-31px;
    width:200px;
    height:35px;
    background:-webkit-gradient(linear, left top, 
                                right top, 
                                color-stop(1%,#e82020), 
                                color-stop(59%,#b70303), 
                                color-stop(100%,#7f0000));
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

.groupintromain
{
    border:4px ridge white;
    width:1000px;
    height:1200px;
    margin-top:25px;
    box-shadow: 10px 10px 10px rgba(29, 60, 31,0.7);
    background-image:url(/TableGamesClub/images/bubblegroup-green.png);
    border-bottom-right-radius:150px 150px;
    border-top-right-radius:10px 10px;
    border-top-left-radius:90px 90px;
    border-bottom-left-radius:10px 10px;
}
.groupimage
{
    width:600px;
    height:400px;
    margin-top: 15px;
    background:#CCEAD0;
    border-radius:15px 15px 15px 15px;
    box-shadow: 5px 5px 5px rgba(20%,20%,40%,0.5);

}
.groupinfoone
{
    border:1px solid #87FA8D;
    border-radius:50px 50px 50px 50px;
    width:300px;
    height:50px;
    background: -webkit-gradient(linear, left top, right top, 
    color-stop(0%,#6dce73), color-stop(100%,#004f07));
    box-shadow: 7px 7px 7px rgba(31,81,35,0.8);
}
.groupinfotwo
{
    border:1px solid #87FA8D;
    border-radius:50px 50px 50px 50px;
    width:300px;
    height:50px;
    background: -webkit-gradient(linear, left top, right top, 
    color-stop(0%,#004f07), color-stop(100%,#6dce73));
    box-shadow: 7px 7px 7px rgba(31,81,35,0.8);
}
.gione 
{margin-top: 25px;margin-left: 130px;padding-top: 20px;padding-left: 10px;}
.gitwo{margin-top: 25px;margin-left: 130px;padding-top: 20px;padding-left: 10px;}
.githree{float: right;margin-right: 130px;margin-top: -115px;padding-top: 20px;padding-left: 10px;}
.gifour{margin-top: 25px;margin-left: 130px;padding-top: 20px;padding-left: 10px;}
.gifive{float: right;margin-right: 130px;margin-top: -115px;padding-top: 20px;padding-left: 10px;}
.gisix{margin-top: 25px;margin-left: 130px;padding-top: 20px;padding-left: 10px;}
.giseven{float: right;margin-right: 130px;margin-top: -115px;padding-top: 20px;padding-left: 10px;}
.gieight{margin-top: 25px;margin-left: 130px;padding-top: 20px;padding-left: 10px;}
.ginine{float: right;margin-right: 130px;margin-top: -115px;padding-top: 20px;padding-left: 10px;}
.giten{margin-top: 25px;margin-left: 130px;padding-top: 20px;padding-left: 10px;}
.gieleven{float: right;margin-right: 130px;margin-top: -115px;padding-top: 20px;padding-left: 10px;}
.gitwelve{float: right;margin-right: 130px;margin-top: -16px;padding-top: 20px;padding-left: 10px;}
.gitext{font-size:20px;font-family:Microsoft JhengHei;font-size:600;color:#e0eff9;}
.gicommit{width:250px;height:50px;margin-left: 160px;margin-top: 95px;
border-radius:10px 10px 10px 10px;
background: -webkit-gradient(linear, left top, left bottom, 
color-stop(0%,#F5F6F5), color-stop(12%,#DBE2DC), color-stop(49%,#B8C6BA), 
color-stop(100%,#DDE3DE), color-stop(100%,#F5F6F5));
box-shadow: 5px 5px 5px rgba(20%,20%,40%,0.5);
border:1px outset white; }
.giback{width:250px;height:50px;margin-right: 159px;float: right;margin-top: -50px;
border-radius:10px 10px 10px 10px;
background: -webkit-gradient(linear, left top, left bottom, 
color-stop(0%,#F5F6F5), color-stop(12%,#DBE2DC), color-stop(49%,#B8C6BA), 
color-stop(100%,#DDE3DE), color-stop(100%,#F5F6F5)); 
box-shadow: 5px 5px 5px rgba(20%,20%,40%,0.5);
border:1px outset white; }
.gictext{font-size:20px;font-family:Microsoft JhengHei;font-weight:bolder;color:#2B6F18;}
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

$(function(){
	// 先取得必要的元素並用 jQuery 包裝
	// 再來取得 $block 的高度及設定動畫時間
	var $block = $('#abgne-block-20110317'),
		$slides = $block.find('ul.abgne-list'),
		_width = $block.width(),
		$li = $slides.find('li'),
		$control = $block.find('.abgne-control'), 
		_animateSpeed = 600, 
		// 加入計時器, 輪播時間及控制開關
		timer, _showSpeed = 3000, _stop = false;
 
	// 設定 $slides 的寬(為了不讓 li 往下擠)
	$slides.css('width', ($li.length + 1) * _width);
	// 產生 li 選項
	var _str = '';
	for(var i=0, j=$li.length;i<j;i++){
		// 每一個 li 都有自己的 className = playerControl_號碼
		_str += '<li class="abgne-player-control_' + (i+1) + '">' + (i+1) + '</li>';
	}
 
	// 產生 ul 並把 li 選項加到其中
	var $number = $('<ul class="numbers"></ul>').html(_str).appendTo($control), 
		$numberLi = $number.find('li');
 
	// 並幫 .numbers li 加上 click 事件
	$numberLi.click(function(){
		var $this = $(this);
		$this.addClass('current').siblings('.current').removeClass('current');
 
		clearTimeout(timer);
		// 移動位置到相對應的號碼
		$slides.stop().animate({
			left: _width * $this.index() * -1
		}, _animateSpeed, function(){
			// 當廣告移動到正確位置後, 依判斷來啟動計時器
			if(!_stop) timer = setTimeout(move, _showSpeed);
		});
 
		return false;
	}).eq(0).click();
 
	// 幫 .arrows li 加上 click 事件
	$control.find('ul.arrows li').click(function(){
		var _index = $numberLi.filter('.current').index();
		$numberLi.eq((this.className.indexOf('next')>-1?_index+1:_index-1+$numberLi.length)%$numberLi.length).click();
 
		return false;
	});
 
	// 當滑鼠移到 $control li 上時, 加上 .hover 效果
	// 反之則移除
	$control.find('li').hover(function(){
		$(this).addClass('hover');
	}, function(){
		$(this).removeClass('hover');
	});
 
	// 如果滑鼠移入 $slides 時
	$slides.hover(function(){
		// 關閉開關及計時器
		_stop = true;
		clearTimeout(timer);
	}, function(){
		// 如果滑鼠移出 $block 時
		// 開啟開關及計時器
		_stop = false;
		timer = setTimeout(move, _showSpeed);
	});
 
	// 計時器使用
	function move(){
		$control.find('ul.arrows li.next').click();
	}
});

$(function(){
	// 先取得 div#abgne_marquee ul
	// 接著把 ul 中的 li 項目再重覆加入 ul 中(等於有兩組內容)
	// 再來取得 div#abgne_marquee 的高來決定每次跑馬燈移動的距離
	// 設定跑馬燈移動的速度及輪播的速度
	var $marqueeUl = $('div#abgne_marquee ul'),
		$marqueeli = $marqueeUl.append($marqueeUl.html()).children(),
		_height = $('div#abgne_marquee').height() * -1,
		scrollSpeed = 600,
		timer,
		speed = 3000 + scrollSpeed,
		direction = 0,	// 0 表示往上, 1 表示往下
		_lock = false;
 
	// 先把 $marqueeli 移動到第二組
	$marqueeUl.css('top', $marqueeli.length / 2 * _height);
 
	// 幫左邊 $marqueeli 加上 hover 事件
	// 當滑鼠移入時停止計時器；反之則啟動
	$marqueeli.hover(function(){
		clearTimeout(timer);
	}, function(){
		timer = setTimeout(showad, speed);
	});
 
	// 判斷要往上還是往下
	$('div#abgne_marquee .marquee_btn').click(function(){
		if(_lock) return;
		clearTimeout(timer);
		direction = $(this).attr('id') == 'marquee_next_btn' ? 0 : 1;
		showad();
	});
 
	// 控制跑馬燈上下移動的處理函式
	function showad(){
		_lock = !_lock;
		var _now = $marqueeUl.position().top / _height;
		_now = (direction ? _now - 1 + $marqueeli.length : _now + 1)  % $marqueeli.length;
 
		// $marqueeUl 移動
		$marqueeUl.animate({
			top: _now * _height
		}, scrollSpeed, function(){
			// 如果已經移動到第二組時...則馬上把 top 設回到第一組的最後一筆
			// 藉此產生不間斷的輪播
			if(_now == $marqueeli.length - 1){
				$marqueeUl.css('top', $marqueeli.length / 2 * _height - _height);
			}else if(_now == 0){
				$marqueeUl.css('top', $marqueeli.length / 2 * _height);
			}
			_lock = !_lock;
		});
 
		// 再啟動計時器
		timer = setTimeout(showad, speed);
	}
 
	// 啟動計時器
	timer = setTimeout(showad, speed);
 
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
      <a href="/TableGamesClub/home.jsp" id="a1">首頁</a>
    </li>
    <li>
      <a href="/TableGamesClub/CreateGroup.jsp"
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
      		<a href="/TableGamesClub/register.jsp" id="a1">註冊</a>
    </li>
      	</c:if>
    <li class="User">
    	<c:if test="${empty Member}">
			<a href="<c:url value='/login.jsp'/> " id="a1"> 登入 </a>
		</c:if>
		<c:if test="${ ! empty Member }">
			<a id="a1" class="A1" href="#"><font>使用者<img src="/TableGamesClub/res/arror_down.png" height="16px" style="position: relative; top:2px; left:52px"></font></a>
			<ul>
        		<li>
          			<a href="<c:url value='/MemberInfoServlet'/> " id="a2">會員資料</a>
          			
        		</li><br /><br />
        		<li>
          			<a href="/TableGamesClub/loginout.jsp" id="a2">登出</a>
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
<div style="margin:0 auto;width:1000px;">
  <div class="groupintromain">
          <center><img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${requestimage.simpleimage}&type=GROUPROOM" class="groupimage" ></center>
    <div class="groupinfoone gione"><p class="gitext">房間名稱:${info.GroupRoom.groupRoomName}</p></div>
    <div class="groupinfoone gitwo"><p class="gitext">店家名:${info.GroupRoom.storeName}</p></div>
    <div class="groupinfotwo githree"><p class="gitext">開團者暱稱:${roomMaster.DarkFlameMaster.nickname}</p></div>
    <div class="groupinfoone gifour"><p class="gitext">類型名:${info3.type0} ${info3.type1} ${info3.type2} ${info3.type3} ${info3.type4}</p></div>
    <div class="groupinfotwo gifive"><p class="gitext">桌遊名:${info4.choicegames0} ${info4.choicegames1} ${info4.choicegames2} ${info4.choicegames3} ${info4.choicegames4} ${info4.choicegames5} ${info4.choicegames6} ${info4.choicegames7} ${info4.choicegames8} ${info4.choicegames9} </p></div>
    <div class="groupinfoone gisix"><p class="gitext">開團開始時間:${info.GroupRoom.groupStartTime} </p></div>
    <div class="groupinfotwo giseven"><p class="gitext">開團結束時間:${info.GroupRoom.groupEndTime}</p></div>
    <div class="groupinfoone gieight"><p class="gitext">遊玩人數 : ${info5.numbernin}</p></div>
    <div class="groupinfotwo ginine"><p class="gitext">店家上限人數:${info.GroupRoom.groupUpperLimit}</p></div>
    <div class="groupinfoone giten"><p class="gitext">預約場地開始時間:${info.GroupRoom.reserveGroupStartTime}</p></div>
    <div class="groupinfotwo gieleven"><p class="gitext">預約場地結束時間:${info.GroupRoom.reserveGroupEndTime }</p></div>
    <div class="groupinfotwo gitwelve"><p class="gitext">遊玩時間:${info.GroupRoom.groupGameTime}</p></div>
  
  
<%--     <center><img src="" class="groupimage" ></center> --%>
<!--     <div class="groupinfoone gione"><p class="gitext">房間名稱:來玩桌遊巴!</p></div> -->
<!--     <div class="groupinfoone gitwo"><p class="gitext">店家名</p></div> -->
<!--     <div class="groupinfotwo githree"><p class="gitext">開團者暱稱</p></div> -->
<!--     <div class="groupinfoone gifour"><p class="gitext">類型名</p></div> -->
<!--     <div class="groupinfotwo gifive"><p class="gitext">桌遊名</p></div> -->
<!--     <div class="groupinfoone gisix"><p class="gitext">開團開始時間</p></div> -->
<!--     <div class="groupinfotwo giseven"><p class="gitext">開團結束時間</p></div> -->
<!--     <div class="groupinfoone gieight"><p class="gitext">遊玩人數 </p></div> -->
<!--     <div class="groupinfotwo ginine"><p class="gitext">店家上限人數</p></div> -->
<!--     <div class="groupinfoone giten"><p class="gitext">預約場地開始時間</p></div> -->
<!--     <div class="groupinfotwo gieleven"><p class="gitext">預約場地結束時間</p></div> -->
<!--     <div class="groupinfotwo gitwelve"><p class="gitext">遊玩時間</p></div> -->
    <div><a href="${pageContext.servletContext.contextPath}/controller/GIS?id=${tempToGroupInServlet.gid}" ><input type="submit" class="gicommit gictext" value="我要加團"></a></div>

    <div><a href="<c:url value='/SelectLookForGroupServlet'/>"><input type="submit" class="giback gictext" value="返回上一頁"></a></div>
    <div class="errormsg"><font style="color:red; font-size:24px" >${insertOk.CreateOK }${insertNotOk.storeupper }  ${insertNotOk.groupupper}</font></div>
    </div>
  
</div>
</body>
</html>