package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.CancelRoomSuccessMail_creater;
import model.GroupRoom;
import model.service.GroupService;

@WebServlet("/StoreMemberCancelGroupServlet")
public class StoreMemberCancelGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("哈哈");
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		session.setAttribute("MsgOK", msgOK); // 顯示常訊息
		
		String roomId = request.getParameter("cancelbt00");
//		System.out.println(roomId);
		
		if(roomId!=null){
			int roomId_Int = Integer.valueOf(roomId);
			GroupService service = new GroupService();
			
			// 寄出通知信件
			GroupRoom gRoom = service.getOneGroupRoom(roomId_Int);// 拿到那間房間資料
			String roomName = gRoom.getGroupRoomName();// 拿出開團房名
			String storeName = gRoom.getStoreName();// 拿出開團房所使用的店家名
			Serializable nickName_Creater = gRoom.getMember().getNickname();// 拿出開團者暱稱
			String email = gRoom.getMember().getEmail();// 拿出開團者Email
			
			CancelRoomSuccessMail_creater mail = 
					new CancelRoomSuccessMail_creater("qaz22881757@gmail.com",
							"系統送發信件，您的團["+roomName+"]已被店家["+storeName+"]取消服務！",
							"親愛的"+nickName_Creater+"您好，很抱歉!本店因當天臨時有事，故無法營業，因此取消您所預約的租用場地服務，造成您的不便，敬請見諒。");
			mail.start();
			
			try {
				service.deleteGroupRoom(roomId_Int);// 試著刪除房間，當發生問題時try/catch會回報錯誤
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("刪除出現錯誤，發生在/TableGamesClub/src/controller/StoreMemberCancelGroupServlet.java");
			}
			
			// 刪除成功後導向成功頁面
			response.sendRedirect("/TableGamesClub/cancel-store-group-success.jsp");
			return;
		} else{
			response.sendRedirect("StoreMember-GroupInformation.jsp");
			return;
		}
	}
}
