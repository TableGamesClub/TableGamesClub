package controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.BoardGameKind;
import model.BoardGames;
import model.GroupChoiceGames;
import model.GroupRoom;
import model.Joiner_Info;
import model.Member;
import model.StoreInformation;
import model.StoreMember;
import model.Interface.BoardGameKindDAO_Interface;
import model.Interface.BoardGamesDAO_Interface;
import model.Interface.GroupChoiceGamesDAO_Interface;
import model.Interface.GroupRoomDAO_Interface;
import model.Interface.Joiner_InfoDAO_Interface;
import model.Interface.MemberDAO_Interface;
import model.Interface.StoreInformationDAO_Interface;
import model.service.GlobalService;
import model.service.GroupService;
import model.service.MemberService;

@WebServlet(urlPatterns = { "/CreateRoomServletMB" })
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class CreateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("後端程序開始");
		// 準備存放錯誤訊息的Map物件
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放開團成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		
		HttpSession session = request.getSession();
		request.setAttribute("CreateRoomError", errorMsg); // 顯示錯誤訊息
		session.setAttribute("CreateRoomOK", msgOK); // 顯示常訊息
		
		String roomName = "";
		String[] boardGameStoreStr = null;
		String[] gamesType = null;
		String[] gamesName = null;
		String roomNumber = "";
		String startTime = "";
		String endTime = "";
		String roomString = "";
		String filename="";
		int boardGameStore = 0;
		long sizeInBytes = 0;
		InputStream is = null;

		Collection<Part> parts = request.getParts();
		String temp = "";
		// GlobalService.exploreParts(parts, request);
		// 由parts != null來判斷此上傳資料是否為HTTP multipart request
		if (parts != null) { // 如果這是一個上傳資料的表單
			System.out.println(456);
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				String[] value2 = request.getParameterValues(fldName);
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("roomName")) {
						roomName = value;
						System.out.println(value);
					} else if (fldName.equals("boardGameStore")) {
						boardGameStoreStr = new String[value2.length];
						for(int i = 0;i<value2.length;i++){
							System.out.println(value2.length);
							boardGameStoreStr[i] = value2[i];
						}
					} else if (fldName.equalsIgnoreCase("gamesType")) {
						gamesType = new String[value2.length];
						for(int i = 0;i<value2.length;i++){
							System.out.println(value2.length);
							gamesType[i] = value2[i];
						}
					} else if (fldName.equalsIgnoreCase("games")) {
						gamesName = new String[value2.length];
						for(int i = 0;i<value2.length;i++){
							System.out.println(value2.length);
							gamesName[i] = value2[i];
						}
					} else if (fldName.equalsIgnoreCase("roomNumber")) {
						roomNumber = value;
						System.out.println(value);
					} else if (fldName.equalsIgnoreCase("startTime")) {
						startTime = value;
						System.out.println(value);
					} else if (fldName.equalsIgnoreCase("endTime")) {
						endTime = value;
						System.out.println(value);
					} else if (fldName.equalsIgnoreCase("roomString")) {
						roomString = value;
						System.out.println(value);
					}
				} else {
					filename = GlobalService.getFileName(p); // 此為圖片檔的檔名
					if (filename != null && filename.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} else {
						errorMsg.put("errPicture", "必須挑選圖片檔");
						System.out.println(0);
					}
				}
			}
			// 2. 進行必要的資料轉換
			for(String b : boardGameStoreStr){//店家號碼
				try {
					boardGameStore = Integer.parseInt(b);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// 3. 檢查使用者輸入資料
			if (roomName == null || roomName.trim().length() == 0) {
				errorMsg.put("errorRoomName", "團名必須輸入");
				System.out.println(1);
			}
			if (boardGameStore == 0) {
				errorMsg.put("errorBoardGameStore", "店家必須輸入");
				System.out.println(2);
			}
			if (gamesType == null) {
				errorMsg.put("errorGamesType", "類別必須輸入");
				System.out.println(3);
			}
			if (gamesName == null) {
				errorMsg.put("errorGamesName", "桌遊必須輸入");
				System.out.println(4);
			}
			if (roomNumber == null) {
				errorMsg.put("errorRoomNumber", "人數必須輸入");
				System.out.println(5);
			}
			if (startTime == null) {
				errorMsg.put("errorStartTime", "開始時間必須輸入");
				System.out.println(6);
			}
			if (endTime == null) {
				errorMsg.put("errorEndTime", "結束時間必須輸入");
				System.out.println(7);
			}
		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
			System.out.println(8);
		}
		// 如果有錯誤
		if (!errorMsg.isEmpty()) {
			System.out.println("error");
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request
					.getRequestDispatcher("CreatGroup.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			// 4. 進行Business Logic運算
			// 4.1.檢查房間
			// 4.2.儲存資料
			GroupService service = new GroupService();
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"model-config1-DriverManagerDataSource.xml");
			GroupRoomDAO_Interface gdao = 
					(GroupRoomDAO_Interface) context.getBean("GroupRoomDAO");
			StoreInformationDAO_Interface sdao = 
					(StoreInformationDAO_Interface) context.getBean("StoreInformationDAO");
			Joiner_InfoDAO_Interface jdao = 
					(Joiner_InfoDAO_Interface) context.getBean("Joiner_InfoDAO");
			GroupChoiceGamesDAO_Interface gcdao = 
					(GroupChoiceGamesDAO_Interface) context.getBean("GroupChoiceGamesDAO");
			BoardGameKindDAO_Interface bcdao = 
					(BoardGameKindDAO_Interface) context.getBean("BoardGameKindDAO");
			BoardGamesDAO_Interface bgcdao = 
					(BoardGamesDAO_Interface) context.getBean("BoardGamesDAO");
			GroupRoom bean = new GroupRoom();
			//店家會員號碼
			StoreMember sbean = new StoreMember();
			StoreInformation store = sdao.findByPrimeKey(boardGameStore);
			sbean.setStoreMemberId(store.getStoreMember().getStoreMemberId());
			//會員
			Member mbean = new Member();
			mbean = (Member) session.getAttribute("Member");
			
			bean.setStoreMember(sbean);
			bean.setStoreName(sdao.findByPrimeKey(boardGameStore).getStoreName());
			bean.setMember(mbean);
			bean.setGroupStartTime(new Date());
			bean.setGroupEndTime(service.addDays(new Date(), 7));
			bean.setGroupRoomName(roomName);
			bean.setGroupString(roomString);
			bean.setGroupSuggestNumber(roomNumber);
			//房間上下限人數
			List<Integer> listRoomNum = service.dismantle(roomNumber);
			int lower = listRoomNum.get(0);
			int upper = listRoomNum.get(1);
			
			bean.setGroupLowerLimit(lower);
			bean.setGroupUpperLimit(upper);
			bean.setReserveGroupStartTime(service.convertDate(startTime));
			bean.setReserveGroupEndTime(service.convertDate(endTime));
			
			String sub = //相差的小時數
					service.dateSubtract(service.convertDate(startTime), service.convertDate(endTime));
			bean.setGroupGameTime(service.convertDate("1970-01-01 "+sub+":00:00"));
			bean.setRoomState(0);
			bean.setImgFileName(filename);
			try {
				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				int nRead;
				byte[] data = new byte[1024];
				while ((nRead = is.read(data, 0, data.length)) != -1) {
					buffer.write(data, 0, nRead);
					buffer.flush();
				}
				data = buffer.toByteArray();
				is.close();
				bean.setPrivateGroupImage(data);;
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("輸入異常:發生於 CreateRoomServlet");
			}
				
			
			
			boolean isCreateRoom = service.addGroupRoom(bean);// 將GroupRoom bean寫入Database
			if (isCreateRoom) {
				msgOK.put("CreateOK",
						"<Font color='red'>創立房間成功</Font>");
				System.out.println("創立房間成功");
				session.setAttribute("GroupRoom", bean);
				
				//開始新增房間桌遊
				System.out.println("開始新增房間桌遊");
				GroupChoiceGames games = new GroupChoiceGames();
				BoardGameKind kinds = new BoardGameKind();
				List<GroupRoom> room = service.getGroupRooms(bean);
				
				for(String s : gamesName){
					kinds.setBoardGameSerialNumber(bgcdao.findNumberByGamesName(s));
					games.setBoardGameName(s);
					games.setBoardGameKind(kinds);
					games.setGroupRoom(room.get(0));
				}
				gcdao.insert(games);
				
				//增加開團者自己
				Joiner_Info joiner = new Joiner_Info();
				joiner.setGroupRoom(room.get(0));
				joiner.setJoinTime(new Date());
				joiner.setUsername(mbean.getUsername());
				jdao.insert(joiner);
				
				response.sendRedirect("CreatGroupResult.jsp");
				return;
			} else {
				errorMsg.put("errorNumberOfRoom",
						"預約時間人數到達上限(CreateRoomServlet)");
				System.out.println("預約時間人數到達上限(CreateRoomServlet)");
			}
			
			// 5.依照 Business Logic 運算結果來挑選適當的畫面
			if (!errorMsg.isEmpty()) {
				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
				RequestDispatcher rd = request
						.getRequestDispatcher("CreatGroup.jsp");
				rd.forward(request, response);
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIDDup", e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("CreatGroup.jsp");
			rd.forward(request, response);
		}
	}
}
