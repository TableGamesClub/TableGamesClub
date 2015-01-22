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
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"model-config1-DriverManagerDataSource.xml");
	StoreMemberDAO_Interface dao = (StoreMemberDAO_Interface) context
			.getBean("StoreMemberDAO");
	StoreInformationDAO_Interface dao2 = (StoreInformationDAO_Interface) context
			.getBean("StoreInformationDAO");
	StoreMemberService service = new StoreMemberService();
// 	List<EmpVO> list = empSvc.getAll();
// 	Set<BoardGames> list = service.findStoreById(2).getBoardGameses();
	List<BoardGames> list = service.findGamesByStoreId(2);
	pageContext.setAttribute("list",list);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="Jquary/demo.css" type="text/css" media="screen" />
<link rel="stylesheet" href="Jquary/flexslider.css" type="text/css" media="screen" />
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<title>遊戲資訊</title>
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
    width:365px;
    height:1000px;
    background-color:#660000;
    border-radius:10px 10px 10px 10px;
}
.smbodyleft
{
    border-radius:10px 10px 10px 10px;
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
.displaytable
{
    margin-top: 25px;
    margin-left: 30px;
    width: 825px;
    height: 580px;  
}

.gameintro
{
    border:3px solid green;
    margin:5px;
}
.selectoption
{font-size:20px;color:#006e2e;font-family:Microsoft JhengHei;}
.createbody
{
    float: right;
    width: 910px;
    height: 1000px;
    margin-top: -1000px;
    border-radius:10px 10px 10px 10px;
    }
.createintro
{
    width:400px;
    height:60px;
    background: -webkit-gradient(linear, left top, 
                                 right bottom, 
                                 color-stop(0%,rgba(208,228,247,0.8)), 
                                 color-stop(24%,rgba(115,177,231,0.8)), 
                                 color-stop(100%,rgba(10,119,213,0.8)));
    padding-top:10px;
    padding-left:15px;
    border-radius:10px 10px 10px 10px;
    border:2px ridge white;
}
.cifont{font-size:24px;font-family:Microsoft JhengHei;font-weight:600;}
.citext{width:250px;height:30px;border-radius:5px 5px 5px 5px;}
.cione{margin-top: 10px;margin-left: 20px;}
.citwo{float: right;margin-top: -75px;margin-right: 30px;}
.cithree{margin-top: 10px;margin-left: 20px;}
.cifour{float: right;margin-top: -75px;margin-right: 30px;}
.cifive{margin-top: 15px;margin-left: 20px;}
.cisix{margin-top: 15px;margin-left: 20px;}
.ciinput{margin-top: 5px;width:250px;height:30px;}
</style>

<script type="text/javascript">

</script>
</head>
<body>
<div id="HEADERONE"></div>
<div style="margin:0 auto;width:1300px;">
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
      <div class="smbodyleftinsidebottom">
         <div class="smbodyleftinsidetext"><center><a href="StoreMemberInformation.jsp" class="selectoption">個人資訊</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="<c:url value='/StoreMemberInfoServlet'/>" class="selectoption">專賣店資訊</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="StoreMemberLoginout.jsp" class="selectoption">登出</a></center></div>
      </div>
    </div>
  </div>
  <div class="createbody">
    <div>
      <img src="images/0010.jpg" style="width:400px;height:300px;background:white;margin-top:15px;margin-left:20px;padding:10px;border-radius:10px 10px 10px 10px;">
      <input type="submit" value="上傳桌遊圖片" style="width:160px;height:40px;margin-left: 15px;">
      <div class="createintro cione"><p class="cifont">請輸入圖片名稱：</p>
      <input type="text" class="ciinput"></div>
      <div class="createintro citwo"><p class="cifont">請選擇桌遊類型：</p>
      <select class="ciinput">
        <option>策略遊戲</option>
        <option>益智遊戲</option>
        <option>推理遊戲</option>
        <option>角色扮演遊戲</option>
        <option>小品遊戲</option>
      </select></div>
      <div class="createintro cithree"><p class="cifont">請輸入桌遊原文名：</p>
      <input type="text" class="ciinput"></div>
      <div class="createintro cifour"><p class="cifont">請輸入桌遊名：</p>
      <input type="text" class="ciinput"></div>
      <div class="createintro cifive"><p class="cifont">請輸入遊玩人數：</p>
      <input type="text" class="ciinput"></div>
      <div class="createintro cisix"><p class="cifont">請輸入桌遊介紹：</p>
      <textarea rows="3" style="margin-left: -15px;width:410px;height:220px;resize : none;margin-top:10px;" name="roomString;"></textarea></div>
    </div>
  </div>
</div>
</body>
</html>
