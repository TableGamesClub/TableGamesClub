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
    width:1300px;
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
.smbodyright
{
    height:995px;
    width:930px;
    border-top:3px double #008a00;
    border-right:3px double #008a00;
    border-bottom:3px double #008a00;
    margin-top: -1000px;
    margin-left:364px;
    border-radius:10px 10px 10px 10px;
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
    margin-top: 25px;
    
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

.bottom{
    margin-top: 5px;
    margin-left:25px;
	width:220px;
	height:35px;
}
.smbodybottom
{
    border-radius:10px 10px 10px 10px;
    border:3px solid green;
    margin-top:15px;
}
.smbdrtllimbo
{
    margin-left:15px;
}
.gameintro
{
    border:3px solid green;
    margin:5px;
}
.selectoption
{font-size:20px;color:#006e2e;font-family:Microsoft JhengHei;}
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
         <div class="smbodyleftinsidetext"><center><a href="#" class="selectoption">個人資訊</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="#" class="selectoption">專賣店資訊</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="#" class="selectoption">桌遊資訊</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="https://tw.yahoo.com/" class="selectoption">查看所有團</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="#" class="selectoption">登出</a></center></div>
      </div>
    </div>
  </div>
  <div class="smbodyright">
    <div class="smbodyrighttop">
      <div class="aditheadimage">
      <img src="res/BoardGames/Angrybirds spaces.jpg" class="headimage">
      </div>
      <div class="smbodyrighttopleft">
        <div class="smbdrtllimbo">
         <p style="font-size:20px;color:blue;margin-top:10px;font-family:Microsoft JhengHei;">遊戲類型：</p><br>
         <input type="checkbox" id="gametypetwo">策略遊戲
         <input type="checkbox" id="gametypethree">益智遊戲
         <input type="checkbox" id="gametypefour">推理遊戲
         <input type="checkbox" id="gametypefive">角色扮演遊戲
         <input type="checkbox" id="gametypesix">小品遊戲
        </div>
      </div>
      <div class="smbodymiddleline"></div>
      <div class="smbodybottom">
      <table class="displaytable">
<!-- 	<tr> -->
<!-- 		<th>桌遊圖片</th> -->
<!-- 	</tr> -->
	<%@ include file="Store/pages/page1.file" %>
	<tr><!--將修改的那一筆加入對比色而已-->
	<c:forEach var="BoardGames" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
<%-- 		<tr align='center' valign='middle' ${(BoardGames.boardGamesId==param.boardGamesId) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已--> --%>
<%-- 			<td><img src="${pageContext.servletContext.contextPath}/controller/GetImage?id=${BoardGames.boardGamesId}"></td> --%>
<!-- 		</tr> -->
		<%n++;%>
			<td align='center' valign='middle' ${(BoardGames.boardGamesId==param.boardGamesId) ? 'bgcolor=#CCCCFF':''}>
				<a href="${pageContext.servletContext.contextPath}/controller/GetImageInfo?id=${BoardGames.boardGamesId}" style="">
					<img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${BoardGames.boardGamesId}&type=BOARDGAMES" style="height:120px;width:150px;margin-top:20px;border:3px solid green;">
				</a>
			<br>
			${BoardGames.boardGameName}
			</td>
		<%if(n%3==0){%>
			</tr><tr>
		<%}%>
	</c:forEach>
	</tr>
</table>
<%@ include file="Store/pages/page2.file" %>
      </div>
    </div>
  </div>
</div>
</body>
</html>