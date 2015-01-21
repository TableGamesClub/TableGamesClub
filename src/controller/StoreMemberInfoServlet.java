package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.BoardGameKind;
import model.GroupChoiceGames;
import model.GroupRoom;
import model.Joiner_Info;
import model.StoreInformation;
import model.StoreMember;
import model.Interface.BoardGameKindDAO_Interface;
import model.Interface.BoardGamesDAO_Interface;
import model.Interface.GroupChoiceGamesDAO_Interface;
import model.Interface.GroupRoomDAO_Interface;
import model.Interface.Joiner_InfoDAO_Interface;
import model.Interface.RentalTimeDAO_Interface;
import model.Interface.StoreInformationDAO_Interface;
import model.Interface.StoreMemberDAO_Interface;
import model.Interface.StoreScoreDAO_Interface;
import model.service.StoreMemberService;

@WebServlet("/StoreMemberInfoServlet")
public class StoreMemberInfoServlet extends HttpServlet {
	private StoreMemberDAO_Interface dao1;
	private StoreInformationDAO_Interface dao2;
	private RentalTimeDAO_Interface dao3;
	private StoreScoreDAO_Interface dao4;
	private BoardGamesDAO_Interface dao5;
	private Joiner_InfoDAO_Interface jidao;
	private GroupChoiceGamesDAO_Interface gcgdao;
	private BoardGameKindDAO_Interface bgkdao;
	private GroupRoomDAO_Interface grdao;

	private static final long serialVersionUID = 1L;

	public StoreMemberInfoServlet() {
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "model-config2-JndiObjectFactoryBean.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		dao1 = (StoreMemberDAO_Interface) context.getBean("StoreMemberDAO");
		dao2 = (StoreInformationDAO_Interface) context
				.getBean("StoreInformationDAO");
		dao3 = (RentalTimeDAO_Interface) context.getBean("RentalTimeDAO");
		dao4 = (StoreScoreDAO_Interface) context.getBean("StoreScoreDAO");
		dao5 = (BoardGamesDAO_Interface) context.getBean("BoardGamesDAO");
		jidao = (Joiner_InfoDAO_Interface) context.getBean("Joiner_InfoDAO");
		gcgdao = (GroupChoiceGamesDAO_Interface) context
				.getBean("GroupChoiceGamesDAO");
		bgkdao = (BoardGameKindDAO_Interface) context
				.getBean("BoardGameKindDAO");
		grdao = (GroupRoomDAO_Interface) context.getBean("GroupRoomDAO");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		session.setAttribute("MsgOK", msgOK); // 顯示常訊息
		
		StoreMember storeMember = new StoreMember();
		// 取得session 店家會員資料
		storeMember = (StoreMember) session.getAttribute("storemem");

		if (storeMember != null) {
			// 利用店家找一下專賣店ID
			Set<StoreInformation> list = storeMember.getStoreInformations();
			
			List<StoreInformation> storeInfoList = new ArrayList<StoreInformation>();					
			List<BoardGameKind> gamesKindList = new ArrayList<BoardGameKind>();			
			List<GroupRoom> gRoomlist = new ArrayList<GroupRoom>();			
			List<GroupChoiceGames> groupChoiceGamesList = new ArrayList<GroupChoiceGames>();			
			List<Integer> joinerCountList = new ArrayList<Integer>();			
			List<Joiner_Info> joinerList = new ArrayList<Joiner_Info>();
			
			// 開始用店家會員流水號找到店家專賣店;再用某店家專賣店名稱找到用此店家開的團;接著用此團的流水號找到此團所選的桌遊類型項目及桌遊名稱;算出加入此團的人數
			
			Map<String, List<StoreInformation>> storeInfoMap = new HashMap<String, List<StoreInformation>>();
			Map<String, List<BoardGameKind>> gamesKindMap = new HashMap<String, List<BoardGameKind>>();
			Map<String, List<GroupRoom>> gRoomMap = new HashMap<String, List<GroupRoom>>();
			Map<String, List<GroupChoiceGames>> groupChoiceGamesMap = new HashMap<String, List<GroupChoiceGames>>();
			Map<String, List<Integer>> joinerCountMap = new HashMap<String, List<Integer>>();
			Map<String, List<Joiner_Info>> joinerMap = new HashMap<String, List<Joiner_Info>>();
			
			for (StoreInformation vo : list) {
				// System.out.println("1");
				// System.out.println(vo.getStoreId());
				
				StoreInformation sInformation = dao2.findByPrimeKey(vo.getStoreId());// 用店主鍵找到專賣店資訊
				storeInfoList.add(sInformation);// 裝滿店家專賣店資料
				
				// sInformation.getStoreName();// 拿到店家名
				// System.out.println(vo.getStoreName());
				List<GroupRoom> gRoomList = grdao.findByUnknown(vo.getStoreName());
				int switchNum = 0;
				for (GroupRoom g : gRoomList) {
					
					// 驗證是否為此店家會員的店所開的團
					
					if (g.getStoreMember().getStoreMemberId() == storeMember.getStoreMemberId()) {
						int gRoomId = g.getGroupSerialNumber();// 團主鍵
						
						// 以下開始用if做判斷
						if(switchNum==0){ // 第一房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==1){ // 第二房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==2){ // 第三房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==3){ // 第四房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==4){ // 第五房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==5){ // 第六房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==6){ // 第七房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==7){ // 第八房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==8){ // 第九房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==9){ // 第十房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
						if(switchNum==10){ // 第十一房
							// System.out.println(gRoomId);
							groupChoiceGamesList = gcgdao.getBoardGameNames(gRoomId);// 找出多筆所選桌遊名稱
							groupChoiceGamesMap.put("groupChoiceGamesList"+String.valueOf(switchNum), groupChoiceGamesList);
							
							List<Integer> kindNumber = gcgdao.findByGroupSerialNumber(gRoomId);// 找出多筆所選桌遊類型編號
							gRoomlist.add(g);// 符合條件的放進list
							for (Integer i : kindNumber) {// foreach拿到某團所選得遊戲種類
								gamesKindList.add(bgkdao.findByPrimeKey(i));
							}
							joinerList = jidao.findByGroupSerialNumber(gRoomId);
							joinerCountList.add(joinerList.size());// 算出加入此團的人數
						}
					}
				switchNum++;
				}
			}
			
			// StoreInfomation.jsp
			
			session.setAttribute("storeInfoList", storeInfoList);// 放此店家所屬的多筆專賣店
			session.setAttribute("gRoomlist", gRoomlist);// 放此專賣店所屬的多筆開團資料
			session.setAttribute("gamesKindList", gamesKindList);// 放此開團所屬的多筆桌遊種類
			session.setAttribute("groupChoiceGamesList", groupChoiceGamesList);// 放此開團所屬的多筆桌遊名稱
			session.setAttribute("joinerCountList", joinerCountList);// 放此開團的多筆人數
			
			session.setAttribute("storeInfoMap", storeInfoMap);// 放此店家所屬的多筆專賣店
			session.setAttribute("gRoomMap", gRoomMap);// 放此專賣店所屬的多筆開團資料
			session.setAttribute("gamesKindMap", gamesKindMap);// 放此開團所屬的多筆桌遊種類
			session.setAttribute("groupChoiceGamesMap", groupChoiceGamesMap);// 放此開團所屬的多筆桌遊名稱
			session.setAttribute("joinerCountMap", joinerCountMap);// 放此開團的多筆人數
			
			response.sendRedirect("StoreInformation.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
