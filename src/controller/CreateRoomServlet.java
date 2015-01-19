package controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
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

import model.GroupRoom;
import model.Member;
import model.Interface.GroupRoomDAO_Interface;
import model.Interface.MemberDAO_Interface;
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
		System.out.println(123);
		// 準備存放錯誤訊息的Map物件
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示常訊息
		
		String roomName = "";
		String[] boardGameStore = null;
		String[] gamesType = null;
		String[] gamesName = null;
		String roomNumber = "";
		String startTime = "";
		String endTime = "";
		String roomImg = "";
		String roomString = "";
		String filename="";
		long sizeInBytes = 0;
		InputStream is = null;

		Collection<Part> parts = request.getParts(); // 取出HTTP multipart
														// request內所有的parts
		// GlobalService.exploreParts(parts, request);
		// 由parts != null來判斷此上傳資料是否為HTTP multipart request
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				String[] value2 = request.getParameterValues(fldName);
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("roomName")) {
						roomName = value;
						System.out.println("roomName:"+value);
					} else if (fldName.equals("boardGameStore")) {
						boardGameStore = value2;
						System.out.println(value2);
					} else if (fldName.equalsIgnoreCase("gamesType")) {
						gamesType = value2;
						for(String s : value2){
							System.out.println(s);
						}
					} else if (fldName.equalsIgnoreCase("games")) {
						gamesName = value2;
						for(String s : value2){
							System.out.println(s);
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
					} else if (fldName.equalsIgnoreCase("roomImg")) {
						roomImg = value;
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
					}
				}
			}
			// 2. 進行必要的資料轉換
			// 3. 檢查使用者輸入資料
			if (roomName == null || roomName.trim().length() == 0) {
				errorMsg.put("errorRoomName", "團名必須輸入");
			}
			if (boardGameStore == null) {
				errorMsg.put("errorBoardGameStore", "店家必須輸入");
			}
			if (gamesType == null) {
				errorMsg.put("errorGamesType", "類別必須輸入");
			}
			if (gamesName == null) {
				errorMsg.put("errorGamesName", "桌遊必須輸入");
			}
			if (roomNumber == null) {
				errorMsg.put("errorRoomNumber", "人數必須輸入");
			}
			if (startTime == null) {
				errorMsg.put("errorStartTime", "開始時間必須輸入");
			}
			if (endTime == null) {
				errorMsg.put("errorEndTime", "結束時間必須輸入");
			}
		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}
		// 如果有錯誤
		if (!errorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request
					.getRequestDispatcher("CreatGroup.jsp");
			rd.forward(request, response);
			return;
		}
//		try {
//			// 4. 進行Business Logic運算
//
//			// 4.1.檢查房間
//			// 4.2.儲存資料
//			GroupService service = new GroupService();
//			ApplicationContext context = new ClassPathXmlApplicationContext(
//					"model-config1-DriverManagerDataSource.xml");
//			GroupRoomDAO_Interface gdao = 
//					(GroupRoomDAO_Interface) context.getBean("GroupRoomDAO");
//			Member bean = new Member();
//			bean.setUsername(username);
//			List<Member> m1 = service.getOneMember(bean);
//			System.out.println(m1);
//			String temp_username;
//			String table_username = null;
//			temp_username = bean.getUsername();
//			for (Member vo : m1) {
//				System.out.println(vo.getMemberId());
//				System.out.println(vo.getUsername());
//				table_username = vo.getUsername();
//			}
//			if (temp_username.equals(table_username)) {
//				System.out.println("雞蛋!!!!");
//				errorMsg.put("errorUserNameDup", "此帳號已存在，請換個帳號");
//			} else {
//				System.out.println("對歐~跑進來囉!!!!");
//				bean = new Member();
//				bean.setUsername(username);
//				bean.setPswd(pswd.getBytes());
//				bean.setEmail(email);
//				bean.setLastname(lastname);
//				bean.setFirstname(firstname);
//				bean.setGender(gender);
//				bean.setNickname(nickname);
//				bean.setBirthday(java.sql.Date.valueOf(birthday));
//				bean.setIdCard(idCard);			
//				bean.setJoinDate(new java.sql.Timestamp(java.sql.Date.valueOf(joinDate).getTime()));
//				bean.setPhone(phone);
//				bean.setMemberAddress(memberAddress);
//				bean.setImgFileName(filename);
//				try {
//					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//					int nRead;
//					byte[] data = new byte[1024];
//					while ((nRead = is.read(data, 0, data.length)) != -1) {
//						buffer.write(data, 0, nRead);
//						buffer.flush();
//					}
//					data = buffer.toByteArray();
//					is.close();
//					bean.setMemberImage(data);
//				} catch (IOException e) {
//					e.printStackTrace();
//					System.err.println("輸入異常:發生於 MemberRegisterServlet");
//				}
//				// 將MemberBean bean立即寫入Database
//				service.addMember(bean);
//				List<Member> result = service.getOneMember(bean);
//				if (result != null) {
//					msgOK.put("InsertOK",
//							"<Font color='red'>新增成功，請開始使用本系統</Font>");
//					session.setAttribute("Member", bean);
//					response.sendRedirect(".jsp");
//					// RequestDispatcher rd = request
//					// .getRequestDispatcher("ShowMyMemberData.jsp");
//					// rd.forward(request, response);
//					return;
//				} else {
//					errorMsg.put("errorUserNameDup",
//							"新增此筆資料有誤(MemberRegisterServlet)");
//				}
//			}
//			// 5.依照 Business Logic 運算結果來挑選適當的畫面
//			if (!errorMsg.isEmpty()) {
//				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
//				RequestDispatcher rd = request
//						.getRequestDispatcher("register.jsp");
//				rd.forward(request, response);
//				return;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			errorMsg.put("errorIDDup", e.getMessage());
//			RequestDispatcher rd = request
//					.getRequestDispatcher("register.jsp");
//			rd.forward(request, response);
//		}
	}
}
