<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    padding-top:25px;
    padding-left:15px;
    border-radius:10px 10px 10px 10px;
    width:895px;
    height:943px;
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
.groupcheckmain{
    width:850px;
    height:150px;
    font-size:18px;
    font-family:Microsoft JhengHei;
    border:7.5px outset #00660F;
    padding:10px 10px 10px 10px;
    line-height:30px;
    border-radius:7px 7px 7px 7px;
    background-image:url(images/bamboo.png);
    font-weight:600;
    color:#195400;
}
.cancelbt{
 	position:relative;
 	left:678px;
 	top:-61px;
    width: 200px;
    height: 40px;
    font-family:Microsoft JhengHei;
    font-size:18px;
    border-top-left-radius:10px 10px;
    background: -webkit-gradient(linear, left bottom, right top, 
    color-stop(0%,rgba(82,177,82,1)), color-stop(32%,rgba(0,138,0,1)), color-stop(100%,rgba(0,36,0,1)));
    color:#fefcea;
border:0;}

.groomImg{
	border: 1px solid green;
	position: relative;
	left:710px;
	top: -235px;
	height:100px;
	width:100px;
}

.groomImg img{
	width: 100px;
	height: 100px;
}
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
      <img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${storemem.storeMemberId}&type=storeMember" class="headimage"><br>     
      </div>
      <div class="memberstatus">
            <center><p style="font-size:20px;line-height:22px;color:#FFFFDF;">帳號:${storemem.storeUsername}</p></center>
            <center><p style="font-size:20px;line-height:22px;color:#FFFFDF;">登入時間:${JoinDate}</p></center> 
      </div>
      <div class="smbodyleftinsidebottom" id="selectable">
         <div class="smbodyleftinsidetext"><center><a href="StoreMemberInformation.jsp"  class="selectoption">個人資訊</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="<c:url value='/StoreMemberInfoServlet'/>" class="selectoption">專賣店資訊</a></center></div>
         <div class="smbodyleftinsidetext"><center><a href="StoreMemberLoginout.jsp" class="selectoption">登出</a></center></div>
      </div>
    </div>
  </div>
  <div class="smbodyright">
    <div class="smbodyrighttop">
       <div style="border-bottom:6px solid #660000;padding-bottom:10px;width:900px;margin-right:15px;"><p style="font-size:32px;font-family:Microsoft JhengHei;color:#6d0019;">查看專賣店現有團資訊</p></div><br/><br/><br/>
			<div style="font-size:25px;font-weight:600;font-family:Microsoft JhengHei;color:#660000;">我的店:<c:forEach var="store" items="${storeInfoList}">${store.storeName}</c:forEach></div>
			<br>			
			<div style="font-size:18px;font-weight:600;font-family:Microsoft JhengHei;color:#660000;">選在此專賣店開團的團有:</div>
			<br>
			<br>
			<c:set var="switchNum_Group" value="0"/>
			<c:forEach var="Group" items="${gRoomlist}">
			<div class="groupcheckmain">
				團名:
				${Group.groupRoomName}
				<br>
				預約時間:
				${Group.reserveGroupStartTime}
				<br>
					<div style="height:180px">
					<c:if test="${switchNum_Group==0}">
							此團遊玩桌遊類型:
							<c:forEach var="kindList" items="${gamesKindMap.gamesKindList0}">
								${kindList.boardGameStyle}
							</c:forEach>
							<br>
							桌遊:
							<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList0}">
							${GroupChoiceGames.boardGameName}
							</c:forEach>
							<br>
							目前加入人數:
							${joinerCountMap.joinerCountList0}
					</c:if>
					<c:if test="${switchNum_Group==1}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList1}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>
						桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList1}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList1}
					</c:if>
					<c:if test="${switchNum_Group==2}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList2}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>
						桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList2}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList2}
					</c:if>
					<c:if test="${switchNum_Group==3}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList3}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>
						桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList3}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList3}
					</c:if>
					<c:if test="${switchNum_Group==4}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList4}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>
						桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList4}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList4}
					</c:if>
					<c:if test="${switchNum_Group==5}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList5}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList5}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList5}
					</c:if>
					<c:if test="${switchNum_Group==6}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList6}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList6}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList6}
					</c:if>
					<c:if test="${switchNum_Group==7}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList7}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList7}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList7}
					</c:if>
					<c:if test="${switchNum_Group==8}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList8}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>
						桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList8}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList8}
					</c:if>
					<c:if test="${switchNum_Group==9}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList9}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>
						桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList9}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList9}
					</c:if>
					<c:if test="${switchNum_Group==10}">
						此團遊玩桌遊類型:
						<c:forEach var="kindList" items="${gamesKindMap.gamesKindList10}">
							${kindList.boardGameStyle}
						</c:forEach>
						<br>
						桌遊:
						<c:forEach var="GroupChoiceGames" items="${groupChoiceGamesMap.groupChoiceGamesList10}">
						${GroupChoiceGames.boardGameName}
						</c:forEach>
						<br>
						目前加入人數:
						${joinerCountMap.joinerCountList10}
					</c:if>
					</div>
					<div class="groomImg">
						<img src="${pageContext.servletContext.contextPath}/controller/GetImages?id=${Group.groupSerialNumber}&type=GroupRoom" class="groupimage">
					</div>
				<c:set var="switchNum_Group" value="${switchNum_Group+1}"/>
				<br>
			</div>
			<br>
			<form action="<c:url value='/StoreMemberCancelGroupServlet'/>" method="post">
				<input type="submit" value="取消服務" class="cancelbt" id="cancelbt00">
				<input type="text" value="${Group.groupSerialNumber}" name="cancelbt00" style="display: none">
			</form>
			</c:forEach>
				
    </div>
  </div>
</div>
</body>
</html>
